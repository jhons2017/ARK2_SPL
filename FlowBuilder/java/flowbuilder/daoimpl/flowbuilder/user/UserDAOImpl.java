/**
 * 
 */
package flowbuilder.daoimpl.flowbuilder.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.DataAccessAppException;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserQueryInfo;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.domain.user.User;
import flowbuilder.domain.user.UserRole;


/**
 * @author hx0163
 *
 */
final class UserDAOImpl implements UserDAO {
	/**
	 * ロギング
	 */
	private static Log _log = LogFactory.getLog(UserDAOImpl.class);
	
	/**
	 * ファイルのパース
	 */
	private String userXmlPath = "";
	
	/**
	 * DOMのドキュメント
	 */
	private Document filedoc = null;
	
	/**
	 * 
	 *
	 */
	public UserDAOImpl(){
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");
		userXmlPath = fileconn.getFileDir("manage","users.xml");
		
		//ドキュメントの取得
		filedoc = DBXmlFileConn.getDocument(userXmlPath);
	}
	
	
	/**
	 * ユーザー件数の取得
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @return int ユーザー件数
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public int getCount(UserQueryInfo query) throws XmlAccessSysException {
		return 0;
	}

	/**
	 * ユーザー SummaryList の取得
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @param beginIndex 表示開始インデックス
	 * @param count 表示件数
	 * @return List 中身は、UserDTO
	 * @throws IndexOutOfBoundsException 配列の境界を超えてアクセスしたの場合
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List getSummaryList(UserQueryInfo query, int beginIndex, int count) throws XmlAccessSysException {
		return null;
	}
	
	/**
	 * ユーザー情報リストの取得 
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @return List 中身は User 
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<User> getList(UserQueryInfo query) throws XmlAccessSysException {
		return null;
	}
	
	/**
	 * ユーザー情報リストの取得 
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @return List 中身は User 
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<User> getUpUsersId(String orgId,String roleId) throws XmlAccessSysException {
		
		List<User> userList = new ArrayList<User>();
		User user = null;
		
		NodeList users = filedoc.getElementsByTagName("user"); 
	
		int userLength = users.getLength();
		
		for (int j = 0; j < userLength; j++) {
			
			Element userLink = (Element) users.item(j);
			
			String userRole = userLink.getAttribute("roleid");
			
			if (userRole.equals(roleId)) {
				
				String userOrg = userLink.getAttribute("orgid");
				
				if(orgId.indexOf(userOrg) != -1) {
					
					user = new User();
					
					user.setLoginName(userLink.getAttribute("userid"));
					user.setUserName(userLink.getAttribute("name"));
					user.setEmail(userLink.getAttribute("Email"));
					user.setOrgid(userOrg);
					user.setPassword(userLink.getAttribute("password"));
					this.setUserRole(user,userRole);
					
					userList.add(user);
				}	
			}
		}
		
		return userList;
	}

	/**
	 * ユーザー情報リストの取得 
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @return List 中身は User 
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public List<User> getListByOrgId(String sectionNo) throws XmlAccessSysException {
		//ユーザレスト
		List<User> userList = new ArrayList<User>();
		
		//ユーザ
		User user = null;
		
		//全部のユーザを取得
		NodeList users = filedoc.getElementsByTagName("user"); 
	
		int userLength = users.getLength();
		
		for (int j = 0; j < userLength; j++) {
			
			Element userLink = (Element) users.item(j);
			
			//所属組織のユーザを取得
			if(userLink.getAttribute("orgid").indexOf(sectionNo) == 0){
				user = new User();
				user.setLoginName(userLink.getAttribute("userid"));
				user.setUserName(userLink.getAttribute("name"));
				if (userList.size() == 0) {
					userList.add(user);
				}
				boolean hasAdded = false;
				int len = userList.size();
				//同じのユーザ、追加ない
				for (int i = 0; i < len; i++) {
					if (userLink.getAttribute("userid").equals(((User)userList.get(i)).getLoginName())){
						hasAdded = true;
						break;
					}
				}
				if (!hasAdded) {
					userList.add(user);
				}
			}
		}
		return userList;
	}
	
	/**
	 * ユーザー情報リストの取得 
	 * 検索条件に1件も該当しなかった場合は、空のListを返す。 <BR>
	 * 
	 * @param query UserQueryInfo 検索条件
	 * @return List 中身は User 
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public List<User> getList(String loginName) throws XmlAccessSysException{
		List<User> userList = new ArrayList<User>();
		User user = null;
		
		NodeList users = filedoc.getElementsByTagName("user");
		
		int userLength = users.getLength();
		
		for(int i=0;i<userLength;i++){
			Element userElm = (Element)users.item(i);
			
			if(loginName.equals(userElm.getAttributeNode("userid").getNodeValue())){
				user = new User();
				user.setLoginName(loginName);
				user.setUserName(userElm.getAttributeNode("name").getNodeValue());
				user.setOrgid(userElm.getAttributeNode("orgid").getNodeValue());
				user.setPassword(userElm.getAttributeNode("password").getNodeValue());
				this.setUserRole(user,userElm.getAttributeNode("roleid").getNodeValue());
				userList.add(user);
			}
		}
		
		return userList;
	}
	
	/**
	 * ユーザーの取得
	 * 
	 * @param loginName ログイン名称
	 * @return User ユーザー
	 * @throws XmlAccessSysException システムエラーの場合
	 */
	public User select(String loginName) throws XmlAccessSysException {
		//ユーザBEAN
		User user = null;
		
		NodeList users = filedoc.getElementsByTagName("user");
		
		int userLength = users.getLength();
		
		for(int i=0;i<userLength;i++){
			Element userElm = (Element)users.item(i);
			
			if(loginName.equals(userElm.getAttributeNode("userid").getNodeValue())){
				user = new User();
				user.setLoginName(loginName);
				user.setUserName(userElm.getAttributeNode("name").getNodeValue());
				user.setOrgid(userElm.getAttributeNode("orgid").getNodeValue());
				user.setPassword(userElm.getAttributeNode("password").getNodeValue());
				this.setUserRole(user,userElm.getAttributeNode("roleid").getNodeValue());
				user.setEmail(userElm.getAttribute("Email"));
				break;
			}
			
		}
		return user;
	}

	
	/**
	 * ユーザーの取得
	 * 
	 * @param loginName ログイン名称
	 * @param orgId 組織名称
	 * @return User ユーザー
	 * @throws DataAccessSysException システムエラーの場合
	 */
	public User select(String loginName,String orgId) throws XmlAccessSysException{
		
		//ユーザBEAN
		User user = null;
		
		NodeList users = filedoc.getElementsByTagName("user");
		
		int userLength = users.getLength();
		
		for(int i=0;i<userLength;i++){
			Element userElm = (Element)users.item(i);
			
			if(loginName.equals(userElm.getAttributeNode("userid").getNodeValue()) && orgId.equals(userElm.getAttributeNode("orgid").getNodeValue())){
				user = new User();
				user.setLoginName(loginName);
				user.setUserName(userElm.getAttributeNode("name").getNodeValue());
				user.setOrgid(userElm.getAttributeNode("orgid").getNodeValue());
				user.setPassword(userElm.getAttributeNode("password").getNodeValue());
				this.setUserRole(user,userElm.getAttributeNode("roleid").getNodeValue());
				break;
			}
			
		}
		return user;
		
	}
	
	
	/**
	 * ユーザー の登録
	 * 
	 * @param user ユーザー
	 * @throws XmlAccessSysException システムエラーの場合
	 * @throws DataAccessAppException アプリケーションエラーの場合。
	 */
	public void insert(User user) throws XmlAccessSysException {
	}

