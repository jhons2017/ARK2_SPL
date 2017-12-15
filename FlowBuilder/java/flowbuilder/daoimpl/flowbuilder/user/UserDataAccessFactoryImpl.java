package flowbuilder.daoimpl.flowbuilder.user;

import flowbuilder.dao.user.RoleDAO;
import flowbuilder.dao.user.SectionDAO;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.dao.user.UserQueryInfo;

public final class UserDataAccessFactoryImpl extends UserDataAccessFactroy {
	/**
	 * 所属のデータアクセスオブジェクトを生成する。
	 * 
	 * @return 所属のデータアクセスオブジェクト
	 */
	public SectionDAO createSectionDAO() {
		return new SectionDAOImpl();
	}

	/**
	 * 権限のデータアクセスオブジェクトを生成する。
	 * 
	 * @return 所属のデータアクセスオブジェクト
	 */
	public RoleDAO createRoleDAO() {
		return new RoleDAOImpl();
	}
	
	/**
	 * ユーザーのデータアクセスオブジェクトを生成する。
	 * 
	 * @return ユーザーのデータアクセスオブジェクト
	 */
	public UserDAO createUserDAO() {
		return new UserDAOImpl();
	}

	/**
	 * ユーザー検索のデータアクセスオブジェクトを生成する。
	 * 
	 * @return ユーザー検索のデータアクセスオブジェクト
	 */
	public UserQueryInfo createUserQueryInfo() {
		return new UserQueryInfoImpl();
	}
}
