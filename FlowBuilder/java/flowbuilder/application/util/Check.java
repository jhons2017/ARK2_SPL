package flowbuilder.application.util;

import org.w3c.dom.Element;


public interface Check {
	
	//============================================================
	//条件チェック
	//============================================================
	public boolean checkCondition(String strConditions, String strCond);

	//============================================================
	//参照可能組織条件を解析
	//============================================================
	public boolean checkSeeOrg(Element JobElement, String strCondition);

	//============================================================
	//参照可能役割条件を解析
	//============================================================
	public boolean checkSeeRole(Element JobElement, String strCondition);
}
