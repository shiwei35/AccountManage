package com.aisino.finace.account.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Repository;

import com.aisino.finace.account.entity.Strategy;
import com.aisino.finace.account.strategy.model.Attribute;
import com.aisino.finace.account.strategy.model.Branch;
import com.aisino.finace.account.strategy.model.Result;

/**
 * 解析策略信息
 * 
 * @author 春国
 *
 */
@Repository
public class ParseStrategy {
	private String scripts = "";
	private List<Attribute> inVariableList = null;
	private List<Attribute> outVariableList = null;
	private List<Attribute> scoreList = null;
	private Strategy strategy = null;

	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * 加载策略信息
	 */
	public void loadStrategy() {
		this.strategy = new Strategy();
		String scripts = "System.out.println(\"the first test of dynamic execute.\");";
		scripts += "return true;";
		parseStrategy();
		strategy.setScripts(scripts);
	}

	private void parseStrategy() {
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new File(this.strategy.getStgFileName()));
			
//			document = DocumentHelper.parseText(this.strategy.getStgContent()); // 将字符串转为XML
			
			// 获取根元素
			Element root = document.getRootElement();

			// 处理输入变量
			Element inVariables = root.element("InVariable");
			scripts += parseInVariables(inVariables);

			// 处理输出变量
			Element outVariables = root.element("OutVariable");
			scripts += parseOutVariables(outVariables);

			// 初始化其他变量
			scripts += initOtherVariables();

			// 处理评分模型
			Element scores = root.element("Scores");
			List<Element> scoreCardList = scores.elements("ScoreCard");
			Element scoreCard = null;
			scoreList = new ArrayList<Attribute>();
			scripts += "scoreMap = new HashMap();\r";
			for (int i = 0; i < scoreCardList.size(); ++i) {
				scoreCard = (Element) scoreCardList.get(i);
				scripts += parseScoreCard(scoreCard);
			}
			scripts += "decisionResult.setScoreResultMap(scoreMap);\r";

			// 處理策略樹
			Element decisionTree = root.element("DecisionTree");
			scripts += parseDecisionTree(decisionTree);

			// 輸出變量
			scripts += generateResultMap();

			this.strategy.setScripts(this.scripts);
			System.out.println("scripts: ");
			System.out.println(scripts);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private String parseInVariables(Element inVariables) {
		String inVariablesStr = "";
		String type = null;
		String name = null;
		String desc = null;
		String defaultValue = null;
		Attribute attr = null;
		Element field = null;

		inVariableList = new ArrayList<Attribute>();
		for (Iterator iterator = inVariables.elementIterator(); iterator
				.hasNext();) {
			field = (Element) iterator.next();
			name = field.attributeValue("name");
			desc = field.attributeValue("desc");
			type = field.attributeValue("type");
			defaultValue = field.attributeValue("defaultValue");
			if ("C".equals(type)) {
				inVariablesStr += "String " + name
						+ " = (String)inputMap.get(\"" + name + "\");\r";
			} else if ("N".equals(type)) {
				inVariablesStr += "float " + name + " = (float)inputMap.get(\""
						+ name + "\");\r";
			}

			attr = new Attribute();
			attr.setName(name);
			attr.setDesc(desc);
			attr.setType(type);
			attr.setDefaultValue(defaultValue);
			attr.setSource("I");
			inVariableList.add(attr);
		}
		System.out.println("=============>>>>>>>>>>>>.");
		System.out.println(inVariablesStr);

		return inVariablesStr;
	}

