/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.common.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class ValidateMulti implements IValidate {
	/**
	 * チェックのリスト
	 */
	private List<IValidate> validateList = new ArrayList<IValidate>();

	/**
	 * 
	 * 
	 * @param params チェックインフォ
	 */
	public void init(Map params) {

	}

	/**
	 * 
	 * @param item
	 */
	public void Add(IValidate item) {
		validateList.add(item);
	}

	/**
	 * 
	 */
	public String print() {
		String result = "";
		for (int i = 0; i < validateList.size(); i++) {
			result += validateList.get(i).print();
		}

		return result;
	}
}
