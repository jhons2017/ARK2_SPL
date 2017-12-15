package flowbuilder.application.util;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * <<クラスの目的>> <BR>
 * 暗号／複合化アルゴリズム
 */
public class Crypter
{

	/**
	 * <<コンストラクタの説明>> <BR>
	 * Crypterクラスのコンストラクタ <BR>
	 * インスタンス化されない様にprivateとする
	 */
	private Crypter()
	{
	}

	/**
	 * <<メソッドの説明>> <BR>
	 * 暗号／複合化アルゴリズム <BR>
	 * 
	 * @param data 元データ
	 * @param key 暗合鍵
	 * @return byte[] 暗号／複合化したデータ
	 */
	public static final byte[] crypt(byte[] data, byte[] key)
	{
		byte[] result = null;
		try
		{
			// ビルキーにより、乱数オブジェクトをシードし、
			// １バイト毎に、生成した乱数バイトとデータのXORを暗号データとして返す
			SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG", "SUN"); // オブジェクト作成
			rnd.setSeed(key); // ビルキーによりシード
			byte[] mask = new byte[1];
			result = new byte[data.length];
			for (int i = 0; i < data.length; i++)
			{
				rnd.nextBytes(mask); // 乱数バイトの生成
				result[i] = (byte) (data[i] ^ mask[0]); // データと乱数バイトのXORを返す
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
