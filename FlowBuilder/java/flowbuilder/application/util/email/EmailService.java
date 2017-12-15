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

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.util.JobOprater;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.User;

/**
 *�@ ���[���̃T�[�r�X�B
 */
class EmailService {
	/**
	 * ���[���̓��e�ɑ���p�̃N���X
	 */
	private EmailEntry emailEntry = null;
	
	/**
	 * �R���X�g���N�^
	 */
	EmailService() {
		emailEntry = new EmailEntry();
	}

	/**
	 * ���[��BEAN���쐬����B
	 * 
	 * @param id�@���[��ID�B
	 * @param state�@���̏�ԁB
	 * @param doc�@�Č��h�L�������g�B
	 * @return�@emailBean�@���[��BEAN�B
	 */
	public EmailBean getEmailBean(String id, String state, Document doc) {
		EmailBean emailBean = new EmailBean();
		
		String content = emailEntry.getContent(id, state);
		
		if(!"".equals(content)) {
			// ���惊�X�g���擾����
			emailBean.setReciverEmailAddress(getReciverEmailAddress(id, state, doc));
			// CC���X�g���擾����
			emailBean.setCCEmailAddress(emailEntry.getCCEmailAddres(id, state));
			// ���[�������擾����
			emailBean.setEmailTitle(emailEntry.getTitle());
			// ���[�����e���擾����
			emailBean.setContent(replaceContent(content, doc));
		}
		return emailBean;
	}
	
	/**
	 * ���[���̓��e���ɂ́A�ω����e��u���������ʐ��������A�V�����������Ԃ��܂�
	 * 
	 * @param content�@�u�����Ȃ����e
	 * @param doc�@�Č��̃h�L�������g
	 * @return�@content�@�V����������
	 */
	private String replaceContent(String content, Document doc){
		EmailOperator emailOpr = new EmailOperator(doc);
		EmaiReplacedBean email = null;
		// ���e��u�����邱�Ƃ�u������邱�ƂƎ擾����
		List<EmaiReplacedBean> emailList = emailOpr.getRepBeanList();
		int length = emailList.size();
		// �u�����Ȃ����e
		String newContent = content;
		for (int i=0;i<length;i++) {	
			email = emailList.get(i);
			// �u�����Ȃ����e�iID��Value�ɕϊ�����j
			newContent = newContent.replace(email.getId(), email.getValue());
		}
		//�@�V�����������Ԃ��܂�
		return newContent;
	}
	
	
	/**
	 * ���惊�X�g���쐬����B
	 * @param id�@���[��ID�B
	 * @param state�@���̏�ԁB
	 * @param doc�@�Č��̃h�L�������g
	 * @return�@���惊�X�g�B
	 */
	private String getReciverEmailAddress(String id, String State, Document doc) {
		String emailList = "";
		List<User> userList = null;
		JobOprater jobOpr = new JobOprater();
		boolean isCircular = emailEntry.isCircular(id, State);
		//�@�񗗂̏ꍇ�A���惊�X�g���擾����
		if (isCircular) {
			if (getProblemFlg(doc) == "0") {
				userList = jobOpr.getCircularList(doc);
			}		
		//�@�񗗈ȊO�̏ꍇ�A���惊�X�g���擾����
		} else {
			if (getProblemFlgEnd(doc) == "3") {
				userList = jobOpr.getCreater(doc);
			} else {
				userList = jobOpr.getApprovalerList(doc);
			}
		}
		if (userList == null) {
			emailList = "";
		}else{
			// ����A�h���X�̕�������쐬����
			int length = userList.size();
			for (int index = 0; index < length; index++) {
				if (index < length - 1) {
					emailList = emailList + userList.get(index).getEmail() + ",";
				} else {
					emailList = emailList + userList.get(index).getEmail();
				}
			}
		}
		// ���惊�X�g��ԋp����
		return emailList;
	}
	
	/**
	 * ��Ԃ��m�F����
	 * @param doc�@�Č��̃h�L�������g
	 * @return�@flg�@��Ԃ��m�F�itrue or false�j
	 */
	private String getProblemFlg(Document doc) {
		String flg = "0";
		String problemFlg = "";
		// ����҂��m�F
		NodeList members = doc.getElementsByTagName("member");
		int length = members.getLength();
		for (int i = 0; i < length; i++) {
			problemFlg = XmlOperator.getAttrValue((Element)members.item(i), "problemFlg");
			if (problemFlg != "0") {
				flg = "1";
				break;
			}
		}
		return flg;
	}
	
	/**
	 * ��Ԃ��m�F����
	 * @param doc�@�Č��̃h�L�������g
	 * @return�@flg�@��Ԃ��m�F�itrue or false�j
	 */
	private String getProblemFlgEnd(Document doc) {
		String flg = "3";
		String problemFlg = "";
		// ����҂��m�F
		NodeList members = doc.getElementsByTagName("member");
		int length = members.getLength();
		for (int i = 0; i < length; i++) {
			problemFlg = XmlOperator.getAttrValue((Element)members.item(i), "problemFlg");
			if (!"3".equals(problemFlg)) {
				flg = "1";
				break;
			}
		}
		return flg;
	}
}