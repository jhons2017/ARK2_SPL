/*
 * Client-side JavaScript API for WXHX Corp.
 */
 
//=============================================================================
//    禁止文字チェック関数
//         【入力】str: チェック対象文字列
//                 thisForm：フォーム名

//                 thisNAme：入力フィールドのname属性
//         【返却】真偽
//         【作成】NTTDATA SYSTEMS Corp.　伊藤
//         【概要】引数の文字列に特定の使用禁止文字が使用されていないかチェック
//                 (メッセージ表示、フォーカス制御を行う)
//                 呼出し例：<INPUT type="text" name="test" value="" onblur="chkChar_Fnc(this.value,this.form,this.name);" >
//=============================================================================
function chkChar(str, thisForm, thisName){
	//スペースカットについて
	eval("document." + thisForm + "." + thisName).value = eval("document." + thisForm + "." + thisName).value.trim();
	// 文字列が指定されていなければ戻る

	if(str == "") return true;
	if(!chkNgChars(str)){
		alert("「 " + chkChr + " 」は使用できません。");
		eval("document." + thisForm + "." + thisName).focus();
		return false;
	}
	// 使用禁止文字が含まれていない場合、false
	return true;
}

//=============================================================================
//    禁止文字チェック関数_処理本体

//         【入力】str: チェック対象文字列
//         【返却】真偽
//         【作成】NTTDATA SYSTEMS Corp.　伊藤
//         【概要】チェック処理本体

//                 (チェックのみ行い処理をコーディングする場合はこちらを呼び出す)
//=============================================================================
function chkNgChars(str){
	// 使用禁止文字の取得

	var ngChars = importChars();
	// 使用禁止文字のチェック
	chkCharLen = str.length;
	for(i = 0;i < chkCharLen;i++){
		var code = str.charCodeAt(i);
		var found = false;
		for(j=0; j<ngChars.length; j++) {
			if(code == ngChars[j]) {
				chkChr = str.substr(i,1);
				found = true;
				break;
			}
		}
		if(found) {
			return false;
		}
	}
	return true;
}

//=============================================================================
//    使用禁止文字の取得

//         【入力】なし

//         【返却】ngChars
//         【作成】NTTDATA SYSTEMS Corp.　伊藤
//         【概要】使用禁止文字の取得

//=============================================================================
function importChars(){
	//文字化けする文字一覧
	//∑‘,% 故障HI0010に応じて追加する
	/*\'&×∥ －

	① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ ⑩ ⑪ ⑫ ⑬ ⑭ ⑮ ⑯ ⑰ ⑱ ⑲ ⑳
	Ⅰ Ⅱ Ⅲ Ⅳ Ⅴ Ⅵ Ⅶ Ⅷ Ⅸ Ⅹ
	㍉ ㌔ ㌢ ㍍ ㌘ ㌧ ㌃ ㌶ ㍑ ㍗ ㌍ ㌦ ㌣ ㌫ ㍊ ㌻
	㎜ ㎝ ㎞ ㎎ ㎏ ㏄ ㎡ 〝〟

	№ ㏍ ℡
	㊤ ㊥ ㊦ ㊧ ㊨
	㈱ ㈲ ㈹ ㍾ ㍽ ㍼ ㍻
	∮ Σ ∟ ⊿
	*/
	var sKinsoku = "39;";
	// 禁止文字 '、&、×　を禁止とする。下行の文字列を書き換えることで禁止文字

	var ngArray = new Array();
	ngArray = sKinsoku.split(';');

	return ngArray;
}

//=============================================================================
//		正規表示チェック
//			【入力】slName:部品のHTML名前
//				 regexp:正規表示
//				 slMessage:部品の名前
//			【返却】なし

//			【作成】WXHX Corp.
//			【概要】正規表示チェック
//=============================================================================
function csRegexp(slName,regexp,slMessage) {
	if(bResult) {
		var slTemp = eval("document.forms[0]." + slName);
		var slValue = slTemp.value;
		var result=slValue.match(regexp);
		if(result==null && slValue != "") {
			alert(slMessage + "のフォーマットが無効です。");
			slTemp.select();
			bResult = false;
		}
	}
}