	private String parseOutVariables(Element outVariables) {
		String outVariablesStr = "";
		String type = null;
		String name = null;
		String desc = null;
		String defaultValue = null;
		Attribute attr = null;
		Element field = null;

		outVariableList = new ArrayList<Attribute>();
		for (Iterator iterator = outVariables.elementIterator(); iterator
				.hasNext();) {
			field = (Element) iterator.next();
			name = field.attributeValue("name");
			desc = field.attributeValue("desc");
			type = field.attributeValue("type");
			defaultValue = field.attributeValue("defaultValue");
			if ("C".equals(type)) {
				if ("".equals(defaultValue)) {
					outVariablesStr += "String " + name + " = null;\r";
				} else {
					outVariablesStr += "String " + name + " = \""
							+ defaultValue + "\";\r";
				}
			} else if ("N".equals(type)) {
				if ("".equals(defaultValue)) {
					outVariablesStr += "float " + name + " = 0F;\r";
				} else {
					outVariablesStr += "float " + name + " = " + defaultValue
							+ "F;\r";
				}
			}

			attr = new Attribute();
			attr.setName(name);
			attr.setDesc(desc);
			attr.setType(type);
			attr.setDefaultValue(defaultValue);
			attr.setSource("O");
			outVariableList.add(attr);
		}
		System.out.println("=============>>>>>>>>>>>>.");
		System.out.println(outVariablesStr);

		return outVariablesStr;
	}

	private String initOtherVariables() {
		String otherVariablesStr = "";

		otherVariablesStr += "List scoreExcludes = null;\r";
		otherVariablesStr += "List treeExcludes = null;\r";
		otherVariablesStr += "Map scoreMap = null;\r";
		otherVariablesStr += "Map resultMap = null;\r";
		otherVariablesStr += "ExcludeInfo exclude = null;\r";
		otherVariablesStr += "ScoreResult scoreResult = null;\r";
		otherVariablesStr += "DecisionResult decisionResult = new DecisionResult();\r";

		return otherVariablesStr;
	}

	private String parseScoreCard(Element scoreCard) {
		String scoreCardStr = "";
		String name = null;
		String minStr = null;
		String maxStr = null;
		Attribute attr = null;
		Element excludeCond = null;
		Element scoreCal = null;

		name = scoreCard.attributeValue("name");
		minStr = scoreCard.attributeValue("min");
		maxStr = scoreCard.attributeValue("max");
		excludeCond = scoreCard.element("ExcludeCond");
		scoreCal = scoreCard.element("ScoreCal");
		scoreCardStr += "float " + name + " = 0F;\r";
		scoreCardStr += "scoreExcludes = new ArrayList();\r";
		scoreCardStr += parseScoreCardExcludeCond(excludeCond);
		scoreCardStr += parseScoreCal(scoreCal, name);

		// 最後根據最大值最小值設置評分
		scoreCardStr += "if(" + name + " < " + minStr + ") " + name + " = "
				+ minStr + ";\r";
		scoreCardStr += "if(" + name + " > " + maxStr + ") " + name + " = "
				+ maxStr + ";\r";
		scoreCardStr += "scoreResult=new ScoreResult();\r";
		scoreCardStr += "scoreResult.setName(\"" + name + "\");\r";
		scoreCardStr += "scoreResult.setScore(" + name + ");\r";
		scoreCardStr += "scoreResult.setExcludes(scoreExcludes);\r";
		scoreCardStr += "scoreMap.put(\"" + name + "\",scoreResult);\r";

		attr = new Attribute();
		attr.setName(name);
		attr.setSource("S");
		attr.setType("N");
		scoreList.add(attr);
		System.out.println("=============>>>>>>>>>>>>.");
		System.out.println(scoreCardStr);

		return scoreCardStr;
	}

