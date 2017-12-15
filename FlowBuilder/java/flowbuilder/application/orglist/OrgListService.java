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

import java.util.List;

import flowbuilder.domain.user.Section;
import flowbuilder.view.orglist.OrgDTO;
import fbcom.framework.exceptions.SysException;

/**
 * ���O�C���T�[�r�X���`����C���^�[�t�F�C�X�B <BR>
 */
public interface OrgListService {
	/**
	 * ���O�C�����[�U�́u�g�D/�����v�ꗗ�̎擾
	 * 
	 * @return boolean (ture:����/false:���s)
	 * @throws SysException 
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 * @throws  
	 * @throws NullPointerException ���O�C�����[�U�[�܂��̓p�X���[�h��null�̏ꍇ�B
	 */
	
	public List<Section> getAllOrgId() throws SysException;	
	
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
	public List<OrgDTO> getOrgList(String loginUser) throws SysException;
}
