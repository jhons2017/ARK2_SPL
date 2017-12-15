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

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * �v���p�e�B�[�t�@�C���`���̐ݒ�t�@�C���̓ǂݍ��݂��s�Ȃ��B
 * ���̃N���X���p������ꍇ�ASingleton�p�^�[���Ŏ������s�����ƁB
 */
public abstract class PropertyConfigReader implements ConfigReader
{
	/**
	 * �ݒ��ێ�����N���X
	 */
	private Properties _properties = new Properties();

	/**
	 * ���O
	 */
	private static Log _log = LogFactory.getLog(PropertyConfigReader.class);

	/** 
	 * �R���X�g���N�^
	 */
	public PropertyConfigReader()
	{
		try
		{
			_properties.load(loadFromClass());
		}
		catch(IOException e)
		{
			_log.fatal(e.getMessage(), e);
		}
	}
	
	/**
	 * key�ɑ΂���l���擾����B
	 * key�����݂��Ȃ��ꍇ�́Anull��Ԃ��B
	 * @param key �L�[
	 * @return key�ɑ΂���l
	 */
	public String getValue(String key)
	{
		String result =_properties.getProperty(key);
		if(result == null)
		{
			_log.error("KEY[" + key + "] is not found in " + getResourceFile());
		}
		return result;
	}
	
	/**
	 * ���\�[�X�t�@�C����ǂݍ��ށB
	 * @return InputStream
	 */
	private InputStream loadFromClass()
	{
		return getClass().getResourceAsStream(getResourceFile());
	}

	/**
	 * �ݒ�t�@�C���i�v���p�e�B�[�t�@�C���`��)�ւ̃p�X���擾����B
	 * �p�X�́A�N���X�p�X�����[�g�Ƃ��āA���[�g����̐�΃p�X�B
	 * @return �ݒ�t�@�C���̃p�X
	 */
	public abstract String getResourceFile();
}
