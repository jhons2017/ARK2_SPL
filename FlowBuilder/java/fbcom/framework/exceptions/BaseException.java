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

import java.util.List;
import java.util.ArrayList;

/**
 * ���ׂẴA�v���P�[�V������O����уV�X�e����O�p�̋��ʂ̃X�[�p�[�N���X�B
 * java.lang.Exception�̃R���X�g���N�^Exception(String message)�ɂāA
 * ���\�[�X�o���h���Œ�`����Ă��郁�b�Z�[�W�L�[���w�肵�Ďg�p����B
 * 
 * �܂��A_exceptions�t�B�[���h�ŕ����̗�O���T�|�[�g���Ă���B
 * 
 * jdk1.4�ȍ~�ł́AJava�W��API�Ŏ匴�����T�|�[�g����Ă���B
 * �{�N���X�́Ajdk1.4�ȍ~��ΏۂƂ��āA�匴���̃T�|�[�g�́A�s�Ȃ�Ȃ��B
 */
public abstract class BaseException extends Exception
{
	/**
	 * �����̗�O�B
	 * �Ⴆ�΁A�ő�l�����܂��Ă���t�B�[���h�������L��A�������̃G���[��
	 * ���������ꍇ�ȂǂɁA�����̗�O��ێ��ł���悤�ɂ���B
	 */
	private List _exceptions = new ArrayList();

	/**
	 * ���b�Z�[�W�L�[�̈����B
	 */
	private Object[] _messageArgs;

	/**
	 * �R���X�g���N�^
	 *
	 */
	public BaseException()
	{
		super();
	}
	
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 */
	public BaseException(String messageKey)
	{
		super(messageKey);
	}
	
	/**
	 * �R���X�g���N�^
	 * @param messageKey ���b�Z�[�W�L�[
	 * @param rootCause�@�匴��
	 */
	public BaseException(String messageKey, Throwable rootCause) 
	{
		super(messageKey, rootCause);
	}
	
	/**
	 * �R���X�g���N�^
	 * @param rootCause�@�匴��
	 */
	public BaseException(Throwable rootCause)
	{
		super(rootCause);
	}
	
	/**
	 * ������O���擾����B
	 * @return ������O
	 */
	public List getExceptions()
	{
		return _exceptions;
	}
	
	/**
	 * ������O��ǉ�����B
	 * @param ex ��O
	 */
	public void addException(BaseException ex)
	{
		_exceptions.add(ex);
	}
	
	/**
	 * ���b�Z�[�W�L�[�̈������擾����B
	 * @return ���b�Z�[�W�L�[�̈���
	 */
	public Object[] getMessageArgs()
	{
		return _messageArgs;
	}
	
	/**
	 * ���b�Z�[�W�L�[�̈�����ݒ肷��B
	 * @param messageArgs ���b�Z�[�W�L�[�̈���
	 */
	public void setMessageArgs(Object[] messageArgs)
	{
		_messageArgs = messageArgs;
	}
	
// JDK1.4�ȍ~��ΏۂƂ��邽�ߍ폜�B
//	/**
//	 * �匴���̗�O
//	 */
//	private Throwable _rootCause;
//
//	/**
//	 * ���b�Z�[�W�L�[�B���\�[�X�o���h���Œ�`����Ă��郁�b�Z�[�W�L�[�B
//	 */
//	private String _messageKey;
//

//	/**
//	 * ���b�Z�[�W�L�[��ݒ肷��B
//	 * @param key ���b�Z�[�W�L�[
//	 */
//	public void setMessageKey(String key)
//	{
//		_messageKey = key;
//	}
//	
//	/**
//	 * ���b�Z�[�W�L�[���擾����B
//	 * @return ���b�Z�[�W�L�[
//	 */
//	public String getMessageKey()
//	{
//		return _messageKey;
//	}
//	/**
//	 * �匴���̗�O���擾����B
//	 * @return �匴���̗�O
//	 */
//	public Throwable getRootCause()
//	{
//		return _rootCause;
//	}
//	/**
//	 * �匴���̗�O��ݒ肷��B
//	 * @param �匴���̗�O
//	 */
//	public void setRootCause(Throwable rootCause)
//	{
//		_rootCause = rootCause;
//	}
//	
//	
//	/**
//	 * �X�^�b�N�g���[�X��W���G���[�o�͂ɏo�͂���B
//	 */
//	public void printStackTrace()
//	{
//		printStackTrace(System.err);
//	}
//	
//	/**
//	 * �X�^�b�N�g���[�X��outStream�ɏo�͂���B
//	 * @param outStream
//	 */
//	public void printStackTrace(PrintStream outStream)
//	{
//		printStackTrace(new PrintWriter(outStream));
//	}
//	
//	
//	/**
//	 * �X�^�b�N�g���[�X��writer�ɏo�͂���B
//	 * @param writer
//	 */
//	public void printStackTrace(PrintWriter writer)
//	{
//		super.printStackTrace(writer);
//		if(getRootCause() != null)
//		{
//			getRootCause().printStackTrace(writer);
//		}
//		writer.flush();
//	}
	
}