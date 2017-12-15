/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/04/27
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/18 BY. ZHANGXINFENG (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.view.upload;
/**
 * アップロードのFileInformation <BR>
 */
public class FileInformation {
	
	// ファイル名前の設定
	private String fileName = "";
	
	// ファイルパスの設定
	private String fileSrc = "";
	
	// imageパスの設定
	private String incoPath = "";
	
	// imageパスを取得する
	public String getIncoPath() {
		return incoPath;
	}
	
	// imageパスの設定
	public void setIncoPath(String incoPath) {
		this.incoPath = incoPath;
	}
	
	// ファイル名前を取得する
	public String getFileName() {
		return fileName;
	}
	
	// ファイル名前の設定
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// ファイルパスを取得する
	public String getFileSrc() {
		return fileSrc;
	}

	// ファイルパスの設定
	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

}
