/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.common.validate;

import java.util.Map;

/**
 * �`�F�b�N�@�\�C���^�t�F�[�X <BR>
 */
public interface IValidate 
{
	/**
	 * �p�����[�^��ۑ��������b�v
	 * @param params�@���b�v
	 */
	public void init(Map params);
	
	/**
	 * �X�N���v�g���o�͂���B
	 * @return�@String�@�X�N���v�g
	 */
	public String print();
}
