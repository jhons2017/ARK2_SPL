/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/07/23
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/07/23 BY. DHW(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * (��Ɠ� > ����) AND (��ƍ���.��Ə� = ����)�ł���ꍇ�A�܂��� (��Ɠ� < ����) AND (��ƍ���.��Ə� =
 * ��Ɨ\��)�ł���ꍇ�ɃX���[������O�B
 */
public class IlleagalStateAppException extends AppException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public IlleagalStateAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
