/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/26
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/04/26 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.dao.joblist;

import java.util.List;

import flowbuilder.domain.joblist.JobList;
import fbcom.framework.exceptions.SysException;

/**
 * �W���u���X�g����̃C���^�t�F�[�X
 */
public interface JobListDAO {
	/**
	 * �����ɂ���āA�W���u���X�g�ŋL�^�̐��ʂ�߂�
	 * 
	 * @param query�@��������
	 * @return �W���u���X�g�ŋL�^�̐���
	 * @throws SysException xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public int getCount(JobListQueryInfo query) throws SysException;

	/**
	 * �W���u���X�g���擾����
	 * 
	 * @param query ��������
	 * @return�@�W���u�L�^���i�[�������X�g
	 * @throws SysException xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public List<JobList> getJobList(JobListQueryInfo query) throws SysException;

	/**
	 * �W���u���X�g��ǉ�����
	 *
	 * @param joblist �W���u�L�^
	 * @throws SysException xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public void insert(JobList joblist) throws SysException;

	/**
	 * �W���u���X�g�̍X�V
	 * 
	 * @param joblist�@�W���u�L�^
	 * @throws SysException xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public void update(JobList joblist) throws SysException;

	/**
	 * ���X�g���Č��폜
	 * 
	 * @param strJobId�@�W���uID
	 * @throws SysException xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public void delete(String strJobId) throws SysException;
}