	private String parseScoreCardExcludeCond(Element excludeCond) {
		String excludeCondStr = "";
		String var = null;
		String scope = null;
		String reasonCode = null;
		String reason = null;
		Element condition = null;
		Attribute condAttr = null;

		for (Iterator iterator = excludeCond.elementIterator(); iterator
				.hasNext();) {
			condition = (Element) iterator.next();
			var = condition.attributeValue("var");
			scope = condition.attributeValue("scope");
			reasonCode = condition.attributeValue("reasonCode");
			reason = condition.attributeValue("reason");
			condAttr = getAttribute(var);
			// if(condAttr==null) 記錄錯誤信息

			String[] scopes = scope.split(",");

			excludeCondStr += "if(";
			if ("C".equals(condAttr.getType())) {
				for (int i = 0; i < scopes.length; ++i) {
					if (i != 0)
						excludeCondStr += " || ";
					excludeCondStr += var + ".equals(\"" + scopes[i] + "\")";
				}
			} else if ("N".equals(condAttr.getType())) {
				for (int i = 0; i < scopes.length; ++i) {
					if (i != 0)
						excludeCondStr += " || ";
					excludeCondStr += var + " == " + scopes[i];
				}
			}
			excludeCondStr += "){\r";
			excludeCondStr += "exclude=new ExcludeInfo();\r";
			excludeCondStr += "exclude.setVariable(\"" + var + "\");\r";
			if ("C".equals(condAttr.getType())) {
				excludeCondStr += "exclude.setValue(" + var + ");\r";
			} else if ("N".equals(condAttr.getType())) {
				excludeCondStr += "exclude.setValue(String.valueOf(" + var
						+ "));\r";
			}
			excludeCondStr += "exclude.setReasonCode(\"" + reasonCode
					+ "\");\r";
			excludeCondStr += "exclude.setReason(\"" + reason + "\");\r";
			excludeCondStr += "scoreExcludes.add(exclude);\r";
			excludeCondStr += "}\r";
		}

		return excludeCondStr;
	}

	private String parseScoreCal(Element scoreCal, String name) {
		String scoreCalStr = "";
		String singleScoreCalStr = "";
		boolean isFirstItem = true;
		String var = null;
		String type = null;
		String scope = null;
		String radio = null;
		String score = null;
		Attribute scoreAttr = null;
		Element segment = null;
		Element item = null;

		for (Iterator iterator = scoreCal.elementIterator(); iterator.hasNext();) {
			segment = (Element) iterator.next();
			var = segment.attributeValue("var");
			scoreAttr = getAttribute(var);
			// if(condAttr==null) 記錄錯誤信息

			isFirstItem = true;
			for (Iterator itemIterator = segment.elementIterator(); itemIterator
					.hasNext();) {
				item = (Element) itemIterator.next();
				type = item.attributeValue("type");
				scope = item.attributeValue("scope");
				radio = item.attributeValue("radio");
				score = item.attributeValue("score");
				String[] scopes = scope.split(",");
				if (!isFirstItem)
					singleScoreCalStr += " else ";

				if ("O".equals(type)) {
					singleScoreCalStr += "{\r";
				} else {
					singleScoreCalStr += "if(";
					if ("C".equals(scoreAttr.getType())) {
						for (int i = 0; i < scopes.length; ++i) {
							if (i != 0)
								singleScoreCalStr += " || ";
							singleScoreCalStr += var + ".equals(\"" + scopes[i]
									+ "\")";
						}
					} else if ("N".equals(scoreAttr.getType())) {
						for (int i = 0; i < scopes.length; ++i) {
							if (i != 0)
								singleScoreCalStr += " || ";
							singleScoreCalStr += var + " == " + scopes[i];
						}
					}
					singleScoreCalStr += "){\r";
				}
				singleScoreCalStr += name + " += " + radio + " * " + score
						+ ";\r";
				singleScoreCalStr += "}";
				isFirstItem = false;
			}
			singleScoreCalStr += "\r";
			scoreCalStr += singleScoreCalStr;
		}

		return scoreCalStr;
	}

	private String parseDecisionTree(Element decisionTree) {
		String decisionTreeStr = "";
		Element excludeCond = null;
		Element tree = null;

		excludeCond = decisionTree.element("ExcludeCond");
		tree = decisionTree.element("Tree");
		decisionTreeStr = "treeExcludes = new ArrayList();\r";
		decisionTreeStr += parseDecisionTreeExcludeCond(excludeCond);
		decisionTreeStr += "decisionResult.setTreeExcludeList(treeExcludes);\r";
		decisionTreeStr += parseTree(tree);

		System.out.println("=============>>>>>>>>>>>>.");
		System.out.println(decisionTreeStr);

		return decisionTreeStr;
	}

