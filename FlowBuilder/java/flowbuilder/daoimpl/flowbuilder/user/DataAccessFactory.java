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
package flowbuilder.daoimpl.flowbuilder.user;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import flowbuilder.dao.conf.FlowBuilderSystemConfig;

import fbcom.framework.dao.conf.ConfigReader;

/**
 * �_��f�[�^�A�N�Z�X�I�u�W�F�N�g�̒��ۃt�@�N�g���N���X�B
 */
public abstract class DataAccessFactory
{
	//���M���O
	private static final Log _log = LogFactory.getLog(DataAccessFactory.class);
	
	/**
	 * ����Factory�N���X�̃C���X�^���X���擾����B
	 * 
	 * @param implClassRef �����N���X�̊��S�C�����ւ̎Q�ƁB
	 * 
	 * @return ContractDataAccessFactory ����Factory�N���X�̃C���X�^���X(�C���X�^���X�̐����Ɏ��s�����Ƃ��Anull��Ԃ�)
	 * @throws Exception 
	 * @exception DataAccessSysException �f�[�^�A�N�Z�X�̃V�X�e���G���[�̏ꍇ�B
	 */
	public static DataAccessFactory getFactory(String implClassRef) throws Exception 
	{
		DataAccessFactory result = null;

		try
		{
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			String className = conf.getValue(implClassRef);
			result = (DataAccessFactory) Class.forName(className).newInstance();
		}
		catch (ClassNotFoundException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new Exception("XML�t�@�C���̃A�N�Z�X�Ɏ��s���܂����B");
		}
		catch (IllegalAccessException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new Exception("XML�t�@�C���̃A�N�Z�X�Ɏ��s���܂����B");
		}
		catch (InstantiationException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new Exception("XML�t�@�C���̃A�N�Z�X�Ɏ��s���܂����B");
		}
		return result;
	}

//	
//	
//	/**
//	 * ���[�U�[XML����Access�̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
//	 * 
//	 * @return UserXMLAccess ���[�U�[XML����Access�̃f�[�^�A�N�Z�X�I�u�W�F�N�g
//	 */
//	public abstract UserXMLAccess createUserXMLAccess();

}