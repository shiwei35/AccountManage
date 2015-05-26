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
import com.aisino.finace.account.entity.TcIssuserchkacct;
import com.aisino.finace.account.service.AnalyseServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


@Controller
@RequestMapping(value = "/analyse")
@SessionAttributes("user")
public class AnalyseController {
	private AnalyseServiceI analyseService = null;

	@Autowired
	public void setAnalyseService(AnalyseServiceI analyseService) {
		this.analyseService = analyseService;
	}
	/***
	 * 分页，查询显示
	 * 
	 * @param page
	 *            param
	 * @return 
	 */
	@RequestMapping(value = "analyseList")
	@ResponseBody
	public DataGrid getAnalyseList(Page page, String sIssuerusercode,String dChkacctdate) {
		DataGrid result = new DataGrid();
		PageList<TcIssuserchkacct> paramList = null;

	
		try {
			paramList = this.analyseService.getAnalyseList(page, sIssuerusercode,dChkacctdate);
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
