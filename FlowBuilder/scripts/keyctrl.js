
// ---------------------------------
// �u�߂�v�u�i�ށv�Ή����C�u����
// 
// 2006.09.29 �ɓ�
// ---------------------------------

//=============================================================================
//    �L�[�������C�x���g
//         �y���́z�Ȃ�
//         �y�ԋp�z�^�U
//         �y�쐬�z�ɓ�
//         �y�T�v�z�o�b�N�X�y�[�X�A"alt"+"����"�L�[�ɂ��߂�̋֎~�B
//�@�@�@�@�@�@�@�@ F5�L�[�ɂ���ʂ̍X�V�̋֎~
//�@�@�@�@�@�@�@�@ �������@��BODY�^�O���̍s�ɉ��L��1�s��ǉ����Ă��������B
//�@�@�@�@�@�@�@�@<script language="javascript" src="���t�@�C���ւ̃p�X" ></script>
//=============================================================================
window.document.onkeydown = function() {
	//�o�b�N�X�y�[�X�Ή�
	if (event.keyCode == getKeyCd("BS")) {
		var elemType = window.document.activeElement.type;
		var readType = window.document.activeElement.readOnly;
		//�e�L�X�g�ƃe�L�X�g�G���A����BS�\
		if (((elemType != 'text') && (elemType != 'textarea') && (elemType != 'file') && (elemType != 'password')) || readType == true) {
			event.keyCode = null;
			return false;
		}
	}

	//alt�@+�@�����@�Ή�
	if (event.altKey && ((event.keyCode == getKeyCd("LEFT"))||(event.keyCode == getKeyCd("RIGHT")))) {
			alert("�u�߂�v�u�i�ށv�̑���͋֎~�ł��B")
			event.keyCode = null;
			return false;
	}
	
	//F5�Ή�
	if (event.keyCode == getKeyCd("F5")) {
		event.keyCode = null;
		return false;
	}
}

//=============================================================================
//    �L�[�R�[�h�擾�֐�
//         �y���́z�L�[����
//         �y�ԋp�z�L�[�R�[�h
//         �y�쐬�z�ɓ�
//         �y�T�v�z��\�I�ȃL�[�R�[�h�𒲂ׂ�
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