package flowbuilder.presentation.webcmn;

import javax.servlet.ServletContext;

import fbcom.framework.exceptions.BaseException;

/**
 * Web�A�v���P�[�V�����̋��ʏ���ServletContext�ɓo�^����
 */
public final class ApplicationBeansCreator
{
	/** �R���X�g���N�^ */
	public ApplicationBeansCreator()
	{
	}

	/**
	 * �R���X�g���N�^
	 * 
	 * @param context ServletContext
	 * @throws BaseException �V�X�e����O�p�̋��ʂ̃X�[�p�[�N���X�B
	 */
	public ApplicationBeansCreator(
			ServletContext context) throws Exception
	{
		synchronized (context)
		{
		}
	}

	/**
	 * ���[�U�[���Beans�𐶐�����
	 * 
	 * @param context ServletContext
	 * @throws BaseException ���ʗ�O
	 */
	public final void makeConnXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
			//connXmlBean xmlBean = new connXmlBean(quality);
			//context.setAttribute(AttributeKeys.CONTEXT_CONNXMLBEAN, xmlBean);
		}
	}

	/**
	 * ���[�U�[���Beans�𐶐�����
	 * 
	 * @param context ServletContext
	 * @throws BaseException ���ʗ�O
	 */
	public final void makeFileXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			dddd bean = new xmlFileOperate(quality);
//
//			System.out.println("fileXmlBean");
//			context.setAttribute(AttributeKeys.CONTEXT_FILEXMLBEAN, bean);
		}
	}

	/**
	 * ���[�U�[���Beans�𐶐�����
	 * 
	 * @param context ServletContext
	 * @throws BaseException ���ʗ�O
	 */
	public final void makeUserXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			userXmlBean xmlBean = new userXmlBean(quality);
//			context.setAttribute(AttributeKeys.CONTEXT_USERXMLBEAN, xmlBean);
		}
	}

	/**
	 * ���[�U�[���Beans�𐶐�����
	 * 
	 * @param context ServletContext
	 * @throws BaseException ���ʗ�O
	 */
	public final void makeJobListXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			dsgggggg xmlBean = new joblistXmlBean(quality);
//			context.setAttribute(AttributeKeys.CONTEXT_USERXMLBEAN, xmlBean);
		}
	}

	/**
	 * ���[�U�[���Beans�𐶐�����
	 * 
	 * @param context ServletContext
	 * @throws BaseException ���ʗ�O
	 */
	public final void makeOprXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			sdfsdf xmlBean = new oprXmlOperate(quality);
//			context.setAttribute(AttributeKeys.CONTEXT_OPRXMLBEAN, xmlBean);
		}
	}

	/**
	 * ���[�U�[���Beans�𐶐�����
	 * 
	 * @param context ServletContext
	 * @throws BaseException ���ʗ�O
	 */
	public final void makeJobXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			sdfsdf xmlBean = new jobXmlBean(quality);
//			context.setAttribute(AttributeKeys.CONTEXT_JOBXMLBEAN, xmlBean);
		}
	}
}