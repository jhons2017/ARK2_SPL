package flowbuilder.application.user;

/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/12/16
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/12/16 BY. DINGZHI (WXHX)
 * =================================================================
 */

import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.dao.user.UserQueryInfo;
import fbcom.framework.exceptions.SysException;

/**
 * ���[�U�[�Ǘ���static�t�@�N�g�����\�b�h��񋟂���<BR>
 */
public class UserServiceFactory
{
	/**
	 * static�t�@�N�g�����\�b�h�����Ȃ̂ŁA�C���X�^���X�������Ȃ��B
	 *
	 */
	private UserServiceFactory()
	{
	}
	
	/**
	 * ���[�U�[�Ǘ��T�[�r�X�̃C���X�^���X���擾����B 
	 * 
	 * @return UserService
	 * @throws SysException
	 */
	public static UserService getUserServiceInstance() throws SysException
	{
		return new UserServiceImpl();
	}
	
	/**
	 * ���������̃C���X�^���X���擾����B 
	 * 
	 * @return UserQueryInfo�̎����N���X�̃C���X�^���X
	 * @throws SysException
	 */
	public static UserQueryInfo getUserQueryInstance() throws SysException
	{
		UserDataAccessFactroy daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
		return daoFactory.createUserQueryInfo();
	}
}
