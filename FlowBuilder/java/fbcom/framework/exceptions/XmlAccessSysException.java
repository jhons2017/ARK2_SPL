/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/01/19
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/01/19 BY. LJW(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

import fbcom.framework.exceptions.SysException;

/**
 * �f�[�^�̃A�N�Z�X���ɉ��炩�̗\�����Ȃ��G���[�������������Ƃ�\���B
 * �Ⴆ�ΤDB�ւ̐ڑ��G���[��t�@�C��I/O�G���[�ȂǁB
 */
public class XmlAccessSysException extends SysException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public XmlAccessSysException(String messageKey)
	{
		super(messageKey);
	}
}
