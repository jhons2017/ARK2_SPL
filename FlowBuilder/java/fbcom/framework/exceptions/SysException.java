/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/01/18
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/01/18 BY. LJW(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * �V�X�e����O�B
 * java.lang.Exception�̃R���X�g���N�^Exception(String message)�ɂāA
 * ���\�[�X�o���h���Œ�`����Ă��郁�b�Z�[�W�L�[���w�肵�Ďg�p����B
 * 
 * <��`>
 * �Ⴆ�΁A�v���O���~���O��̃G���[�̏ꍇ��A�l�b�g���[�N��̖��ȂǁA
 * �A�v���P�[�V�������W�b�N�Ƃ͊֌W���Ȃ����[���x���̖��ŁA�G���h���[�U�́A
 * ��������񕜂��邱�Ƃ��o���Ȃ���O�̂��ƁB
 * <��舵��>
 * �V�X�e���G���[�y�[�W��\������B
 * �i�ꍇ�ɂ���ẮA�V�X�e���Ǘ��҂ɘA�����ׂ����Ɠ`����B)
 * �G���h���[�U�̐M���𑹂˂Ȃ����߂ɁA��O�̃X�^�b�N�ƃ��[�X�͕\�����ׂ��łȂ��B
 * �V�X�e���G���[�y�[�W�ɂ́A�ȉ��̍��ڂ�\������B
 * 	��O��������������(�������͂̍ہA���O�̒�����e�Ղɂ��邽�߁j
 * 	���[�U�������ł���G���[���b�Z�[�W
 */
public class SysException extends BaseException
{
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public SysException(String messageKey)
	{
		super(messageKey);
	}
	
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 * @param rootCause�@�匴��
	 */
	public SysException(String messageKey, Throwable rootCause) 
	{
		super(messageKey, rootCause);
	}
}
