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
package flowbuilder.application.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.safehaus.uuid.UUID;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;


/**
 * ���[�U�[�̃A�N�Z�X�I�u�W�F�N�g
 */
public final class CodeCreator {
	/**
	 * ���M���O
	 */
	private static Log _log = LogFactory.getLog(CodeCreator.class);
	
	
	/**
	 * �t�@�C���̃p�[�X
	 */
	private static String jobCtrlXmlPath = "";
	
	/**
	 * DOM�̃h�L�������g
	 */
	private static Document filedoc = null;
	
	static{
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");
		jobCtrlXmlPath = fileconn.getFileDir("manage","job_control.xml");
	}
	
	/**
	 *  �ŐV�̃W���u�t�@�C���ԍ����擾���� <br>
	 *  
	 * @return �ŐV�̃W���u�t�@�C���ԍ�
	 */
	public static String getJobNo(){

		String strExc="";
		try
		{
			
			//�h�L�������g�̎擾
			filedoc = DBXmlFileConn.getDocument(jobCtrlXmlPath);

			//�i���ۏ�
			_log.info( "�J�n" );

			if ( filedoc != null )
			{
				//Documents�G�������g���擾����
				Element jobnoElement = XmlOperator.getElement( XmlOperator.getNodeList( filedoc, "jobno" ), 0 );

				if ( jobnoElement != null )
				{
					String strNewNum1 = "00000" + XmlOperator.getAttrValue( jobnoElement, "num" );

					strExc = strNewNum1.substring( strNewNum1.length() - 5, strNewNum1.length() );

					//�Ή������l���擾����
					int intNum=Integer.parseInt( XmlOperator.getAttrValue( jobnoElement, "num" ) );

					//���R�[�h���Ƀv���X�P������
					intNum += 1;

					strNewNum1 = "00000" + String.valueOf(intNum);

					String strNewNum2 = strNewNum1.substring( strNewNum1.length() - 5, strNewNum1.length() );

					//�i���ۏ�
					_log.info( "�쐬���ꂽ�V�����h�c�ԍ��F" + strNewNum2 );

					//�V�����h�L�������g����ݒ肷��
					if( XmlOperator.setAttrValue( jobnoElement, "num", strNewNum2 ) )
					{
						//XML�t�@�C����ۑ�����
						DBXmlFileConn.writeXml( filedoc, jobCtrlXmlPath );
					}
					else
					{

						//�i���ۏ�
						_log.info("num �����ݒ�Ɏ��s���܂����B");
					}
				}
				else
				{

					//�i���ۏ�
					_log.info("jobno �G�������g�̎擾�Ɏ��s���܂����B");
				}
			}
			else
			{
	
				//�i���ۏ�
				_log.info("�Č��h�c�Ǘ��w�l�k�h�L�������g�̎擾�Ɏ��s���܂����B");
			}

			//�i���ۏ�
			_log.info( "�I��" );
		}
		catch(Exception e)
		{

			//�i���ۏ�
			_log.fatal( "�v���I�ȃG���[" );
			
			strExc = e.toString();
		}
		String jobId = new UUID().asByteArray().toString();
		jobId = jobId.replace("[","$");
		return jobId;
	}
	
	/**
	 *  �ŐV�̃Z�b�V�����ԍ����擾���� <br>
	 *  
	 * @return �ŐV�̃Z�b�V�����ԍ�
	 */
	public static String getSessionNo(){

		String strExc="";
		try
		{

			//�h�L�������g�̎擾
			filedoc = DBXmlFileConn.getDocument(jobCtrlXmlPath);
			//�i���ۏ�
			_log.info( "�J�n" );

			if ( filedoc != null )
			{
				//Documents�G�������g���擾����
				Element jobnoElement = XmlOperator.getElement( XmlOperator.getNodeList( filedoc, "sessionno" ), 0 );

				if ( jobnoElement != null )
				{
					String strNewNum1 = "00000" + XmlOperator.getAttrValue( jobnoElement, "num" );

					strExc = strNewNum1.substring( strNewNum1.length() - 5, strNewNum1.length() );

					//�Ή������l���擾����
					int intNum=Integer.parseInt( XmlOperator.getAttrValue( jobnoElement, "num" ) );

					//���R�[�h���Ƀv���X�P������
					intNum += 1;

					strNewNum1 = "00000" + String.valueOf(intNum);

					String strNewNum2 = strNewNum1.substring( strNewNum1.length() - 5, strNewNum1.length() );

					//�V�����h�L�������g����ݒ肷��
					if ( strNewNum2.equals("99999") )
					{
						
						if( XmlOperator.setAttrValue( jobnoElement, "num", "00000" ) )
						{

							//XML�t�@�C����ۑ�����
							DBXmlFileConn.writeXml( filedoc, jobCtrlXmlPath );
						}
						else
						{

							//�i���ۏ�
							_log.info("num �����ݒ�Ɏ��s���܂����B");
						}
					}
					else
					{
						
						if( XmlOperator.setAttrValue( jobnoElement, "num", strNewNum2 ) )
						{
							//XML�t�@�C����ۑ�����
							DBXmlFileConn.writeXml( filedoc, jobCtrlXmlPath );
						}
						else
						{
							//�i���ۏ�
							_log.info("num �����ݒ�Ɏ��s���܂����B");
						}
					}
				}
				else
				{
					//�i���ۏ�
					_log.info("sessionno �G�������g�̎擾�Ɏ��s���܂����B");
				}
			}
			else
			{
				//�i���ۏ�
				_log.info("�Č��h�c�Ǘ��w�l�k�h�L�������g�̎擾�Ɏ��s���܂����B");
			}

			//�i���ۏ�
			_log.info( "�I��" );
		}
		catch(Exception e)
		{

			//�i���ۏ�
			_log.fatal( "�v���I�ȃG���[" );
			
			strExc = e.toString();
		}

		return(strExc);
	}

}
