package flowbuilder.application.util;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * <<�N���X�̖ړI>> <BR>
 * �Í��^�������A���S���Y��
 */
public class Crypter
{

	/**
	 * <<�R���X�g���N�^�̐���>> <BR>
	 * Crypter�N���X�̃R���X�g���N�^ <BR>
	 * �C���X�^���X������Ȃ��l��private�Ƃ���
	 */
	private Crypter()
	{
	}

	/**
	 * <<���\�b�h�̐���>> <BR>
	 * �Í��^�������A���S���Y�� <BR>
	 * 
	 * @param data ���f�[�^
	 * @param key �Í���
	 * @return byte[] �Í��^�����������f�[�^
	 */
	public static final byte[] crypt(byte[] data, byte[] key)
	{
		byte[] result = null;
		try
		{
			// �r���L�[�ɂ��A�����I�u�W�F�N�g���V�[�h���A
			// �P�o�C�g���ɁA�������������o�C�g�ƃf�[�^��XOR���Í��f�[�^�Ƃ��ĕԂ�
			SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG", "SUN"); // �I�u�W�F�N�g�쐬
			rnd.setSeed(key); // �r���L�[�ɂ��V�[�h
			byte[] mask = new byte[1];
			result = new byte[data.length];
			for (int i = 0; i < data.length; i++)
			{
				rnd.nextBytes(mask); // �����o�C�g�̐���
				result[i] = (byte) (data[i] ^ mask[0]); // �f�[�^�Ɨ����o�C�g��XOR��Ԃ�
			}
		}
		catch (NoSuchAlgorithmException e)
		{
			System.out.println(e.getMessage());
		}
		catch (NoSuchProviderException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return result;
	}

}
