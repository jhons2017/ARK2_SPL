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
 * ���O�C���T�[�r�X�ɋ��ʂ���A�v���P�[�V�����T�[�r�X�̎����N���X <BR>
 */
final class OrgListServiceImpl implements OrgListService {
	/** DAO�t�@�N�g���̐錾 */
	private UserDataAccessFactroy _daoFactory = null;


	/**
	 * �R���X�g���N�^
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException �V�X�e���G���[�̏ꍇ
	 * 
	 */
	OrgListServiceImpl() throws Exception {
		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
	}

	/**
	 * ���O�C�����[�U�́u�g�D/�����v�ꗗ�̎擾
	 * 
	 * @param loginUser ���O�C�����[�U�[
	 * @return boolean (ture:����/false:���s)
	 * @throws SysException 
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 * @throws  
	 * @throws NullPointerException ���O�C�����[�U�[�܂��̓p�X���[�h��null�̏ꍇ�B
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
	 * �g�D���X�g�̎擾
	 * 
	 * @return boolean (ture:����/false:���s)
	 * @throws SysException 
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 * @throws  
	 * @throws NullPointerException ���O�C�����[�U�[�܂��̓p�X���[�h��null�̏ꍇ�B
	 */
	public List<Section> getAllOrgId() throws SysException {
		
		SectionDAO sectionDao = _daoFactory.createSectionDAO();
		List<Section> orglst = sectionDao.getAllOrgList();
		return orglst;
	}
}