	private String parseDecisionTreeExcludeCond(Element excludeCond) {
		String excludeCondStr = "";
		String var = null;
		String scope = null;
		String reasonCode = null;
		String reason = null;
		Element condition = null;
		Attribute condAttr = null;

		for (Iterator iterator = excludeCond.elementIterator(); iterator
				.hasNext();) {
			condition = (Element) iterator.next();
			var = condition.attributeValue("var");
			scope = condition.attributeValue("scope");
			reasonCode = condition.attributeValue("reasonCode");
			reason = condition.attributeValue("reason");
			condAttr = getAttribute(var);
			// if(condAttr==null) 記錄錯誤信息

			String[] scopes = scope.split(",");

			excludeCondStr += "if(";
			if ("C".equals(condAttr.getType())) {
				for (int i = 0; i < scopes.length; ++i) {
					if (i != 0)
						excludeCondStr += " || ";
					excludeCondStr += var + ".equals(\"" + scopes[i] + "\")";
				}
			} else if ("N".equals(condAttr.getType())) {
				for (int i = 0; i < scopes.length; ++i) {
					if (i != 0)
						excludeCondStr += " || ";
					excludeCondStr += var + " == " + scopes[i];
				}
			}
			excludeCondStr += "){\r";
			excludeCondStr += "exclude=new ExcludeInfo();\r";
			excludeCondStr += "exclude.setVariable(\"" + var + "\");\r";
			if ("C".equals(condAttr.getType())) {
				excludeCondStr += "exclude.setValue(\"" + var + "\")";
			} else if ("N".equals(condAttr.getType())) {
				excludeCondStr += "exclude.setValue(String.valueOf(" + var
						+ "));\r";
			}
			excludeCondStr += "exclude.setReasonCode(\"" + reasonCode
					+ "\");\r";
			excludeCondStr += "exclude.setReason(\"" + reason + "\");\r";
			excludeCondStr += "treeExcludes.add(exclude);\r";
			excludeCondStr += "}\r";
		}

		return excludeCondStr;
	}