	/**
	 * ユーザーの編集
	 * 
	 * @param user ユーザー
	 * @throws XmlAccessSysException システムエラーの場合
	 * @throws DataAccessAppException アプリケーションエラーの場合。
	 */
	public void update(User user) throws XmlAccessSysException {
		String userID = user.getLoginName();
		
		NodeList users = filedoc.getElementsByTagName("user");
		
		int userLength = users.getLength();
		
		for(int i=0;i<userLength;i++){
			Element userElm = (Element)users.item(i);
			
			if(userID.equals(userElm.getAttributeNode("userid").getNodeValue())){
				userElm.setAttribute("password",user.getPassword());
			}	
		}
		DBXmlFileConn.writeXml(filedoc,userXmlPath);
	}

	/**
	 * ユーザーの削除
	 * 
	 * @param userNo ユーザーNo
	 * @throws XmlAccessSysException システムエラーの場合
	 * @throws DataAccessAppException アプリケーションエラーの場合。
	 */
	public void delete(String userNo) throws XmlAccessSysException {
	}
	

	/**
	 * ユーザーロールの設定
	 * 
	 * @param user ユーザー
	 * @throws SQLException
	 * @throws XmlAccessSysException 
	 */
	private void setUserRole(User user,String roleId) throws XmlAccessSysException
	{
		UserRole role = UserRole.getInstance(roleId);
		user.setUserRole(role);
	}
}