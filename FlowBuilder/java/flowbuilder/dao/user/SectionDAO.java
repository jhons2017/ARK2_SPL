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

import java.util.List;

import flowbuilder.domain.user.Section;
import fbcom.framework.exceptions.XmlAccessSysException;

/**
 * ���� DAO interface 
 */
public interface SectionDAO
{
	/**
	 * ���� �����̎擾
	 * 
	 * @return Count �����̐�
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public int getCount() throws XmlAccessSysException;

	/**
	 * ���� List �̎擾
	 * 
	 * @param beginIndex �����J�n�C���f�b�N�X�i1�ȏ�)
	 * @param count �擾�����������̐��i1�ȏ�j
	 * @return List ���g�� Section
	 * @throws IndexOutOfBoundsException �z��̋��E�𒴂��ăA�N�Z�X�����̏ꍇ
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<Section> getList(int beginIndex, int count) throws XmlAccessSysException;

	/**
	 * ���� List �̎擾
	 * 
	 * @return List ���g�� Cause �����敪
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<Section> getList() throws XmlAccessSysException;

	/**
	 * ���� �̎擾
	 * 
	 * @param sectionNo ����No
	 * @return Section ����
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public Section selectById(String sectionNo) throws XmlAccessSysException;
	
	/**
	 * ���� �̎擾
	 * 
	 * @param sectionNo ����No
	 * @return Section ����
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public Section selectByName(String sectionName) throws XmlAccessSysException;
	
	/**
	 * ���� �̎擾
	 * 
	 * @return Section ����
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<Section> getAllOrgList() throws XmlAccessSysException;
	
}
