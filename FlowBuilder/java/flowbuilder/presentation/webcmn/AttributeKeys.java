package flowbuilder.presentation.webcmn;

/**
 * ���̃C���^�[�t�F�[�X�́AServletContext, Session, ServletRequest�փI�u�W�F�N�g���i�[����Ƃ��̃L�[���`����B
 * 
 * ServletContext�փI�u�W�F�N�g���i�[����Ƃ��̃L�[�̒萔���� CONTEXT_ �Ŏn�܂���̂Ƃ���B
 * Session�փI�u�W�F�N�g���i�[����Ƃ��̃L�[�̒萔���� SESSION_ �Ŏn�܂���̂Ƃ���B
 * ServletRequest�փI�u�W�F�N�g���i�[����Ƃ��̃L�[�̒萔���� REQUEST_ �Ŏn�܂���̂Ƃ���B
 */
public interface AttributeKeys
{
	/**
	 * ���[�U�[���bean��ID
	 */
	public static final String CONTEXT_CONNXMLBEAN = "connXmlBean";
	/**
	 * ���[�U�[���bean��ID
	 */
	public static final String CONTEXT_FILEXMLBEAN = "fileXmlBean";
	/**
	 * ���[�U�[���bean��ID
	 */
	public static final String CONTEXT_USERXMLBEAN = "userXmlBean";

	/**
	 * jobListXml���bean��ID
	 */
	public static final String CONTEXT_JOBLISTXMLBEAN = "jobListXmlBean";

	/**
	 * ���[�U�[���bean��ID
	 */
	public static final String CONTEXT_OPRXMLBEAN = "oprXmlBean";

	/**
	 * ���[�U�[���bean��ID
	 */
	public static final String CONTEXT_JOBXMLBEAN = "jobXmlBean";
}