//=============================================================================
//		文字列がなしのチェック
//			【入力】slName:部品のHTML名前
//				　slMinLenth：一番少ない値
//				　slMaxLenth：一番大きい値
//				　slMessage：部品の名前
//			【返却】なし

//			【作成】WXHX Corp.
//			【概要】文字列の長さを取得

//=============================================================================
function csLength(slName,slMinLenth,slMaxLenth,slMessage) {
	if(bResult) {
		var slTemp = eval("document.forms[0]." + slName);
		var slValue = slTemp.value.trim();
		if(slValue != "" && slValue != null) {
			if (slValue.length > slMaxLenth) {
				alert(slMessage + slMaxLenth + "桁までを入力してください。");
				slTemp.select();
				bResult = false;
			} else if (slValue.length < slMinLenth) {
				alert(slMessage + slMinLenth + "桁からを入力してください。")
				slTemp.select();
				bResult = false;
			}
		}
	}
}


//=============================================================================
//		NULLのチェック
//			【入力】slName:部品のHTML名前
//				　slMessage：部品の名前
//			【返却】なし

//			【作成】WXHX Corp.
//			【概要】NULLのチェック
//=============================================================================
function csNull(slName,slMessage) {
	if(bResult) {
		var slTemp = eval("document.forms[0]." + slName);
		var slValue = slTemp.value.trim();
		if (slValue == null || slValue == "") {
			alert(slMessage + "を入力してください。");
			if(slTemp.type == "select-one") {
				slTemp.focus();
			} else {
				slTemp.value = slValue;
				slTemp.select();
			}
			bResult = false;
		}
	}
}

//=============================================================================
//		CheckboxはNULLのチェック
//			【入力】slName:部品のHTML名前
//				　slMessage：部品の名前
//			【返却】なし

//			【作成】WXHX Corp.
//			【概要】NULLのチェック
//=============================================================================
function csCheckboxNull(slName,slMessage) {
	if(bResult) {
		var slString = slName.split("/");
		var flg = false;
		for(i = 0; i < slString.length; i++) {
			var slTemp = eval("document.forms[0]." + slString[i]);
			if(slTemp.checked == true) {
				flg = true;
			}
		}
		if (flg == false) {
			alert(slMessage + "を入力してください。");
			bResult = false;
		}
	}
}

//=============================================================================
//		RadioはNULLのチェック
//			【入力】slName:部品のHTML名前
//				　slMessage：部品の名前
//			【返却】なし

//			【作成】WXHX Corp.
//			【概要】NULLのチェック
//=============================================================================
function csRadioNull(slName,slMessage) {
	if(bResult) {
		var flg = false;
		var slTemp = eval("document.forms[0]." + slName);
		flg = false;
		for(i = 0; i< slTemp.length; i++) {
			if(slTemp[i].checked) {
				flg = true;
				break;
			}
		}
		if(flg == false) {
			alert(slMessage + "を入力してください。");
			bResult = false;
		}
	}
}

//=============================================================================
//		日付のチェック
//			【入力】slName:部品のHTML名前
//				　slMessage：部品の名前
//			【返却】なし

