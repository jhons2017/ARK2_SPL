/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * �A�v���P�[�V������O�B
 * java.lang.Exception�̃R���X�g���N�^Exception(String message)�ɂāA
 * ���\�[�X�o���h���Œ�`����Ă��郁�b�Z�[�W�L�[���w�肵�Ďg�p����B
 * 
 * <��`>
 * �Ⴆ�΁A���[�U���A�v���P�[�V�����Ƀ��O�C�����悤�Ƃ��āA�p�X���[�h���ԈႦ���ꍇ�ȂǁA
 * �r�W�l�X���[���̐N�Q�ȂǂŔ��������O�̂��ƁB
 * <��舵��>
 * �������̓y�[�W�ɖ߂��āA�G���[���b�Z�[�W��\�����A���[�U���ē��͂Ȃǂ̃A�N�V������
 * ����悤�ɂ���B
 */
public class AppException extends BaseException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public AppException(String messageKey)
	{
		super(messageKey);
	}
	
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 * @param rootCause�@�匴��
	 */
	public AppException(String messageKey, Throwable rootCause) 
	{
		super(messageKey, rootCause);
	}
}
