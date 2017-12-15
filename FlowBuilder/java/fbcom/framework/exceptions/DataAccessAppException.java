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

import fbcom.framework.exceptions.AppException;

/**
 * �f�[�^�̃A�N�Z�X���ɉ��炩�̗\���ł���G���[�������������Ƃ�\���B<BR> 
 * �Ⴆ�Τ�o�^��Key�d���ȂǁB
 */
public class DataAccessAppException extends AppException
{
	/**
	 * �R���X�g���N�^
	 * 
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public DataAccessAppException(
			String messageKey)
	{
		super(messageKey);
	}
}