/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/06/07
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/06/07 BY. ZYJ (WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * �X�e�[�g�����g�͐���̊O���L�[�Ɩ������Ă���ꍇ�ɃX���[������O�B
 */
public class IllegalRelationAppException extends DataAccessAppException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public IllegalRelationAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
