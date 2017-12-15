package flowbuilder.presentation.webcmn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;


/**
 * Web�A�v���P�[�V�������ŏ��Ƀ��[�h���ꂽ�Ƃ��ɁA�A�v���P�[�V������ <BR>
 * ���ʂɎg���N���X�𐶐����āAServletContext�ɂ��炩���ߓo�^���Ă����B
 * 
 * Struts�̃v���O�C���𗘗p���ăA�v���P�[�V�����̏��������s���B <BR>
 * ���̃N���X��struts-config.xml��plugin�o�^����K�v�B�B
 *  
 */

public final class AppInitializer implements PlugIn
{
	/**
	 * ���O
	 */
	private static Log _log = LogFactory.getLog(AppInitializer.class);

	/**
	 * ���W���[�����N������ʒm���󂯎��܂��B <BR>
	 * ���ʏ��ServletContext�ɓo�^����B
	 * 
	 * @param servlet ���̃E�F�b�u�A�v���P�[�V�����̑S�Ẵ��W���[������������ActionServlet
	 * @param config ���̃v���O�C���Ɋ֘A�t����ꂽ���W���[����ModuleConfig
	 * @throws ServletException 
	 */
	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException
	{
	ServletContext context = servlet.getServletConfig().getServletContext();

		try
		{
			ApplicationBeansCreator beansCreator = new ApplicationBeansCreator(context);
//			// ���i�I�u�W�F�N�g�쐬
//			qualityBean quality = new qualityBean();
//
//			beansCreator.makeConnXmlBean(context,quality);
//			beansCreator.makeFileXmlBean(context,quality);
//			beansCreator.makeUserXmlBean(context,quality);
//			beansCreator.makeJobListXmlBean(context,quality);
//			beansCreator.makeOprXmlBean(context,quality);
//			beansCreator.makeJobXmlBean(context,quality);
	}
		catch (Exception e)
		{
			_log.error(e.getMessage(), e);
			throw new ServletException(e.getMessage(), e);
		}
	}

	/**
	 * ���W���[�����I������ʒm���󂯎��܂��B
	 */
	public void destroy()
	{
	}
}