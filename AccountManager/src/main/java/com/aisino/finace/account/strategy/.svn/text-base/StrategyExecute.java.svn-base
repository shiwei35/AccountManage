package com.aisino.finace.account.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aisino.finace.account.entity.Strategy;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;

/**
 * 执行策略
 * 
 * @author 春国
 *
 */
@Component
public class StrategyExecute {
	private static boolean isLoaded = false;
	private static boolean needReLoad = false;
	private Strategy strategy = null;
	private ParseStrategy parseStrategy = null;
	private static ExecuteAssistDecisionI access = null;

	public ParseStrategy getParseStrategy() {
		return parseStrategy;
	}

	@Autowired
	public void setParseStrategy(ParseStrategy parseStrategy) {
		this.parseStrategy = parseStrategy;
	}

	public void execute() {
		try {
			if (this.isLoaded == false || this.needReLoad == true) {
				byte[] bytes = createExecuteClass();
				DirectLoader s_classLoader = new DirectLoader();
				Class clas = s_classLoader.load(
						"com.aisino.finace.account.strategy.ExecuteAssistDecision",
						bytes);
				this.access=(ExecuteAssistDecisionI) clas.newInstance();
				
				this.needReLoad = false;
			}

			if (false == access.execute(null, null)) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private byte[] createExecuteClass() throws Exception {
		String script = null;
		CtClass clas = null;

		try {
			script = getStrategyScript();
			System.out.println("the Execute Body is:");
			System.out.println(script);
			ClassPool pool = ClassPool.getDefault();
			pool.insertClassPath(new ClassClassPath(this.getClass()));
			pool.importPackage("java.util");
			pool.importPackage("com.aisino.finace.account.strategy");

			if (isLoaded) {
				clas = pool
						.get("com.aisino.finace.account.strategy.ExecuteAssistDecision");
				if (clas.isFrozen()) {
					clas.detach();
					clas = null;
				}
			}
			isLoaded = true;
			clas = pool
					.makeClass("com.aisino.finace.account.strategy.ExecuteAssistDecision");
			clas.addInterface(pool
					.get("com.aisino.finace.account.strategy.ExecuteAssistDecisionI"));

			// add public default constructor method to class
			CtConstructor cons = new CtConstructor(new CtClass[] {}, clas);
			cons.setBody(";");
			clas.addConstructor(cons);

			// add public setTarget method
			CtMethod meth = new CtMethod(CtClass.booleanType, "execute",
					new CtClass[] { pool.get("java.util.List"),
							pool.get("java.util.List") }, clas);
			meth.setBody("{" + script + "}");
			clas.addMethod(meth);
			return clas.toBytecode();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void reloadStrategyScript() {
		this.needReLoad = true;
	}

	/**
	 * 获取执行脚本
	 * 
	 * @return
	 */
	private String getStrategyScript() {
		String script = "";

		this.parseStrategy.loadStrategy();
		this.strategy = this.parseStrategy.getStrategy();
		if (strategy != null) {
			script = strategy.getScripts();
		}

		return script;
	}
}
