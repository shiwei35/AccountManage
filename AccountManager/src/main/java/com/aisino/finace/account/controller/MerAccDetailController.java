package com.aisino.finace.account.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aisino.finace.account.dao.RelationResolverDao;
import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.entity.TmMerinfo;
import com.aisino.finace.account.entity.TmMerservacctdetail;
import com.aisino.finace.account.service.MerAccDetailServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping(value = "/merAccDetail")
public class MerAccDetailController {
	private MerAccDetailServiceI merAccDetailService = null;

	public MerAccDetailServiceI getMerAccDetailService() {
		return merAccDetailService;
	}

	@Autowired
	public void setMerAccDetailService(MerAccDetailServiceI merAccDetailService) {
		this.merAccDetailService = merAccDetailService;
	}

	private RelationResolverDao relationResolverDao;
	public RelationResolverDao getRelationResolverDao() {
		return relationResolverDao;
	}
	@Autowired
	public void setRelationResolverDao(RelationResolverDao relationResolverDao) {
		this.relationResolverDao = relationResolverDao;
	}

	/***
	 * 分页，查询显示
	 * 
	 * @param page
	 *            param
	 * @return
	 */
	@RequestMapping(value = "merAccDetailList")
	@ResponseBody
	public DataGrid getParamList(Page page, TmMerservacctdetail param) {
		DataGrid result = new DataGrid();
		PageList<TmMerservacctdetail> paramList = null;

		try {
			paramList = this.merAccDetailService.getMerAccDetailPageList(page, param); 
			
			//处理对应关系
			//循环处理list中的id,找到对应的关联实体信息。返回到list中
			
		 	for(int i=0;i<paramList.size();i++){
				String iMercode =paramList.get(i).getsAcctcode();
				TmMerinfo merInfo = new TmMerinfo();
				merInfo=(TmMerinfo)relationResolverDao.getEntityInfo("TmMerinfo","iMercode", iMercode);
				paramList.get(i).setMerInfo(merInfo); 
			}
 
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
	public ModelAndView toUpdate(TmMerservacctdetail param) {
		TmMerservacctdetail currentParam = this.merAccDetailService.getMerAccDetailByPriKey(param);
		ModelAndView view = new ModelAndView();
		view.setViewName("accountManage/merAccDetailModify");
		view.addObject("flag", "UPDATE");
		view.addObject("currentParam", currentParam);
		return view;
	}

	@RequestMapping(value = "toAdd")
	@ResponseBody
	public ModelAndView toAdd() {
		ModelAndView view = new ModelAndView();
		view.setViewName("accountManage/merAccDetailModify");
		view.addObject("flag", "add");
		return view;
	}
	@RequestMapping(value = "modifyParam")
	@ResponseBody
	public String  addAndUpdate(TmMerservacctdetail param, String flag) { 
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (flag != null && !"".equals(flag)) {
				if(flag.equals("UPDATE")){
					param.setTsSysupdate(new Date()); 
					this.merAccDetailService.updateMerAccDetail(param);
				}else{
					param.setTsSysupdate(new Date()); 
					this.merAccDetailService.createMerAccDetail(param);
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
		JSONArray json = JSONArray.fromObject(result);  
		
		return json.toString();   
	}
	
	/**
	 * 删除
	 */
	

}
