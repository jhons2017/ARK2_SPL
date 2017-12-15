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

/**
 * ���[�U�[�����̂��߂̌����������`����C���^�[�t�F�[�X�B <BR>
 */
public interface UserQueryInfo
{
	/**
	 * ���[�UID�̐ݒ�
	 * 
	 * @param userId ���[�UID
	 */
	public void setUserId(String userId);
	
	/**
	 *  ���[�UID�̎擾
	 * 
	 * @return String ���[�UID
	 */
	public String getUserId();
	
	/**
	 * �����̐ݒ�
	 * 
	 * @param name ����
	 */
	public void setName(String name);
	
	/**
	 * �����̎擾
	 * 
	 * @return String ����
	 */
	public String getName();

	/**
	 * �p�X���[�h�̐ݒ�
	 * 
	 * @param password �p�X���[�h
	 */
	public void setPassword(String password);
	
	/**
	 *  �p�X���[�h�̎擾
	 * 
	 * @return String �p�X���[�h
	 */
	public String getPassword();
	
	/**
	 * �����g�DNo�̐ݒ�
	 * 
	 * @param sectionNo ����No
	 */
	public void setSectionNo(String sectionNo);
	
	/**
	 * �����g�DNo�̎擾
	 * 
	 * @return String �����g�DNo
	 */
	public String getSectionNo();
	
	/**
	 * ����No�̐ݒ�
	 * 
	 * @param sectionNo ����No
	 */
	public void setRoleNo(String roleNo);
	
	/**
	 * ����No�̎擾
	 * 
	 * @return String �����g�DNo
	 */
	public String getRoleNo();

	
}