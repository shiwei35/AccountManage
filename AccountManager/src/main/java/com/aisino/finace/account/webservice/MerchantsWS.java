package com.aisino.finace.account.webservice;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/marchants")  
public class MerchantsWS { 
	
	final Logger logger = LoggerFactory.getLogger(MerchantsWS.class); 
	
	@ResponseBody 
	@RequestMapping(value = "/saveMers", method = RequestMethod.POST)         
	public String create(@RequestParam String  merchants) { 
	//public String create(HttpServletRequest req) { 
	//	String dd =  req.getContentType();
	 	JSONArray json=JSONArray.fromObject(merchants);  
		String info = json.toString().toLowerCase().replace("[", "").replace("]", "");
		
		String input = "{'d':'dddd'}";
		return input;   
	}

	public int saveMerchants(JSONArray json){
		
		
		return 0;
		
	}
}
