package com.voidmainworld.plutus.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class AuthUtil {

	private static final byte[]	SALT				= ("puu-s!#%&(puu-s").getBytes();
	private final static int	ITERATION_NUMBER	= 16;
	private final static String	DIGEST_ALGORITHM	= "SHA-1";
	private final static String	ENCODING_TYPE		= "UTF-8";

	public static String digest(String password) {
		return byteToBase64(getHash(password));
	}

	private static byte[] getHash(String password) {
		MessageDigest digest = null;
		password = SALT + password + SALT;
		try {
			digest = MessageDigest.getInstance(DIGEST_ALGORITHM);
			digest.reset();
			digest.update(SALT);
			byte[] input = digest.digest(password.getBytes(ENCODING_TYPE));
			for (int i = 0; i < ITERATION_NUMBER; i++) {
				digest.reset();
				digest.update(SALT);
				input = digest.digest(input);
			}
			return input;
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String byteToBase64(byte[] data) {
		return Base64.encodeBase64String(data);
	}
}
