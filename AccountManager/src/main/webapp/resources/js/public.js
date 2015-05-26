/**
 * 通过数据字典名称和字典项编码查询字典项描述
 */
function getDictItem(dictName, itemCode) {
	var result = "";

	$.ajax({
		url : path + '/dict/getDictItem.do',
		data : {
			dictName : dictName,
			itemCode : itemCode
		},
		dataType : 'json',
		async : false,
		success : function(data) {
			if (data != null && data.itemTitle != null)
				result = data.itemTitle;
			else
				result = itemCode;

		}
	});

	return result;
}

/**
 * 通过字典项名称填充下拉框
 * 
 * @param comboboxId
 * @param dictName
 */
function initComboboxContent(comboboxId, dictName) {
	$("#" + comboboxId).combobox({
		url : path + '/dict/getDictItems.do?dictName=' + dictName,
		valueField : 'value',
		textField : 'title',
		editable : false,
		multiple : false,
		panelHeight : 80,
		required : true
	});
}

$.extend($.fn.validatebox.defaults.rules, {
	emptyString : {
		validator : function(value, param) {
			if ($(param[0]).combobox('getValue') == "") {
				return false;
			} else {
				return true;
			}
		},
		message : '该选择项为必选项。'
	},
	seqChk : {
		validator : function(value) {
			var reg = /^[1-9]\d{0,2}$/;
			return reg.test(value);
		},
		message : '请输入不超过三位数的正整数。'
	}
});

serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};
