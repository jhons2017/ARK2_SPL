/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/04/11
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/04/11 BY. Liu(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * �w�肳�ꂽ���Ԃ̏������s���ȏꍇ�ɃX���[������O�B
 */
public class IllegalOrderOfDateAppException extends AppException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public IllegalOrderOfDateAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
