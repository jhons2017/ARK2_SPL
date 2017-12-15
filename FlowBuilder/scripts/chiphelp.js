timerID = 0;
sec = 10 * 1000; //チップヘルプを表示する時間。2.5秒。

function sDomChipHelp(divID,x,y,sChip,rsd) //チップヘルプを表示する関数 
{
	if(sChip == ""){
		return;
	}
	sChip = sChip.replace(/<BR>/g,'\r\n');
	var offX = offY = 0; //初期値

	if (document.layers){
		chipOBJ = document.layers[divID]; //NN4対応
		//document.layers[divID].innerHTML = sChip;
	}
	if (document.all){
		chipOBJ = document.all[divID].style; //IE4対応
		document.all["chipText"].innerText = sChip;
	}
	if (document.getElementById) //DOM対応
	{
		chipOBJ = document.getElementById(divID).style;
		if (document.all) //IE5以降のスクロール値取得
		{
			offX = document.body.scrollLeft;
			offY = document.body.scrollTop;
		}
	}
	
	chipOBJ.visibility = "visible"; //チップヘルプ表示
	chipOBJ.left = x + offX; //ポップアップ位置
	chipOBJ.top = y + offY + rsd; //y方向にカーソル分(16px)だけずらす
	timerID = setTimeout("hChipHelp('"+divID+"')",sec); //一定時間表示したら消す 
}

function hChipHelp(divID) //チップヘルプを非表示にする関数
{
	if (document.layers) chipOBJ = document.layers[divID];
	if (document.all) chipOBJ = document.all[divID].style;
	if (document.getElementById) chipOBJ = document.getElementById(divID).style;
	chipOBJ.visibility = "hidden"; //チップヘルプ非表示
	clearTimeout(timerID); //タイマーを解除
}

//document.write('<DIV class="chiphelp" id="divChip"><SPAN id="chipText"></SPAN></DIV>')

document.write('<DIV style="position:absolute;z-index:1;visibility:hidden;" id="divChip" >');
document.write('	<TABLE border=0><TR><TD>');
document.write('		<DIV style="background:#aef;">');
document.write('			<B style="display: block; background: #fff ">');
document.write('			<B style="display: block; background: #aef; overflow: hidden; height: 1px; margin: 0px 5px"></B>');
document.write('			<B style="display: block; background: #aef; overflow: hidden; height: 1px; margin: 0px 3px"></B>');
document.write('			<B style="display: block; background: #aef; overflow: hidden; height: 1px; margin: 0px 2px"></B>');
document.write('			<B style="display: block; background: #aef; overflow: hidden; height: 1px; margin: 0px 1px; height: 2px"></B>');
document.write('			</B>');
document.write('			<P style="margin:0 10px;" id="chipText"></P>');
document.write('			<B style="display: block; background: #fff ">');
document.write('			<B style="display: block; background: #aef; overflow: hidden; height: 1px; margin: 0px 1px; height: 2px"></B>');
document.write('			<B style="display: block; background: #aef; overflow: hidden; height: 1px; margin: 0px 2px"></B>');
document.write('			<B style="display: block; background: #aef; overflow: hidden; height: 1px; margin: 0px 3px"></B>');
document.write('			<B style="display: block; background: #aef; overflow: hidden; height: 1px; margin: 0px 5px"></B>');
document.write('			</B>');
document.write('		</DIV>');
document.write('	</TD></TR></TABLE>');
document.write('</DIV>');
