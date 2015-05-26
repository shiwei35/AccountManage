package com.aisino.finace.account.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aisino.finace.account.strategy.StrategyExecute;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	private StrategyExecute strategyExecute = null;

	public StrategyExecute getStrategyExecute() {
		return strategyExecute;
	}

	@Autowired
	public void setStrategyExecute(StrategyExecute strategyExecute) {
		this.strategyExecute = strategyExecute;
	}

	@RequestMapping(value = "uploadTest")
	@ResponseBody
	public Map<String, Object> toAddDict(@RequestParam String fileName,
			@RequestParam("mFile") CommonsMultipartFile[] files,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (files != null) {
				System.out.println("==========>>>>" + fileName);
				String path = request.getSession().getServletContext()
						.getRealPath("./attach/case");
				File file = new File(path);

				if (!file.exists() && !file.isDirectory()) {
					file.mkdirs();
				}
				for (MultipartFile tmpFile : files) {
					String newFileName = tmpFile.getOriginalFilename();
					FileCopyUtils.copy(tmpFile.getBytes(), new File(path + "/"
							+ newFileName));

					result.put("success", true);
					result.put("msg", "附件上传成功！");
				}
			} else {
				result.put("success", false);
				result.put("msg", "附件上传失败,此附件与案件已有附件同名，请检查附件信息后再上传！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "1附件上传失败,此附件与案件已有附件同名，请检查附件信息后再上传！");
		}

		return result;
	}

	@RequestMapping("download")
	public ResponseEntity<byte[]> download(HttpServletRequest request)
			throws IOException {
		String path = request.getSession().getServletContext()
				.getRealPath("./attach/case");
		File file = new File(path + "/张三测试.docx");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", new String(
				"张三测试.docx".getBytes("utf-8"), "ISO8859-1"));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "executeStrategy")
	@ResponseBody
	public Map<String, Object> executeStrategy() {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			this.strategyExecute.execute();
			result.put("success", true);
			result.put("msg", "执行成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "执行失败");
		}

		return result;
	}
	
	@RequestMapping(value = "reExecuteStrategy")
	@ResponseBody
	public Map<String, Object> reExecuteStrategy() {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			this.strategyExecute.reloadStrategyScript();
			this.strategyExecute.execute();
			result.put("success", true);
			result.put("msg", "执行成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "执行失败");
		}

		return result;
	}
}
