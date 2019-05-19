package br.com.anvy.security;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class TokenGenerate {

	private String login;
	private String token;
	private Date logonDate;
	private Date expirationDate;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public TokenGenerate() {
		this.logonDate = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(logonDate);
		calendar.add(Calendar.HOUR_OF_DAY, 4);

		this.expirationDate = calendar.getTime();
	}
	
	public void generate() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(this.login);
		stringBuffer.append(";");
		stringBuffer.append(this.logonDate);
		stringBuffer.append(";");
		stringBuffer.append(this.expirationDate);
		stringBuffer.append(";");
		
		String preToken = stringBuffer.toString();
		
		String toEncrypt = this.login + ";" + simpleDateFormat.format(this.logonDate) + ";" + simpleDateFormat.format(this.expirationDate) + ";";

		/*
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    final SecretKeySpec secretKey = new SecretKeySpec(new String [], "AES");
	    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	    final String encryptedString = Base64.encodeBase64String(cipher.doFinal(toEncrypt.getBytes()));
		*/
		this.token = preToken;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getLogonDate() {
		return logonDate;
	}

	public void setLogonDate(Date logonDate) {
		this.logonDate = logonDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
