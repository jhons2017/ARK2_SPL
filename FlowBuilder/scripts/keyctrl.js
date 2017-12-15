
// ---------------------------------
// 「戻る」「進む」対応ライブラリ
// 
// 2006.09.29 伊藤
// ---------------------------------

//=============================================================================
//    キー押下時イベント
//         【入力】なし
//         【返却】真偽
//         【作成】伊藤
//         【概要】バックスペース、"alt"+"←→"キーによる戻るの禁止。
//　　　　　　　　 F5キーによる画面の更新の禁止
//　　　　　　　　 実装方法はBODYタグ次の行に下記の1行を追加してください。
//　　　　　　　　<script language="javascript" src="当ファイルへのパス" ></script>
//=============================================================================
window.document.onkeydown = function() {
	//バックスペース対応
	if (event.keyCode == getKeyCd("BS")) {
		var elemType = window.document.activeElement.type;
		var readType = window.document.activeElement.readOnly;
		//テキストとテキストエリア内はBS可能
		if (((elemType != 'text') && (elemType != 'textarea') && (elemType != 'file') && (elemType != 'password')) || readType == true) {
			event.keyCode = null;
			return false;
		}
	}

	//alt　+　←→　対応
	if (event.altKey && ((event.keyCode == getKeyCd("LEFT"))||(event.keyCode == getKeyCd("RIGHT")))) {
			alert("「戻る」「進む」の操作は禁止です。")
			event.keyCode = null;
			return false;
	}
	
	//F5対応
	if (event.keyCode == getKeyCd("F5")) {
		event.keyCode = null;
		return false;
	}
}

//=============================================================================
//    キーコード取得関数
//         【入力】キー略称
//         【返却】キーコード
//         【作成】伊藤
//         【概要】代表的なキーコードを調べる
//=============================================================================
function getKeyCd(keyNm){
	var i=0;
	var keyAry=new Array("ESC",27,"HT",9,"INS",45,"DEL",46,"HOME",36,"END",35,"PGUP",33,"PGDN",34,"UP",38,"DOWN",40,"LEFT",37,"RIGHT",39,"F1",112,"F2",113,"F3",114,"F4",115,"F5",116,"F6",117,"F7",118,"F8",119,"F9",120,"F10",121,"F11",122,"F12",123,"BS",8,"RET",13);
	
	for(i=0;i<keyAry.length;i++){
		if(keyAry[i]==keyNm){
			return keyAry[i+1];
		}
	}
}