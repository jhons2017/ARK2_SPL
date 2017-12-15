package flowbuilder.dao.joblist;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;


public abstract class JobListDataAccessFactroy {
	//���M���O
	private static final Log _log = LogFactory.getLog(JobListDataAccessFactroy.class);

	/**
	 * ����Factory�N���X�̃C���X�^���X���擾����B
	 * 
	 * @return ����Factory�N���X�̃C���X�^���X(�C���X�^���X�̐����Ɏ��s�����Ƃ��Anull��Ԃ�)
	 * 
	 * @param implClassRef �����N���X�̊��S�C�����ւ̎Q�ƁB
	 * @exception DataAccessSysException �f�[�^�A�N�Z�X�̃V�X�e���G���[�̏ꍇ�B
	 */
	public static JobListDataAccessFactroy getFactory(String implClassRef) throws XmlAccessSysException
	{
		JobListDataAccessFactroy result = null;

		try
		{
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			String className = conf.getValue(implClassRef);
			result = (JobListDataAccessFactroy) Class.forName(className).newInstance();
		}
		catch (ClassNotFoundException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		catch (IllegalAccessException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		catch (InstantiationException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		return result;
	}
	
	/**
	 * �W���u���X�g�̃f�[�^�A�N�Z�X�I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return �W���u���X�g�̃f�[�^�A�N�Z�X�I�u�W�F�N�g
	 */
	public abstract JobListDAO createJobListDAO();
	
	/**
	 * �W���u���X�g�̌��������I�u�W�F�N�g�𐶐�����B
	 * 
	 * @return �W���u���X�g�̌��������I�u�W�F�N�g
	 */
	public abstract JobListQueryInfo createJobListQueryInfo();

}