	private String parseTree(Element tree) {
		String treeStr = "";
		String id = null;
		String var = null;
		String type = null;
		String scope = null;
		String isLeaf = null;
		String parentId = null;
		String resultVar = null;
		String resultValue = null;
		Branch tmpBranch = null;
		Result tmpResult = null;
		Element branch = null;
		Element result = null;
		Element item = null;
		List<Result> resultList = null;

		List<Branch> branchList = new ArrayList<Branch>();
		for (Iterator<Element> iterator = tree.elementIterator(); iterator
				.hasNext();) {
			branch = (Element) iterator.next();
			id = branch.attributeValue("id");
			var = branch.attributeValue("var");
			type = branch.attributeValue("type");
			scope = branch.attributeValue("scope");
			isLeaf = branch.attributeValue("isLeaf");
			parentId = branch.attributeValue("parentId");
			tmpBranch = new Branch();
			tmpBranch.setId(id);
			tmpBranch.setVar(var);
			tmpBranch.setType(type);
			tmpBranch.setScope(scope);
			tmpBranch.setIsLeaf(isLeaf);
			tmpBranch.setParentId(parentId);
			if ("Y".equals(isLeaf)) {
				result = branch.element("Result");
				resultList = new ArrayList<Result>();
				for (Iterator itemIterator = result.elementIterator(); itemIterator
						.hasNext();) {
					item = (Element) itemIterator.next();
					tmpResult = new Result();
					resultVar = item.attributeValue("var");
					resultValue = item.attributeValue("value");
					tmpResult.setVar(resultVar);
					tmpResult.setValue(resultValue);
					resultList.add(tmpResult);
				}
				tmpBranch.setResultList(resultList);
			}
			branchList.add(tmpBranch);
		}

		String otherBranchStr = "";
		String branchStr = "";
		Attribute branchAttr = null;
		Attribute resultAttr = null;
		for (int i = 0; i < branchList.size(); ++i) {
			tmpBranch = (Branch) branchList.get(i);
			if ("".equals(tmpBranch.getParentId())) {
				if ("O".equals(tmpBranch.getType())) {
					otherBranchStr += " else {\r";
					if ("Y".equals(tmpBranch.getIsLeaf())) {
						resultList = tmpBranch.getResultList();
						for (int j = 0; j < resultList.size(); ++j) {
							tmpResult = (Result) resultList.get(j);
							resultAttr = getAttribute(tmpResult.getVar());
							if ("C".equals(resultAttr.getType())) {
								otherBranchStr += tmpResult.getVar() + " = \""
										+ tmpResult.getValue() + "\";\r";
							} else if ("N".equals(resultAttr.getType())) {
								otherBranchStr += tmpResult.getVar() + " = "
										+ tmpResult.getValue() + ";\r";
							}
						}
					} else {
						otherBranchStr += parseChildBranch(tmpBranch,
								branchList);
					}
					otherBranchStr += "}";
				} else {
					branchAttr = getAttribute(tmpBranch.getVar());
					// if(branchAttr==null) 記錄錯誤信息

					if (i != 0) {
						branchStr += " else ";
					}
					String[] scopes = tmpBranch.getScope().split(",");
					branchStr += "if(";
					if ("C".equals(branchAttr.getType())) {
						for (int j = 0; j < scopes.length; ++j) {
							if (j != 0)
								branchStr += " || ";
							branchStr += tmpBranch.getVar() + ".equals(\""
									+ scopes[j] + "\")";
						}
					} else if ("N".equals(branchAttr.getType())) {
						for (int j = 0; j < scopes.length; ++j) {
							if (j != 0)
								branchStr += " || ";
							branchStr += tmpBranch.getVar() + " == "
									+ scopes[j];
						}
					}
					branchStr += "){\r";
					if ("Y".equals(tmpBranch.getIsLeaf())) {
						resultList = tmpBranch.getResultList();
						for (int j = 0; j < resultList.size(); ++j) {
							tmpResult = (Result) resultList.get(j);
							resultAttr = getAttribute(tmpResult.getVar());
							if ("C".equals(resultAttr.getType())) {
								branchStr += tmpResult.getVar() + " = \""
										+ tmpResult.getValue() + "\";\r";
							} else if ("N".equals(resultAttr.getType())) {
								branchStr += tmpResult.getVar() + " = "
										+ tmpResult.getValue() + ";\r";
							}
						}
					} else {
						branchStr += parseChildBranch(tmpBranch, branchList);
					}
					branchStr += "}";
				}
			}
		}
		if ("".equals(otherBranchStr)) {
			treeStr = branchStr + "\r";
		} else {
			treeStr = branchStr + otherBranchStr + "\r";
		}

		return treeStr;
	}

