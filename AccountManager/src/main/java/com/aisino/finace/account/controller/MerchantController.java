package com.aisino.finace.account.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerinfo;
import com.aisino.finace.account.service.MerchantServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping(value = "/org")
@SessionAttributes("user")
public class MerchantController {
	
	
	private MerchantServiceI merchantService = null;

	public MerchantServiceI getMerchantService() {
		return merchantService;
	}
	@Autowired
	public void setMerchantService(MerchantServiceI merchantService) {
		this.merchantService = merchantService;
	}

	//	@RequiresPermissions("SYS_MANAGE:USER_LIST")
	@RequestMapping(value = "merchantList")
	@ResponseBody
	public DataGrid getMerList(Page page, TmMerinfo merObj) {
		PageList<TmMerinfo> merList = null;
		DataGrid result = new DataGrid();

		try {
			merList = this.merchantService.getMerPageList(page, merObj);
			if (merList != null) {
				result.setTotal(Long.valueOf(merList.getPaginator()
						.getTotalCount()));
				result.setRows(merList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "toAddMer")
	public ModelAndView toAddMer() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("organization/modifyMer");
		modelView.addObject("flag", "ADD");
		return modelView;
	}
	

	@RequestMapping(value = "toUpdateMer")
	public ModelAndView toUpdateUser(TmMerinfo merObj) {
		try {
			merObj = this.merchantService.getMerByPriKey(merObj);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String date = sdf.format(merObj.getdMerexpdate());
			
			merObj.setdMerexpdate(sdf.parse(date));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("organization/modifyMer");
		modelView.addObject("flag", "UPDATE");
		modelView.addObject("merObj", merObj);
		
		
		return modelView;
	}
	
	
	@RequestMapping(value = "modifyMer" ,method=RequestMethod.POST)    
	@ResponseBody
	public Map<String, Object> modifyMer(TmMerinfo merObj,String flag) { 
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addMer(merObj);
		} else if ("UPDATE".equals(flag)) {
			result = updateMer(merObj);
		} else {
			result.put("success", false);
			result.put("msg", "用户信息添加异常，服务器端无法正常获取请求数据！");  
		}

		return result;
	}

	public HashMap<String, Object> addMer(TmMerinfo merObj) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			if (merObj != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				String date = sdf.format(merObj.getdMerexpdate());
				
				merObj.setdMerexpdate(sdf.parse(date));
				
				
				merObj.setTsSysupdate(new Date());
				
				merObj.setsIseffect("1");
				
				
				merObj.setdAcctregdate(new Date());
				
				merObj.setiMercode(new Long("1111111111"));
				this.merchantService.createMer(merObj);
				result.put("success", true);
				result.put("msg", "商户信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "商户信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常");
		}

		return result;
	}
	
	public Map<String, Object> updateMer(TmMerinfo merObj) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (merObj != null) {
				this.merchantService.updateMer(merObj);
				result.put("success", true);
				result.put("msg", "用户信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "用户信息修改失败，服务器端未获得要修改的用户信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "用户信息修改失败，服务器端处理异常！");
		}

		return result;
	}
	
	@RequestMapping(value = "deleteMer")
	@ResponseBody
	public Map<String, Object> deleteMer(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.merchantService.deleteMerByKeys(ids);

				result.put("success", true);
				result.put("msg", "商户信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "商户信息删除失败，服务器端未获得要删除的商户信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "商户信息删除失败，服务器端处理异常！");
		}

		return result;
	}
	
	
	
}