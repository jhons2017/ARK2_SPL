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
package flowbuilder.dao.user;



import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.exceptions.XmlAccessSysException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * �f�[�^�A�N�Z�X�I�u�W�F�N�g�̒��ۃt�@�N�g���N���X�B
 */
public abstract class UserDataAccessFactroy
{
	//���M���O
	private static final Log _log = LogFactory.getLog(UserDataAccessFactroy.class);

	/**
	 * ����Factory�N���X�̃C���X�^���X���擾����B
	 * 
	 * @return ����Factory�N���X�̃C���X�^���X(�C���X�^���X�̐����Ɏ��s�����Ƃ��Anull��Ԃ�)
	 * 
	 * @param implClassRef �����N���X�̊��S�C�����ւ̎Q�ƁB
	 * @exception DataAccessSysException �f�[�^�A�N�Z�X�̃V�X�e���G���[�̏ꍇ�B
	 */
	public static UserDataAccessFactroy getFactory(String implClassRef) throws XmlAccessSysException
	{
		UserDataAccessFactroy result = null;

		try
		{
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			String className = conf.getValue(implClassRef);
			result = (UserDataAccessFactroy) Class.forName(className).newInstance();
		}
		catch (ClassNotFoundException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		catch (IllegalAccessException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		catch (InstantiationException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		return result;
	}

	/**
	 * �����̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return �����̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public abstract SectionDAO createSectionDAO();

	/**
	 * �����̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return �����̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public abstract RoleDAO createRoleDAO();
	
	/**
	 * ���[�U�[�̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return ���[�U�[�̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public abstract UserDAO createUserDAO();

	/**
	 * ���[�U�[�����̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return ���[�U�[�����̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public abstract UserQueryInfo createUserQueryInfo();

}