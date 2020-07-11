

function bindTel(obj){
	//只能输入数字
	var ctrl=false;
	obj.keydown(function(e){
		if (obj.val().length >= 11 && e.keyCode != 8){
			return false;
		}
		if((e.keyCode>=48&&e.keyCode<=57)||(e.keyCode>=96&&e.keyCode<=105)){
			return true;
		}
		else if (e.keyCode == 37 || e.keyCode == 39){
			return true;
		}
		else if(e.keyCode==8){
			return true;
		}
		else if(e.keyCode==9){
			return true;
		}
		else if(e.keyCode==17){
			ctrl=true;
			return true;
		}
		else if(e.keyCode==86&&ctrl==true){
			return true;
		}
		else{
			return false;
		}
		return true;
		
	});
	
};

function isPhone(value){
	var phoneReg = new RegExp("^[1][0-9]{10}$");
	return phoneReg.test(value);
};

function bindInputValid(){
	$("input[data-valid='int']").on('input propertychange', function(e){
		var val = $(this).val().replace(/\D/g,'');
		$(this).val(val);
	});
	$("input[data-valid='number']").on('input propertychange', function(e){
		var val = $(this).val();
		var fix = $(this).attr("data-number-fix") || 2;
		var numberReg = new RegExp("\\d*\\.?\\d{0,"+fix+"}", "g");
		var val = numberReg.exec(val);
		if (val == null){
			val = 0;
		}else{
			val = val[0];
		}
		$(this).val(val);
	});
}

function checkInputValid(){
	$("input[data-valid='int']").each(function(index, element){
		var val = $(element).val();
		if (isNaN(parseInt(val))){
			return element;
		}
	});
	$("input[data-valid='number']").each(function(index, element){
		var val = $(element).val();
		var fix = $(this).attr("data-number-fix") || 2;
		if (isNaN(parseFloat(val))){
			return element;
		}else{
			$(this).val(1*parseFloat(val).toFixed(fix));
		}
	});
	return null;
}


function htmlDecode(value){
	value = $('<div/>').html(value).text();
	return value;
};

function htmlEncode(value){
	value = $('<div/>').text(value).html();
	return value;
};
