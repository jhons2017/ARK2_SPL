package flowbuilder.application.util;

import org.w3c.dom.Element;


public interface Check {
	
	//============================================================
	//�����`�F�b�N
	//============================================================
	public boolean checkCondition(String strConditions, String strCond);

	//============================================================
	//�Q�Ɖ\�g�D���������
	//============================================================
	public boolean checkSeeOrg(Element JobElement, String strCondition);

	//============================================================
	//�Q�Ɖ\�������������
	//============================================================
	public boolean checkSeeRole(Element JobElement, String strCondition);
}
