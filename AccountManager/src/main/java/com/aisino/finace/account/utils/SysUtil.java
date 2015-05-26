package com.aisino.finace.account.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.aisino.finace.account.entity.Page;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public class SysUtil {
	public static PageBounds convertPage(Page page) {
		if (page == null)
			return null;

		return new PageBounds(page.getPage(), page.getRows(),
				new Order[] { new Order(page.getSort(),
						Order.Direction.fromString(page.getOrder()), null) });
	}

	public static String dealOrderby(Page page, String attrStr, String fieldStr) {
		String orderByStr = "";
		String sortAttr = page.getSort();
		String order = page.getOrder();
		String[] attrs = null;
		String[] fields = null;

		if ((attrStr != null) && (!"".equals(attrStr.trim()))) {
			attrs = attrStr.split(",");
		}
		if ((fieldStr != null) && (!"".equals(fieldStr.trim()))) {
			fields = fieldStr.split(",");
		}
		if ((attrs == null) || (fields == null))
			return "";
		if ((sortAttr == null) || ("".equals(sortAttr.trim()))) {
			return "";
		}
		if ((order == null) || ("".equals(order.trim()))) {
			order = "asc";
		}
		for (int i = 0; i < attrs.length; i++) {
			if (sortAttr.equals(attrs[i])) {
				orderByStr = fields[i] + " " + order;
			}
		}

		return orderByStr;
	}

	/**
	 * MD5加密算法
	 * 
	 * @param encryptStr
	 * @return
	 */
	public static String encryptByMd5(String encryptStr) {
		String md5String = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(encryptStr.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			md5String = buf.toString();// 32位的加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// System.out.println(md5String);
		return md5String;
	}
}