package 工具;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *	 
 * @Title:MD5Util
 * @Description: MD5加密工具
 * @author sky
 */
public class MD5Util {

	public static String getMD5(String str) {
		try {
			//生成一个MD5加密计算摘要
			MessageDigest digest = MessageDigest.getInstance("MD5");
			//计算MD5函数
			digest.update(str.getBytes());
			//digest()最后确定返回MD5 hash值，返回值为8位字符串。因为MD5 hash值是16位hex值，实际上就是8位字符
			//BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			String md5 = new BigInteger(1,digest.digest()).toString(16);
			//BigInteger会把0省略掉，需补全至32位
			return fillMD5(md5);
		} catch (Exception e) {
			throw new RuntimeException("MD5加密错误" + e.getMessage(),e);
		}
	}
	
	public static String fillMD5(String str) {
		return str.length() == 32 ? str : fillMD5("0" + str);
	}
	
	/**
	 * 加密解密算法，执行一次加密，两次解密
	 * @method: covertMD5 
	 * @param str
	 * @return 
	 * @return String
	 */
	public static String covertMD5(String str) {
		char[] a = str.toCharArray();
		for (int i = 0;i < a.length;i++) {
			a[i] = (char)(a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}
	
	public static void main(String[] args) {
		String s = "123";
		s = MD5Util.getMD5(s);
		System.out.println(s);
	}
	
	
}
