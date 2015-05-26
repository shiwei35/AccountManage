package com.aisino.finace.account.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerservacctdetail;
import com.aisino.finace.account.entity.TmMsinfo;
import com.aisino.finace.account.service.MerAccDetailServiceI;
import com.aisino.finace.account.service.MsinfoServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping(value = "/msinfo")
public class MsinfoController {
	private MsinfoServiceI msinfoService = null;


	
	public MsinfoServiceI getMsinfoService() {
		return msinfoService;
	}



	@Autowired
	public void setMsinfoService(MsinfoServiceI msinfoService) {
		this.msinfoService = msinfoService;
	}



	/***
	 * 分页，查询显示
	 * 
	 * @param page
	 *            param
	 * @return
	 */
	@RequestMapping(value = "msinfoList")
	@ResponseBody
	public DataGrid getParamList(Page paramPage,TmMsinfo msinfo) {
		DataGrid result = new DataGrid();
		PageList<TmMsinfo> paramList = null;

		try {
			paramList = msinfoService.getTmMsinfoPageList(paramPage,msinfo); 
			if (paramList != null) {
				result.setRows(paramList);
				result.setTotal(Long.valueOf(paramList.getPaginator()
						.getTotalCount()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
/*
	@RequestMapping(value = "toUpdate")
	@ResponseBody
	public ModelAndView toUpdate(TmMsinfo param) {
		TmMsinfo msParam = this.msinfoService.getTmMsinfoByPriKey(param);
		ModelAndView view = new ModelAndView();
		view.setViewName("organization/modifyMs");
		view.addObject("flag", "UPDATE");
		view.addObject("msParam", msParam);
		return view;
	}

	@RequestMapping(value = "toAdd")
	@ResponseBody
	public ModelAndView toAdd() {
		ModelAndView view = new ModelAndView();
		view.setViewName("organization/modifyMs");
		view.addObject("flag", "add");
		return view;
	}
	@RequestMapping(value = "modifyParam")
	@ResponseBody
	public Map<String, Object> addAndUpdate(TmMsinfo param, String flag) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (flag != null && !"".equals(flag)) {
				if(flag.equals("UPDATE")){
					
					this.msinfoService.updateTmMsinfo(param);
					
				}else{
					
					this.msinfoService.createTmMsinfo(param);
				}
				result.put("success", true);
				result.put("msg", "明细保存成功！");
			} else {
				result.put("success", false);
				result.put("msg", "明细保存保存失败，未从客户端获取到数据！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "明细保存失败，服务器端处理异常！");
		}
		return result;
	}*/
	
	/**
	 * 删除
	 */
	
	
}
