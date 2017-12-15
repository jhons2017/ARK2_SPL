package flowbuilder.daoimpl.naming;

/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/11/03
 *
 * (c) 2005 Yamatake Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/11/03 BY. T.Okuyama (BSC)
 *=================================================================
 */


import javax.naming.spi.InitialContextFactory;
import javax.naming.Context;
import java.util.Hashtable;

/**
 * InitialContextFactory�̊ȈՎ����B
 * <<���@>>
 * DB�A�N�Z�X�N���X��Tomcat�����s����Ă���JavaVM�ȊO�Ŏg�p���邽�߂ɁA
 * �f�[�^�\�[�X��JNDI�ɓo�^�������B
 * �����ŁA�ȈՓI�Ȏ������쐬�����B�����p���邱�ƂŁAJNDI����f�[�^�\�[�X��
 * �擾����DB�A�N�Z�X�N���X�����̂܂ܗ��p�ł���B
 */
public class SimpleContextFactory implements InitialContextFactory
{
	private static SimpleContext INSTANCE = new SimpleContext();

	/**
	 * Method getInitialContext Returns the SimpleContext for use.
	 * 
	 * @param environment
	 * @return Context
	 */
	public Context getInitialContext(Hashtable environment)
	{
		return INSTANCE;
	}
}