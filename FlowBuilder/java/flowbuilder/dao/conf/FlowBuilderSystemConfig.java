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
package flowbuilder.dao.conf;

import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.dao.conf.PropertyConfigReader;

/**
 * �V�X�e���ݒ�t�@�C���̓ǂݍ��݂��s�Ȃ��B
 * Singleton�p�^�[���Ŏ�������B
 */
public final class FlowBuilderSystemConfig extends PropertyConfigReader
{
	/**
	 * �ݒ�t�@�C���i�v���p�e�B�[�t�@�C���`��)�ւ̃p�X�B
	 * �p�X�́A�N���X�p�X�����[�g�Ƃ��āA���[�g����̐�΃p�X�B
	 */
	private static final String RESOURCE_FILE = "/conf/fbuilder/SystemConfig.properties";
	
	/**
	 * �C���X�^���X
	 */
	private static final ConfigReader INSTANCE = new FlowBuilderSystemConfig();
	
	/**
	 * �C���X�^���X���擾����B
	 * @return ConfigReader�̃C���X�^���X
	 */
	public static ConfigReader getInstance()
	{
		return INSTANCE;
	}

	/**
	 * private�̃R���X�g���N�^�B
	 * �C���X�^���X�́AgetInstance()�ɂ���Ď擾���Ă��炤�B
	 */
	private FlowBuilderSystemConfig()
	{
		super();
	}

	/**
	 * �ݒ�t�@�C���i�v���p�e�B�[�t�@�C���`��)�ւ̃p�X���擾����B
	 * �p�X�́A�N���X�p�X�����[�g�Ƃ��āA���[�g����̐�΃p�X�B
	 * @return �ݒ�t�@�C���̃p�X
	 */
	public String getResourceFile()
	{
		return RESOURCE_FILE;
	}
}
