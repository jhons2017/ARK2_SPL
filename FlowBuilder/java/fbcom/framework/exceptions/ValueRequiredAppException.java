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
 * �K�{���ڂ����͂���Ă��Ȃ��ꍇ�ɃX���[������O�B
 */
public class ValueRequiredAppException extends DataAccessAppException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public ValueRequiredAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
