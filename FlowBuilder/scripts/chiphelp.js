timerID = 0;
sec = 10 * 1000; //�`�b�v�w���v��\�����鎞�ԁB2.5�b�B

function sDomChipHelp(divID,x,y,sChip,rsd) //�`�b�v�w���v��\������֐� 
{
	if(sChip == ""){
		return;
	}
	sChip = sChip.replace(/<BR>/g,'\r\n');
	var offX = offY = 0; //�����l

	if (document.layers){
		chipOBJ = document.layers[divID]; //NN4�Ή�
		//document.layers[divID].innerHTML = sChip;
	}
	if (document.all){
		chipOBJ = document.all[divID].style; //IE4�Ή�
		document.all["chipText"].innerText = sChip;
	}
	if (document.getElementById) //DOM�Ή�
	{
		chipOBJ = document.getElementById(divID).style;
		if (document.all) //IE5�ȍ~�̃X�N���[���l�擾
		{
			offX = document.body.scrollLeft;
			offY = document.body.scrollTop;
		}
	}
	
	chipOBJ.visibility = "visible"; //�`�b�v�w���v�\��
	chipOBJ.left = x + offX; //�|�b�v�A�b�v�ʒu
	chipOBJ.top = y + offY + rsd; //y�����ɃJ�[�\����(16px)�������炷
	timerID = setTimeout("hChipHelp('"+divID+"')",sec); //��莞�ԕ\����������� 
}

function hChipHelp(divID) //�`�b�v�w���v���\���ɂ���֐�
{
	if (document.layers) chipOBJ = document.layers[divID];
	if (document.all) chipOBJ = document.all[divID].style;
	if (document.getElementById) chipOBJ = document.getElementById(divID).style;
	chipOBJ.visibility = "hidden"; //�`�b�v�w���v��\��
	clearTimeout(timerID); //�^�C�}�[������
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
