package flowbuilder.daoimpl.flowbuilder.user;

import flowbuilder.dao.user.RoleDAO;
import flowbuilder.dao.user.SectionDAO;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.dao.user.UserQueryInfo;

public final class UserDataAccessFactoryImpl extends UserDataAccessFactroy {
	/**
	 * �����̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return �����̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public SectionDAO createSectionDAO() {
		return new SectionDAOImpl();
	}

	/**
	 * �����̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return �����̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public RoleDAO createRoleDAO() {
		return new RoleDAOImpl();
	}
	
	/**
	 * ���[�U�[�̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return ���[�U�[�̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public UserDAO createUserDAO() {
		return new UserDAOImpl();
	}

	/**
	 * ���[�U�[�����̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return ���[�U�[�����̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public UserQueryInfo createUserQueryInfo() {
		return new UserQueryInfoImpl();
	}
}
