package com.aisino.finace.account.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.MlSysParam;
import com.aisino.finace.account.entity.MlUser;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.service.ParamServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping(value = "/param")
@SessionAttributes("user")
public class ParamController {
	private ParamServiceI paramService = null;

	public ParamServiceI getParamService() {
		return paramService;
	}

	@Autowired
	public void setParamService(ParamServiceI paramService) {
		this.paramService = paramService;
	}

	/***
	 * 分页，查询显示
	 * 
	 * @param page
	 *            param
	 * @return
	 */
	@RequestMapping(value = "paramList")
	@ResponseBody
	public DataGrid getParamList(Page page, MlSysParam param) {
		DataGrid result = new DataGrid();
		PageList<MlSysParam> paramList = null;

		try {
			paramList = this.paramService.getParamList(page, param);
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

	@RequestMapping(value = "toUpdate")
	@ResponseBody
	public ModelAndView toUpdate(MlSysParam param) {
		MlSysParam currentParam = this.paramService.queryParamById(param);
		ModelAndView view = new ModelAndView();
		view.setViewName("config/modifyParam");
		view.addObject("flag", "UPDATE");
		view.addObject("currentParam", currentParam);
		return view;
	}

	@RequestMapping(value = "modifyParam")
	@ResponseBody
	public Map<String, Object> addAndUpdate(MlSysParam param, String flag,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (flag != null && !"".equals(flag)) {
				param.setOperId(user.getUserId());
				param.setOpTime(new Date());
				this.paramService.updateParam(param);
				
				result.put("success", true);
				result.put("msg", "参数信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "参数信息修改失败，未从客户端获取到数据！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "参数信息修改失败，服务器端处理异常！");
		}

		return result;
	}
}
