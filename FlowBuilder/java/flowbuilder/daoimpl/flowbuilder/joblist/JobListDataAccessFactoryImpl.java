package flowbuilder.daoimpl.flowbuilder.joblist;

import flowbuilder.dao.joblist.*;
public final class JobListDataAccessFactoryImpl extends JobListDataAccessFactroy {

	/**
	 * �W���u���X�g�̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return �W���u���X�g�̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public JobListDAO createJobListDAO() {
		return new JobListDAOImpl();
	}
	
	/**
	 * �W���u���X�g�̌��������I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return �W���u���X�g�̌��������I�u�W�F�N�g
	 */
	public JobListQueryInfo createJobListQueryInfo(){
		return new JobListQueryInfoImpl();
	}
}
