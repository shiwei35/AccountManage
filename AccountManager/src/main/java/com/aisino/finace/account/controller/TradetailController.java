package com.aisino.finace.account.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.Page;

import com.aisino.finace.account.entity.TvTradetail;
import com.aisino.finace.account.service.TradetailServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


@Controller
@RequestMapping(value = "/tradetail")
@SessionAttributes("user")
public class TradetailController {
	private TradetailServiceI tradetailService = null;

	@Autowired
	public void setTradetailService(TradetailServiceI tradetailService) {
		this.tradetailService = tradetailService;
	}
	/***
	 * 分页，查询显示
	 * 
	 * @param page
	 *            param
	 * @return 
	 */
	@RequestMapping(value = "tradetailList")
	@ResponseBody
	public DataGrid getAnalyseList(Page page, String sMeracct,String sTermcode,String dTransdate) {
		DataGrid result = new DataGrid();
		PageList<TvTradetail> paramList = null;

	
		try {
			paramList = this.tradetailService.getTradetaiList(page, sMeracct,sTermcode,dTransdate);
			if (paramList != null) {
				result.setRows(paramList);
				result.setTotal(Long.valueOf(paramList.getPaginator().getTotalCount()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


	
}