//			【作成】WXHX Corp.
//			【概要】日付のチェック
//=============================================================================
function csDate(slName,slMessage) {
	var slTemp = eval("document.forms[0]." + slName);
	var slDate = slTemp.value.trim();
	slDate = slDate.trim();
	slDate = slDate.replace(/\//g,"");
	if(slDate.length == 6) {
		slDate = slDate.substr(0,2) + "/" + slDate.substr(2, 2) + "/" + slDate.substr(4, 2);
		if(!csDateChk(slDate)){
			alert(slMessage + "の入力に誤りがあります。");
			slTemp.select();
			bResult = false;
		}
	} else if (slDate.length == 8) {
		slDate = slDate.substr(2,2) + "/" + slDate.substr(4, 2) + "/" + slDate.substr(6, 2);
		if(!csDateChk(slDate)){
			alert(slMessage + "の入力に誤りがあります。");
			slTemp.select();
			bResult = false;
		}
	} else {
		alert(slMessage + "の入力に誤りがあります。");
		slTemp.select();
		bResult = false;
	}
}

//=============================================================================
//		入力された値が日付でYYYY/MM/DD形式になっているか判断する
//			【入力】slDate
//			【返却】正：true　不正：false
//			【作成】WXHX Corp.
//			【概要】入力された値が日付でYYYY/MM/DD形式になっているか判断する
//=============================================================================
function csDateChk(slDate) {
	// 正規表現による書式チェック
	if(!slDate.match(/^\d{2}\/\d{2}\/\d{2}$/)){
		return false;
	}
	var slYear = "20" + slDate.substr(0, 2) - 0;
	// Javascriptは、0-11で表現
	var slMonth = slDate.substr(3, 2) - 1;
	var slDay = slDate.substr(6, 2) - 0;
	// 月,日の妥当性チェック
	if(slMonth >= 0 && slMonth <= 11 && slDay >= 1 && slDay <= 31){
		var slDt = new Date(slYear, slMonth, slDay);
		if(slDt.getFullYear() == slYear && slDt.getMonth() == slMonth && slDt.getDate() == slDay){
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
}

//=============================================================================
//		「前後の空白文字を切り落とす」処理関数
//			【入力】なし

//			【返却】前後の空白文字を切り落とす

//			【作成】WXHX Corp.
//			【概要】前後の空白文字を切り落とす

//=============================================================================
String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g, "");
}

//=============================================================================
//		「前後の日付を比較」処理関数
//			【入力】startName:開始日付

//				　endName：結束日付

//				　slMessage：部品の名前
//			【返却】なし

//			【作成】WXHX Corp.
//			【概要】前後の日付を比較

//=============================================================================
function csDatetoCompare(startName,endName,slMessage) {
	if(bResult) {
		var slTemp = eval("document.forms[0]." + startName);
		var slStart = slTemp.value;
		slStart = slStart.trim();
		slStart = slStart.replace(/\//g,"");
		
		var slTEMP = eval("document.forms[0]." + endName);
		var slEnd = slTEMP.value;
		slEnd = slEnd.trim();
		slEnd = slEnd.replace(/\//g,"");
		
		if(slEnd < slStart) {
			alert(slMessage + "の開始日付 は結束日付より小さい値を入力してください。");
			slTemp.select();
			bResult = false;
		}
	}
}

//=============================================================================
//     画面の初期化関数
//         【入力】 ＵＲＬ引数群
//         【返却】なし

//         【作成】WXHX Corp.
//         【概要】初期化関数
//=============================================================================
function checkform( strOperator, strActor, strVitalCheck ){
	bResult = true;
	if ( strVitalCheck == '1' ) { 
			
		var documentLength = document.forms[0].all.length;
		for (index = 0; index < documentLength; index++)
		{
			var strName = document.forms[0].all(index).name;
			if (!( typeof(strName) == "isUndefined" || strName == "" || strName == null)) {
				var str = "text,textarea,radiobox,checkbox,select-one";

				if(str.indexOf(document.forms[0].all(index).type) >= 0 ) { 
					 eval(strName + ".Validate();");
				}
			}
		}
		
		// 回覧票に特別に処理する

		if(bResult && (strOperator == "start" || strOperator == "confirm"))
		{
			var circularId = document.forms[0].circularID;
			if(!( typeof(circularId) == "isUndefined" || circularId == null)) {
				if(circularId.value == ""){
					alert("回覧人員を選んでください。");
					bResult = false;
				}
			}
		}
	}else {
		//案件名に特別にチェックする
		if(strOperator == "save") {
			var jobName = document.forms[0].fb_jobname.value;
			if((typeof(jobName) == "isUndefined" || jobName == "" || jobName == null )){
				alert("案件名を入力してください。");
				document.forms[0].fb_jobname.focus();
				bResult = false;
			}
		}
	}
	
	if(bResult){
		document.forms[0].action='JobControl';
		document.forms[0].operator.value=strOperator;
		document.forms[0].act.value=strActor;
		document.forms[0].submit();
	}
}

//=============================================================================
//     数字のチェック
//         【入力】strTag:数字対象
//         【返却】なし

//         【作成】WXHX Corp.
//         【概要】数字のチェック
//=============================================================================
function csNumChk(strTag) {
	if(bResult){
		var slMsg = "";
		var slChk = ".0123456789";
		var strTagName = eval("document.forms[0]." + strTag);
		var strTagValue = strTagName.value;
		
		var length = strTagValue.length;
		for(var i = 0; i <= length; i++) {
			var idx = slChk.indexOf(strTagValue.substr(i, 1));
			if(idx < 0) {
				alert("不可入力数字和“.”以外的其他任何字符！");
				strTagName.select();
		      	bResult = false;
		      	break;
			}
	    }
	}
}

//=============================================================================
//     uploadのチェック
//         【入力】strTag:数字対象
//         【返却】なし

//         【作成】WXHX Corp.
//         【概要】uploadのチェック
//=============================================================================
var fileNo = 1;
function insertRow() {
	var obj=document.getElementById("table1");
	var rowIndex=obj.childNodes[0].childNodes.length;
	var objTR=obj.insertRow(rowIndex);
	var objTD1=objTR.insertCell();
	var objTD2=objTR.insertCell();
	var num = "fileId"+fileNo;

	objTD1.innerHTML='<input type="file" onpaste="return false" onkeydown="return false" name="files[' + fileNo + ']" id ="'+num+'" >';
	objTD2.innerHTML='<input type="button" name="1" value="削除" onClick="deleteRow(' + fileNo + ');" id="del' + fileNo + '" >';
	fileNo = fileNo + 1;
	allNum = fileNo;
	if (fileNo >= 10) {
		document.all.Submit2.disabled = true; 	
	}
}

function deleteRow(index) {
	var obj = document.getElementById("table1");
	var name = obj.childNodes[0].childNodes[0].childNodes[0].childNodes[0].getAttribute("name");
	var rowIndex = obj.childNodes[0].childNodes.length;
	
	if (rowIndex > 1) {
		
		obj.childNodes[0].childNodes[index].removeNode(true);
		for (var i = 0; i < rowIndex - 1; i++) {
			var nameVal = obj.childNodes[0].childNodes[i].childNodes[0].childNodes[0].getAttribute("name");
			var nIndex = nameVal.substring(nameVal.length - 2, nameVal.length - 1).valueOf();
			if (nIndex > index) {
				var newNameVal = nameVal.replace(nIndex.toString(), (nIndex - 1).toString());
				obj.childNodes[0].childNodes[i].childNodes[0].childNodes[0].setAttribute("name", newNameVal);
				
				var idVal = obj.childNodes[0].childNodes[i].childNodes[0].childNodes[0].getAttribute("id");
				var newIdVal = idVal.replace(nIndex.toString(), (nIndex - 1).toString());
				obj.childNodes[0].childNodes[i].childNodes[0].childNodes[0].setAttribute("id", newIdVal);
				
				var id2Val = obj.childNodes[0].childNodes[i].childNodes[1].childNodes[0].getAttribute("id");
				var newId2Val = id2Val.replace(nIndex.toString(), (nIndex - 1).toString());
				obj.childNodes[0].childNodes[i].childNodes[1].childNodes[0].setAttribute("id", newId2Val);
				switch (nIndex.toString()) {
					case "1":
						document.getElementById("del" + i).onclick=function(){deleteRow(0);};
					
						break;
					case "2":
						document.getElementById("del" + i).onclick=function(){deleteRow(1);};
						break;
					case "3":
						document.getElementById("del" + i).onclick=function(){deleteRow(2);};
						break;
					case "4":
						document.getElementById("del" + i).onclick=function(){deleteRow(3);};
						break;
					case "5":
						document.getElementById("del" + i).onclick=function(){deleteRow(4);};
						break;
					case "6":
						document.getElementById("del" + i).onclick=function(){deleteRow(5);};
						break;
					case "7":
						document.getElementById("del" + i).onclick=function(){deleteRow(6);};
						break;
					case "8":
						document.getElementById("del" + i).onclick=function(){deleteRow(7);};
						break;
					case "9":
						document.getElementById("del" + i).onclick=function(){deleteRow(8);};
						break;
					default:
						break;
				}
			}
		}
		document.all.Submit2.disabled = false;
		fileNo--;
	}	else if (index = 0) {
	obj.childNodes[0].childNodes[0].removeNode(true);
	}
}

//=============================================================================
//     同じファイルのチェック
//         【入力】fileControl:ファイルオブジェクト


//         【返却】なし


//         【作成】WXHX Corp.
//         【概要】同じファイルのチェック
//=============================================================================
/**function isExists(fileControl,fileNo) {
	var filePath = fileControl.value;
	var index = filePath.lastIndexOf("\\");
	var fileName = filePath.substr(index + 1);
	var flag = true;
	var i = 0;

	while(flag) {

		var file = document.getElementById("fileId" + i);
		if(file != null && fileNo != i) {
			var fileValue = file.value;
			if(fileName != "") {
				var indexOld= fileValue.lastIndexOf("\\");
				if(fileName == fileValue.substr(indexOld + 1)){
					alert("�����t�@�C����I�тȂ����I");
					fileControl.select();
					deleteRow(fileNo);
					flag = false;
				}
			}
		} else {
			flag = false;
		}
		i++;
	}
}*/
//=============================================================================
//     fileziseのチェック
//         【入力】strTag:数字対象
//         【返却】なし

//         【作成】WXHX Corp.
//         【概要】fileziseのチェック
//=============================================================================

/**function crobj(fileIdNo) {
   var obj = document.getElementById("table1");
   var size = 0;
	for(var i = 0; i < fileNo; i++){
		var tt = obj.childNodes[0].childNodes[i].childNodes[0].childNodes[0].getAttribute("value");	
		if(tt != "") {
			var fso = new ActiveXObject("Scripting.FileSystemObject"); 
			var opath = fso.GetFile(tt); 
			size = size + opath.size;
		}
	}
	if(size>300000){
	alert("アップロードのファイルはすでに300000byteを上回りました|");
	fileIdNo.select();
	}
}*/
//=============================================================================
//     事宜部品
//         【入力】strTag:数字対象
//         【返却】なし

//         【作成】WXHX Corp.
//         【概要】事宜部品のチェック
//=============================================================================

 var nameNo = 1;
 var num = 0;
function additem(id)
{

  var row,cell,str;
  var StuName = "StuName"+nameNo;

  row = eval("document.all["+'"'+id+'"'+"]").insertRow();

  if(row != null )
     {
        cell = row.insertCell();
        str="<TEXTAREA name='" + StuName + "'></TEXTAREA><input type='button' value='削除' onclick=\"deleteitem(this,'tb');\">";
  		cell.innerHTML=str;
		nameNo = nameNo + 1;
		num = num  + 1;
		if(num >= 10){
		document.all.button.disabled = true;
		}
      }
}

function deleteitem(obj,id)
{
  var rowNum,curRow;
  curRow = obj.parentNode.parentNode;

  rowNum = eval("document.all."+id).rows.length - 1;
  eval("document.all["+'"'+id+'"'+"]").deleteRow(curRow.rowIndex);
  document.all.button.disabled = false;
	num = num  - 1;
	
}
