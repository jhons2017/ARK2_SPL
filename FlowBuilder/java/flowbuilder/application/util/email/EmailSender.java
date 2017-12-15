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
 *　メールを発送実装　<br>
 */
public class EmailSender implements Runnable {	
	/**
	 * メールBEAN。発送の必要なインフォ。
	 */
	private EmailBean email = null;
	
	/**
	 * メールのサービス。
	 */
	private EmailService service = null;
	
	/**
	 * メールの発信
	 */
	private String sender = null;
	
	/**
	 * メールのusername
	 */
	private String userName = null;
	
	/**
	 * メールのパサワード
	 */
	private String password = null;
	/**
	 * メールの方法 
	 */
	private String hostKey = null;
	
	/**
	 * host IP
	 */
	private String hostValue = null;
	
	/**
	 * コンストラクタ
	 * 
	 * @param id メールID
	 * @param curState　今の状態
	 * @param doc　案件ドキュメント
	 */
	public EmailSender(String id, String curState, Document doc){
		service = new EmailService();
		//メールBEANを取得する。
		email = service.getEmailBean(id, curState,doc);
		
		ConfigReader conf = FlowBuilderSystemConfig.getInstance();
		this.sender = conf.getValue("sender.Email");
		this.userName = conf.getValue("sender.username");
		this.password = conf.getValue("sender.password");
		this.hostKey = conf.getValue("Email.smtp.host.key");
		this.hostValue = conf.getValue("Email.smtp.host.value");
	}
	
	/**
	 * 送信先リストに登録されている件数分、メールの送信を行う。
	 */
	public void run() {
		try { 
			// 宛先一覧を取得する
			String reciverEmailAddr = email.getReciverEmailAddress();
			// CC一覧を取得する
			String ccEmailAdress = email.getCCEmailAddress();
			// メール主題を取得する
			String emailTitle = email.getEmailTitle();
			// メール内容を取得する
			String emailContent = email.getEmailContent();
			
			if (reciverEmailAddr != null && !"".equals(reciverEmailAddr)  ) {
				Properties props = new Properties();
				
				// SMTPの主機を設置する
				props.put(hostKey, hostValue);
				
				// 検証を通過する
				props.put("mail.smtp.auth", "true");
				
				// メール会話を 設置
				Session session = Session.getInstance(props, null);
				MimeMessage message = new MimeMessage(session);
				
				// 発送者のアドレス
				Address from = new InternetAddress(sender);
				message.setFrom(from);
				
				// E-mailの方法を受理（TO、CC）
				Address[] reciverAddr = InternetAddress.parse(reciverEmailAddr);
				Address[] ccAddr = InternetAddress.parse(ccEmailAdress);
				message.setRecipients(Message.RecipientType.TO, reciverAddr);
				message.setRecipients(Message.RecipientType.CC, ccAddr);
				
				// 内容コ-ディングの 設置
				message.setText(emailContent, "UTF-8");
				
				// タイトルコ-ディングの 設置
				message.setSubject(emailTitle, "UTF-8"); 
	
				// 時間を取得する
				message.setSentDate(new Date());
				
				// 情報を保存する
				message.saveChanges();
				
				// 発信の言語を指定する
				Transport transport=session.getTransport("smtp");
				// smtp方式によって登録する
				transport.connect(hostValue, userName, password);
				// 発送
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			}
		} catch (MessagingException e) {
			System.out.println(e.toString());
		}
	}
}
