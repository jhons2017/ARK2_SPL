/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package fbcom.framework.dao.conf;

/**
 * �ݒ�t�@�C���̓ǂݍ��݂��s�Ȃ��B
 */
public interface ConfigReader
{
	/**
	 * key�ɑ΂���l���擾����B
	 * key�����݂��Ȃ��ꍇ�́Anull��Ԃ��B
	 * @param key �L�[
	 * @return key�ɑ΂���l
	 */
	public String getValue(String key);
}
