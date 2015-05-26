package com.aisino.finace.account.controller;

import com.aisino.finace.account.entity.ComboOption;
import com.aisino.finace.account.entity.DataDictionary;
import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.MlDict;
import com.aisino.finace.account.entity.MlDictItem;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.service.DataDictServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/dict")
public class DataDictController {
	private DataDictServiceI dictService = null;

	public DataDictServiceI getDataDictService() {
		return this.dictService;
	}

	@Autowired
	public void setDataDictService(DataDictServiceI dictService) {
		this.dictService = dictService;
	}

	@RequestMapping(value="dictList")
	@ResponseBody
	public DataGrid getDataDictList(Page page, MlDict dict) {
		DataGrid result = new DataGrid();
		PageList<MlDict> dictlist = null;
		
		try {
			dictlist = this.dictService.getDictList(page, dict);
			if (dictlist.getPaginator().getTotalCount() != 0) {
				result.setTotal(Long.valueOf(dictlist.getPaginator()
						.getTotalCount()));
				result.setRows(dictlist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value="toAddDict")
	@ResponseBody
	public ModelAndView toAddDict() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("flag", "ADD");
		modelAndView.setViewName("config/modifyDict");
		return modelAndView;
	}

	@RequestMapping(value="toUpdateDict")
	@ResponseBody
	public ModelAndView toUpdateDict(MlDict dict) {
		try {
			dict = this.dictService.queryDictById(dict);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/modifyDict");
		modelAndView.addObject("dict", dict);
		modelAndView.addObject("flag", "UPDATE");
		return modelAndView;
	}

	@RequestMapping(value="modifyDict")
	@ResponseBody
	public Map<String, Object> modifyDict(MlDict dict, String flag) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addDict(dict);
		} else if ("UPDATE".equals(flag)) {
			result = updateDict(dict);
		} else {
			result.put("success", Boolean.valueOf(false));
			result.put("msg", "数据字典处理异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addDict(MlDict dict) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (dict != null) {
				this.dictService.createDict(dict);
				result.put("success", true);
				result.put("msg", "数据字典添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "数据字典添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常");
		}

		return result;
	}

	public Map<String, Object> updateDict(MlDict dict) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (dict != null) {
				this.dictService.updateDict(dict);
				result.put("success", Boolean.valueOf(true));
				result.put("msg", "数据字典修改成功！");
			} else {
				result.put("success", Boolean.valueOf(false));
				result.put("msg", "数据字典修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", Boolean.valueOf(false));
			result.put("msg", "数据字典修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value="deleteDict")
	@ResponseBody
	public Map<String, Object> deleteDept(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.dictService.deleteDict(ids);
				result.put("success", true);
				result.put("msg", "数据字典信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "数据字典信息删除失败，服务器端未获得要删除的数据字典信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "数据字典信息删除失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value="getDictItems")
	@ResponseBody
	public List<ComboOption> getDictItems(String dictName) {
		DataDictionary dataDictionary = this.dictService
				.getDictItemsByDictName(dictName);
		List<MlDictItem> dictItemList = dataDictionary.getDictItemList();
		List<ComboOption> comboOptionList = new ArrayList<ComboOption>();
		MlDictItem dictItem = null;
		ComboOption comboOption = null;
		comboOption = new ComboOption();
		comboOption.setTitle("请选择");
		comboOption.setValue("");
		comboOptionList.add(comboOption);
		if (dictItemList != null) {
			for (int i = 0; i < dictItemList.size(); i++) {
				dictItem = (MlDictItem) dictItemList.get(i);
				comboOption = new ComboOption();
				comboOption.setValue(dictItem.getItemCode());
				comboOption.setTitle(dictItem.getItemTitle());
				comboOptionList.add(comboOption);
			}
		}
		return comboOptionList;
	}

	@RequestMapping({ "getDictItem" })
	@ResponseBody
	public MlDictItem getDictItem(String dictName, String itemCode) {
		DataDictionary dataDictionary = this.dictService
				.getDictItemsByDictName(dictName);
		List dictItemList = dataDictionary.getDictItemList();

		MlDictItem dictItem = null;
		if (dictItemList != null) {
			for (int i = 0; i < dictItemList.size(); i++) {
				dictItem = (MlDictItem) dictItemList.get(i);
				if (itemCode.equals(dictItem.getItemCode())) {
					return dictItem;
				}
			}

		}

		return null;
	}
}