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
package flowbuilder.application.orglist;


import java.util.ArrayList;
import java.util.List;

import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.user.SectionDAO;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.domain.user.Section;
import flowbuilder.domain.user.User;
import flowbuilder.domain.user.UserRole;
import flowbuilder.view.orglist.OrgDTO;

;
/**
 * ログインサービスに共通するアプリケーションサービスの実装クラス <BR>
 */
final class OrgListServiceImpl implements OrgListService {
	/** DAOファクトリの宣言 */
	private UserDataAccessFactroy _daoFactory = null;


	/**
	 * コンストラクタ
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException システムエラーの場合
	 * 
	 */
	OrgListServiceImpl() throws Exception {
		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
	}

	/**
	 * ログインユーザの「組織/権限」一覧の取得
	 * 
	 * @param loginUser ログインユーザー
	 * @return boolean (ture:成功/false:失敗)
	 * @throws SysException 
	 * @throws SysException システムエラーの場合。
	 * @throws  
	 * @throws NullPointerException ログインユーザーまたはパスワードがnullの場合。
	 */
	public List<OrgDTO> getOrgList(String loginUser) throws SysException {
		// TODO Auto-generated method stub
		List<OrgDTO> listOrgRole = new ArrayList<OrgDTO>();
		
		
		OrgDTO orgDTO = null;
		User user = null;
		UserRole userRole = null;
		Section org = null;
		
		UserDAO userDao = _daoFactory.createUserDAO();
		SectionDAO sectionDao = _daoFactory.createSectionDAO();
		

		List<User> userlist = userDao.getList(loginUser);
		int count = userlist.size();
		
		for(int i=0;i<count;i++){
			orgDTO = new OrgDTO();
			
			user = userlist.get(i);
			String userOrgId = user.getOrgid();
			org = sectionDao.selectById(userOrgId);
			userRole = user.getUserRole();
			
			orgDTO.setOrgId(userOrgId);
			orgDTO.setOrgName(org.getName());
			orgDTO.setRoleId(userRole.toString());
			orgDTO.setRoleName(userRole.getName());
			
			listOrgRole.add(orgDTO);
		}

		return listOrgRole;
	}
	
	/**
	 * 組織レストの取得
	 * 
	 * @return boolean (ture:成功/false:失敗)
	 * @throws SysException 
	 * @throws SysException システムエラーの場合。
	 * @throws  
	 * @throws NullPointerException ログインユーザーまたはパスワードがnullの場合。
	 */
	public List<Section> getAllOrgId() throws SysException {
		
		SectionDAO sectionDao = _daoFactory.createSectionDAO();
		List<Section> orglst = sectionDao.getAllOrgList();
		return orglst;
	}
}