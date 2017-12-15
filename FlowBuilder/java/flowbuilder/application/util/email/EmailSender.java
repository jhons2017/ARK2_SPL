/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/13
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/13 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.application.util.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.w3c.dom.Document;

import fbcom.framework.dao.conf.ConfigReader;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;

/**
 *�@���[���𔭑������@<br>
 */
public class EmailSender implements Runnable {	
	/**
	 * ���[��BEAN�B�����̕K�v�ȃC���t�H�B
	 */
	private EmailBean email = null;
	
	/**
	 * ���[���̃T�[�r�X�B
	 */
	private EmailService service = null;
	
	/**
	 * ���[���̔��M
	 */
	private String sender = null;
	
	/**
	 * ���[����username
	 */
	private String userName = null;
	
	/**
	 * ���[���̃p�T���[�h
	 */
	private String password = null;
	/**
	 * ���[���̕��@ 
	 */
	private String hostKey = null;
	
	/**
	 * host IP
	 */
	private String hostValue = null;
	
	/**
	 * �R���X�g���N�^
	 * 
	 * @param id ���[��ID
	 * @param curState�@���̏��
	 * @param doc�@�Č��h�L�������g
	 */
	public EmailSender(String id, String curState, Document doc){
		service = new EmailService();
		//���[��BEAN���擾����B
		email = service.getEmailBean(id, curState,doc);
		
		ConfigReader conf = FlowBuilderSystemConfig.getInstance();
		this.sender = conf.getValue("sender.Email");
		this.userName = conf.getValue("sender.username");
		this.password = conf.getValue("sender.password");
		this.hostKey = conf.getValue("Email.smtp.host.key");
		this.hostValue = conf.getValue("Email.smtp.host.value");
	}
	
	/**
	 * ���M�惊�X�g�ɓo�^����Ă��錏�����A���[���̑��M���s���B
	 */
	public void run() {
		try { 
			// ����ꗗ���擾����
			String reciverEmailAddr = email.getReciverEmailAddress();
			// CC�ꗗ���擾����
			String ccEmailAdress = email.getCCEmailAddress();
			// ���[�������擾����
			String emailTitle = email.getEmailTitle();
			// ���[�����e���擾����
			String emailContent = email.getEmailContent();
			
			if (reciverEmailAddr != null && !"".equals(reciverEmailAddr)  ) {
				Properties props = new Properties();
				
				// SMTP�̎�@��ݒu����
				props.put(hostKey, hostValue);
				
				// ���؂�ʉ߂���
				props.put("mail.smtp.auth", "true");
				
				// ���[����b�� �ݒu
				Session session = Session.getInstance(props, null);
				MimeMessage message = new MimeMessage(session);
				
				// �����҂̃A�h���X
				Address from = new InternetAddress(sender);
				message.setFrom(from);
				
				// E-mail�̕��@���󗝁iTO�ACC�j
				Address[] reciverAddr = InternetAddress.parse(reciverEmailAddr);
				Address[] ccAddr = InternetAddress.parse(ccEmailAdress);
				message.setRecipients(Message.RecipientType.TO, reciverAddr);
				message.setRecipients(Message.RecipientType.CC, ccAddr);
				
				// ���e�R-�f�B���O�� �ݒu
				message.setText(emailContent, "UTF-8");
				
				// �^�C�g���R-�f�B���O�� �ݒu
				message.setSubject(emailTitle, "UTF-8"); 
	
				// ���Ԃ��擾����
				message.setSentDate(new Date());
				
				// ����ۑ�����
				message.saveChanges();
				
				// ���M�̌�����w�肷��
				Transport transport=session.getTransport("smtp");
				// smtp�����ɂ���ēo�^����
				transport.connect(hostValue, userName, password);
				// ����
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			}
		} catch (MessagingException e) {
			System.out.println(e.toString());
		}
	}
}
