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
	 * ���M���O
	 */
	private static Log _log = LogFactory.getLog(UserDAOImpl.class);
	
	/**
	 * �t�@�C���̃p�[�X
	 */
	private String userXmlPath = "";
	
	/**
	 * DOM�̃h�L�������g
	 */
	private Document filedoc = null;
	
	/**
	 * 
	 *
	 */
	public UserDAOImpl(){
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");
		userXmlPath = fileconn.getFileDir("manage","users.xml");
		
		//�h�L�������g�̎擾
		filedoc = DBXmlFileConn.getDocument(userXmlPath);
	}
	
	
	/**
	 * ���[�U�[�����̎擾
	 * 
	 * @param query UserQueryInfo ��������
	 * @return int ���[�U�[����
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public int getCount(UserQueryInfo query) throws XmlAccessSysException {
		return 0;
	}

	/**
	 * ���[�U�[ SummaryList �̎擾
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param query UserQueryInfo ��������
	 * @param beginIndex �\���J�n�C���f�b�N�X
	 * @param count �\������
	 * @return List ���g�́AUserDTO
	 * @throws IndexOutOfBoundsException �z��̋��E�𒴂��ăA�N�Z�X�����̏ꍇ
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List getSummaryList(UserQueryInfo query, int beginIndex, int count) throws XmlAccessSysException {
		return null;
	}
	
	/**
	 * ���[�U�[��񃊃X�g�̎擾 
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param query UserQueryInfo ��������
	 * @return List ���g�� User 
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<User> getList(UserQueryInfo query) throws XmlAccessSysException {
		return null;
	}
	
	/**
	 * ���[�U�[��񃊃X�g�̎擾 
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param query UserQueryInfo ��������
	 * @return List ���g�� User 
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
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
	 * ���[�U�[��񃊃X�g�̎擾 
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param query UserQueryInfo ��������
	 * @return List ���g�� User 
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<User> getListByOrgId(String sectionNo) throws XmlAccessSysException {
		//���[�U���X�g
		List<User> userList = new ArrayList<User>();
		
		//���[�U
		User user = null;
		
		//�S���̃��[�U���擾
		NodeList users = filedoc.getElementsByTagName("user"); 
	
		int userLength = users.getLength();
		
		for (int j = 0; j < userLength; j++) {
			
			Element userLink = (Element) users.item(j);
			
			//�����g�D�̃��[�U���擾
			if(userLink.getAttribute("orgid").indexOf(sectionNo) == 0){
				user = new User();
				user.setLoginName(userLink.getAttribute("userid"));
				user.setUserName(userLink.getAttribute("name"));
				if (userList.size() == 0) {
					userList.add(user);
				}
				boolean hasAdded = false;
				int len = userList.size();
				//�����̃��[�U�A�ǉ��Ȃ�
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
	 * ���[�U�[��񃊃X�g�̎擾 
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param query UserQueryInfo ��������
	 * @return List ���g�� User 
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
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
	 * ���[�U�[�̎擾
	 * 
	 * @param loginName ���O�C������
	 * @return User ���[�U�[
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public User select(String loginName) throws XmlAccessSysException {
		//���[�UBEAN
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
	 * ���[�U�[�̎擾
	 * 
	 * @param loginName ���O�C������
	 * @param orgId �g�D����
	 * @return User ���[�U�[
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public User select(String loginName,String orgId) throws XmlAccessSysException{
		
		//���[�UBEAN
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
	 * ���[�U�[ �̓o�^
	 * 
	 * @param user ���[�U�[
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 * @throws DataAccessAppException �A�v���P�[�V�����G���[�̏ꍇ�B
	 */
	public void insert(User user) throws XmlAccessSysException {
	}

	/**
	 * ���[�U�[�̕ҏW
	 * 
	 * @param user ���[�U�[
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 * @throws DataAccessAppException �A�v���P�[�V�����G���[�̏ꍇ�B
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
	 * ���[�U�[�̍폜
	 * 
	 * @param userNo ���[�U�[No
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 * @throws DataAccessAppException �A�v���P�[�V�����G���[�̏ꍇ�B
	 */
	public void delete(String userNo) throws XmlAccessSysException {
	}
	

	/**
	 * ���[�U�[���[���̐ݒ�
	 * 
	 * @param user ���[�U�[
	 * @throws SQLException
	 * @throws XmlAccessSysException 
	 */
	private void setUserRole(User user,String roleId) throws XmlAccessSysException
	{
		UserRole role = UserRole.getInstance(roleId);
		user.setUserRole(role);
	}
}