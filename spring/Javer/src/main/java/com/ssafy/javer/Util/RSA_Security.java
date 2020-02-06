package com.ssafy.javer.Util;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSA_Security {
	private Key publicKey;
	private Key privateKey;

	/**
	 * 개인키로 복호화 한다.
	 * @param txt
	 * @return
	 * @throws Exception
	 */

	public String decode(String txt) throws Exception {
		Cipher c = Cipher.getInstance("RSA");
		c.init(Cipher.DECRYPT_MODE, privateKey);
		return new String(c.doFinal(Base64.getDecoder().decode((txt.getBytes("UTF-8")))));
	}

	/**
	 * 공개키로 암호화 한다.
	 * @param txt
	 * @return
	 * @throws Exception
	 */

	public String encode(String txt) throws Exception {
		Cipher c = Cipher.getInstance("RSA");
		c.init(Cipher.ENCRYPT_MODE, publicKey);
		return new String(Base64.getEncoder().encode((c.doFinal(txt.getBytes("UTF-8")))));
	}

	/**
	 * 공개키, 개인키 한쌍을 생성한다.
	 * @throws Exception
	 */
	public void generatorKey() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		publicKey = keyPair.getPublic();
		privateKey = keyPair.getPrivate();
	}

	/**
	 * 공개키 문자열을 가져온다.
	 * @return
	 * @throws Exception
	 */

	public String getPublicKeySpecStr() throws Exception {
		RSAPublicKeySpec publicKeySpec	= KeyFactory.getInstance("RSA").getKeySpec(publicKey, RSAPublicKeySpec.class);
		return publicKeySpec.getModulus() + "/" + publicKeySpec.getPublicExponent();
	}
	
	/**
	 * 공개키 문자열로 공개키를 생성한다.
	 * @param specStr
	 * @throws Exception
	 */
	public void setPublicKeySpecStr(String specStr) throws Exception {
		String[] specArr	= specStr.split("/");
		setPublicKeySpecStr(specArr[0], specArr[1]);
	}

	/**
	 * 공개키 문자열로 공개키를 생성한다.
	 * @param modulus
	 * @param exponent
	 * @throws Exception
	 */

	public void setPublicKeySpecStr(String modulus, String exponent) throws Exception {
		RSAPublicKeySpec publicKeySpec	= new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(exponent));
		publicKey	= KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);
	}

	/**
	 * 개인키 문자열을 가져온다.
	 * @return
	 * @throws Exception
	 */
	public String getPrivatekeySpecStr() throws Exception {
		RSAPrivateKeySpec privateKeySpec	= KeyFactory.getInstance("RSA").getKeySpec(privateKey, RSAPrivateKeySpec.class);
		return privateKeySpec.getModulus() + "/" + privateKeySpec.getPrivateExponent();
	}

	/**
	 * 개인키 문자열로 개인키를 생성한다.
	 * @param specStr
	 * @throws Exception
	 */

	public void setPrivateKeySpecStr(String specStr) throws Exception {
		String[] specArr	= specStr.split("/");
		setPrivateKeySpecStr(specArr[0], specArr[1]);
	}

	/**
	 * 개인키 문자열로 개인키를 생성한다.
	 * @param modulus
	 * @param exponent
	 * @throws Exception
	 */

	public void setPrivateKeySpecStr(String modulus, String exponent) throws Exception {
		RSAPrivateKeySpec privateKeySpec	= new RSAPrivateKeySpec(new BigInteger(modulus), new BigInteger(exponent));
		privateKey	= KeyFactory.getInstance("RSA").generatePrivate(privateKeySpec);
	}

	public static void main(String[] args) throws Exception {
		// 서버단 키 생성
		RSA_Security serverRSA	= new RSA_Security();
		serverRSA.generatorKey();
		String publicKeySpec	= serverRSA.getPublicKeySpecStr();
		String privateKeySpec	= serverRSA.getPrivatekeySpecStr();

		// 클라이언트단 공통키로 암호화
		RSA_Security clientRSA	= new RSA_Security();
		String originalTxt	= "이 문자열을 보냅니다.";
		clientRSA.setPublicKeySpecStr(publicKeySpec);
		String encodeTxt	= clientRSA.encode(originalTxt);

		// 이미 생성된 서버 자원 사용
		String decodeTxt	= serverRSA.decode(encodeTxt);

		// 서버에서 새 자원 생성해서 개인키로 복호화
		RSA_Security serverRSARe	= new RSA_Security();
		serverRSARe.setPrivateKeySpecStr(privateKeySpec);
		String decodeTxtRe	= serverRSARe.decode(encodeTxt);

		System.out.println("publicKeySpec : " + publicKeySpec);
		System.out.println("privateKeySpec : " + privateKeySpec);
		System.out.println("originalTxt : " + originalTxt);
		System.out.println("encodeTxt : " + encodeTxt);
		System.out.println("decodeTxt : " + decodeTxt);
		System.out.println("decodeTxtRe : " + decodeTxtRe);
	}
}
