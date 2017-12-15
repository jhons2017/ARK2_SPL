package flowbuilder.daoimpl.flowbuilder.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.user.RoleDAO;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.domain.user.Role;

final class RoleDAOImpl implements RoleDAO {
	/**
	 * ���M���O
	 */
	private static Log _log = LogFactory.getLog(UserDAOImpl.class);
	
	private Document filedoc = null;
	
	/**
	 * 
	 *
	 */
	public RoleDAOImpl(){
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");
		String roleXmlPath = fileconn.getFileDir("manage","roles.xml");
		
		//�h�L�������g�̎擾
		filedoc = DBXmlFileConn.getDocument(roleXmlPath);
	}
	
	/**
	 * ���� �����̎擾
	 * 
	 * @return Count �����̐�
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public int getCount() throws XmlAccessSysException {
		return 0;
	}

	/**
	 * ���� List �̎擾
	 * 
	 * @param beginIndex �����J�n�C���f�b�N�X�i1�ȏ�)
	 * @param count �擾�����������̐��i1�ȏ�j
	 * @return List ���g�� Section
	 * @throws IndexOutOfBoundsException �z��̋��E�𒴂��ăA�N�Z�X�����̏ꍇ
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List getList(int beginIndex, int count) throws XmlAccessSysException {
		return null;
	}

	/**
	 * ���� List �̎擾
	 * 
	 * @return List ���g�� Cause �����敪
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List getList() throws XmlAccessSysException {
		int count = 2;
		
		String firstTag = "role1";
		
		Role role = null;
		
		List<Role> roleGrp = new ArrayList<Role>();
		
		
		while(filedoc.getElementsByTagName(firstTag).getLength() != 0){
			NodeList roleList = filedoc.getElementsByTagName(firstTag);
			int roleListCount = roleList.getLength();
			for(int i=0;i<roleListCount;i++){
				Element element = (Element)roleList.item(i);
					
				String strRoleId = element.getAttribute("id");
				String strRoleName = element.getAttribute("name");
	
				role = new Role();
				
				role.setRoleID(strRoleId);
				 
				role.setRoleName(strRoleName);
				
				roleGrp.add(role);
			}
			
			firstTag = "role" + count++;
			
		}
		
		return roleGrp;
	}

	/**
	 * ���� �̎擾
	 * 
	 * @param ��������No ����No
	 * @return Section ����
	 * @throws XmlAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public Role select(String roleNo) throws XmlAccessSysException {
		List<Role> roleGrp = this.getList();
		
		Role role = null;

		int length = roleGrp.size();
		
		for(int i=0;i<length;i++){
			role = roleGrp.get(i);
			if(roleNo.equals(role.getRoleId())){
				break;
			}
		}	
		return role;
	}
	
}
