/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/04/21
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/04/21 BY. DHW(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * �w�肵���L�[�ɑΉ����郌�R�[�h�����݂��Ȃ��ꍇ�ɃX���[������O�B
 */
public class RecordNotFoundAppException extends DataAccessAppException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public RecordNotFoundAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