	/**
	 * 解析子樹節點
	 * 
	 * @param branch
	 * @param branchList
	 * @return
	 */
	private String parseChildBranch(Branch branch, List<Branch> branchList) {
		String childBranchStr = "";
		String otherChildBranchStr = "";
		Branch tmpBranch = null;
		Result tmpResult = null;
		List<Result> resultList = null;
		Attribute branchAttr = null;
		Attribute resultAttr = null;
		boolean isFirstItem = true;

		for (int i = 0; i < branchList.size(); ++i) {
			tmpBranch = (Branch) branchList.get(i);
			if (tmpBranch.getParentId().equals(branch.getId())) {
				if ("O".equals(tmpBranch.getType())) {
					otherChildBranchStr += " else {\r";
					if ("Y".equals(tmpBranch.getIsLeaf())) {
						resultList = tmpBranch.getResultList();
						for (int j = 0; j < resultList.size(); ++j) {
							tmpResult = (Result) resultList.get(j);
							resultAttr = getAttribute(tmpResult.getVar());
							if ("C".equals(resultAttr.getType())) {
								otherChildBranchStr += tmpResult.getVar()
										+ " = \"" + tmpResult.getValue()
										+ "\";\r";
							} else if ("N".equals(resultAttr.getType())) {
								otherChildBranchStr += tmpResult.getVar()
										+ " = " + tmpResult.getValue() + ";\r";
							}
						}
					} else {
						otherChildBranchStr += parseChildBranch(tmpBranch,
								branchList);
					}
					otherChildBranchStr += "}";
				} else {
					branchAttr = getAttribute(tmpBranch.getVar());
					// if(branchAttr==null) 記錄錯誤信息

					if (!isFirstItem) {
						childBranchStr += " else ";
					}
					String[] scopes = tmpBranch.getScope().split(",");
					childBranchStr += "if(";
					if ("C".equals(branchAttr.getType())) {
						for (int j = 0; j < scopes.length; ++j) {
							if (j != 0)
								childBranchStr += " || ";
							childBranchStr += tmpBranch.getVar() + ".equals(\""
									+ scopes[j] + "\")";
						}
					} else if ("N".equals(branchAttr.getType())) {
						for (int j = 0; j < scopes.length; ++j) {
							if (j != 0)
								childBranchStr += " || ";
							childBranchStr += tmpBranch.getVar() + " == "
									+ scopes[j];
						}
					}
					childBranchStr += "){\r";
					if ("Y".equals(tmpBranch.getIsLeaf())) {
						resultList = tmpBranch.getResultList();
						for (int j = 0; j < resultList.size(); ++j) {
							tmpResult = (Result) resultList.get(j);
							resultAttr = getAttribute(tmpResult.getVar());
							if ("C".equals(resultAttr.getType())) {
								childBranchStr += tmpResult.getVar() + " = \""
										+ tmpResult.getValue() + "\";\r";
							} else if ("N".equals(resultAttr.getType())) {
								childBranchStr += tmpResult.getVar() + " = "
										+ tmpResult.getValue() + ";\r";
							}
						}
					} else {
						childBranchStr += parseChildBranch(tmpBranch,
								branchList);
					}
					childBranchStr += "}";
				}

				isFirstItem = false;
			}
		}
		if ("".equals(otherChildBranchStr)) {
			childBranchStr = childBranchStr + "\r";
		} else {
			childBranchStr = childBranchStr + otherChildBranchStr + "\r";
		}

		return childBranchStr;
	}

	/**
	 * 生成結果字符串
	 * 
	 * @return
	 */
	private String generateResultMap() {
		String resultStr = "";
		Attribute outAttr = null;

		if (outVariableList != null) {
			resultStr += "resultMap = new HashMap();\r";
			for (int i = 0; i < outVariableList.size(); ++i) {
				outAttr = (Attribute) outVariableList.get(i);
				resultStr += "resultMap.put(\"" + outAttr.getName() + "\","
						+ outAttr.getName() + ");\r";
			}
			resultStr += "decisionResult.setResultMap(resultMap);\r";
		}

		return resultStr;
	}

	/**
	 * 通过变量名称，获取变量定义属性
	 * 
	 * @param name
	 * @return
	 */
	private Attribute getAttribute(String name) {
		Attribute attr = null;
		boolean isFind = false;

		for (int i = 0; i < this.inVariableList.size(); ++i) {
			attr = (Attribute) this.inVariableList.get(i);
			if (name.equals(attr.getName())) {
				isFind = true;
				return attr;
			}
		}

		for (int i = 0; i < this.outVariableList.size(); ++i) {
			attr = (Attribute) this.outVariableList.get(i);
			if (name.equals(attr.getName())) {
				isFind = true;
				return attr;
			}
		}

		for (int i = 0; i < this.scoreList.size(); ++i) {
			attr = (Attribute) this.scoreList.get(i);
			if (name.equals(attr.getName())) {
				isFind = true;
				return attr;
			}
		}

		if (!isFind)
			return null;

		return attr;
	}
}
