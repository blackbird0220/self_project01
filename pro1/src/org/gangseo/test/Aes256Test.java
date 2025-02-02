package org.gangseo.test;


import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.crypto.util.AES256;


public class Aes256Test {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
		String pwd = "4321";
		String key = "%02x";
		String res1 = AES256.encryptAES256(pwd, key);
		String res2 = AES256.decryptAES256(res1, key);
		System.out.println("원래 비밀번호 : "+pwd);
		System.out.println("AES256 암호화된 비밀번호 : "+res1);
		System.out.println("AES256 복호화된 비밀번호 : "+res2);
	}
}