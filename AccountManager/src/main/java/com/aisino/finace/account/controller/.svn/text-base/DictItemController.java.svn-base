package com.aisino.finace.account.controller;

import com.aisino.finace.account.entity.DataGrid;
import com.aisino.finace.account.entity.MlDict;
import com.aisino.finace.account.entity.MlDictItem;
import com.aisino.finace.account.entity.Page;
import com.aisino.finace.account.service.DataDictServiceI;
import com.aisino.finace.account.service.DictItemServiceI;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/dictItem")
public class DictItemController {
	private DictItemServiceI dictItemService = null;
	private DataDictServiceI dataDictService = null;

	public DictItemServiceI getDictItemService() {
		return this.dictItemService;
	}

	@Autowired
	public void setDictItemService(DictItemServiceI dictItemService) {
		this.dictItemService = dictItemService;
	}

	public DataDictServiceI getDataDictService() {
		return this.dataDictService;
	}

	@Autowired
	public void setDataDictService(DataDictServiceI dataDictService) {
		this.dataDictService = dataDictService;
	}

	@RequestMapping(value = "toItemList")
	@ResponseBody
	public ModelAndView toItemList(MlDict dict) {
		ModelAndView view = new ModelAndView();
		dict = this.dataDictService.queryDictById(dict);
		view.addObject("dictTitle",
				dict.getDictTitle() + "-" + dict.getDictDesc());
		view.setViewName("config/dictItemList");
		view.addObject("dict", dict);

		return view;
	}

	@RequestMapping(value = "itemList")
	@ResponseBody
	public DataGrid geItemtList(Page page, MlDictItem item) {
		DataGrid result = new DataGrid();
		PageList<MlDictItem> list = null;
		
		try {
			list = this.dictItemService.getDictItemList(page, item);
			if (list.getPaginator().getTotalCount() != 0) {
				result.setTotal(Long.valueOf(list.getPaginator()
						.getTotalCount()));
				result.setRows(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "toAddItem")
	public ModelAndView toAddItem(MlDictItem item) {
		ModelAndView view = new ModelAndView();
		view.setViewName("config/modfiyDictItem");
		view.addObject("flag", "ADD");
		view.addObject("dictId", item.getDictId());
		return view;
	}

	@RequestMapping(value = "toUpdateItem")
	public ModelAndView toUpdateItem(MlDictItem item) {
		ModelAndView view = new ModelAndView();
		item = this.dictItemService.getDictItemById(item);
		view.setViewName("config/modfiyDictItem");
		view.addObject("item", item);
		view.addObject("flag", "UPDATE");
		view.addObject("dictId", item.getDictId());
		return view;
	}

	@RequestMapping(value = "modifyDictItem")
	@ResponseBody
	public Map<String, Object> modifyDict(MlDictItem dictItem, String flag) {
		Map<String, Object> result = null;

		if ("ADD".equals(flag)) {
			result = addDictItem(dictItem);
		} else if ("UPDATE".equals(flag)) {
			result = updateDictItem(dictItem);
		} else {
			result = new HashMap<String, Object>();
			result.put("success", false);
			result.put("msg", "数据字典项处理异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addDictItem(MlDictItem item) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (item != null) {
				this.dictItemService.creatDictItem(item);
				result.put("success", true);
				result.put("msg", "数据字典项添加成功！");
			} else {
				result.put("success", false);
				result.put("msg", "数据字典项添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateDictItem(MlDictItem item) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (item != null) {
				this.dictItemService.updateItem(item);
				result.put("success", true);
				result.put("msg", "数据字典项修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "数据字典项修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteDictItem")
	@ResponseBody
	public Map<String, Object> deleteDictItem(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.dictItemService.deleteItem(ids);
				result.put("success", true);
				result.put("msg", "数据字典项删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "没有获取到要删除的信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "删除失败，服务器端发生内部错误");
		}
		return result;
	}
}