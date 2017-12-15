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
 *　 メールのサービス。
 */
class EmailService {
	/**
	 * メールの内容に操作用のクラス
	 */
	private EmailEntry emailEntry = null;
	
	/**
	 * コンストラクタ
	 */
	EmailService() {
		emailEntry = new EmailEntry();
	}

	/**
	 * メールBEANを作成する。
	 * 
	 * @param id　メールID。
	 * @param state　今の状態。
	 * @param doc　案件ドキュメント。
	 * @return　emailBean　メールBEAN。
	 */
	public EmailBean getEmailBean(String id, String state, Document doc) {
		EmailBean emailBean = new EmailBean();
		
		String content = emailEntry.getContent(id, state);
		
		if(!"".equals(content)) {
			// 宛先リストを取得する
			emailBean.setReciverEmailAddress(getReciverEmailAddress(id, state, doc));
			// CCリストを取得する
			emailBean.setCCEmailAddress(emailEntry.getCCEmailAddres(id, state));
			// メール主題を取得する
			emailBean.setEmailTitle(emailEntry.getTitle());
			// メール内容を取得する
			emailBean.setContent(replaceContent(content, doc));
		}
		return emailBean;
	}
	
	/**
	 * メールの内容中には、変化内容を置換した結果生成される、新しい文字列を返します
	 * 
	 * @param content　置換しない内容
	 * @param doc　案件のドキュメント
	 * @return　content　新しい文字列
	 */
	private String replaceContent(String content, Document doc){
		EmailOperator emailOpr = new EmailOperator(doc);
		EmaiReplacedBean email = null;
		// 内容を置換することを置換されることと取得する
		List<EmaiReplacedBean> emailList = emailOpr.getRepBeanList();
		int length = emailList.size();
		// 置換しない内容
		String newContent = content;
		for (int i=0;i<length;i++) {	
			email = emailList.get(i);
			// 置換しない内容（IDはValueに変換する）
			newContent = newContent.replace(email.getId(), email.getValue());
		}
		//　新しい文字列を返します
		return newContent;
	}
	
	
	/**
	 * 宛先リストを作成する。
	 * @param id　メールID。
	 * @param state　今の状態。
	 * @param doc　案件のドキュメント
	 * @return　宛先リスト。
	 */
	private String getReciverEmailAddress(String id, String State, Document doc) {
		String emailList = "";
		List<User> userList = null;
		JobOprater jobOpr = new JobOprater();
		boolean isCircular = emailEntry.isCircular(id, State);
		//　回覧の場合、宛先リストを取得する
		if (isCircular) {
			if (getProblemFlg(doc) == "0") {
				userList = jobOpr.getCircularList(doc);
			}		
		//　回覧以外の場合、宛先リストを取得する
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
			// 宛先アドレスの文字列を作成する
			int length = userList.size();
			for (int index = 0; index < length; index++) {
				if (index < length - 1) {
					emailList = emailList + userList.get(index).getEmail() + ",";
				} else {
					emailList = emailList + userList.get(index).getEmail();
				}
			}
		}
		// 宛先リストを返却する
		return emailList;
	}
	
	/**
	 * 状態を確認する
	 * @param doc　案件のドキュメント
	 * @return　flg　状態を確認（true or false）
	 */
	private String getProblemFlg(Document doc) {
		String flg = "0";
		String problemFlg = "";
		// 操作者を確認
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
	 * 状態を確認する
	 * @param doc　案件のドキュメント
	 * @return　flg　状態を確認（true or false）
	 */
	private String getProblemFlgEnd(Document doc) {
		String flg = "3";
		String problemFlg = "";
		// 操作者を確認
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