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
 * �ݒ�\�Ȓl�͈̔͂𒴂���ꍇ�ɃX���[������O�B
 */
public class ValueOutOfBoundsAppException extends DataAccessAppException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public ValueOutOfBoundsAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
