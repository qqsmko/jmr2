package com.jmr.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.AccountMapper;
import com.jmr.model.Account;
import com.jmr.service.IUtilService;

@Service
public class UtilService implements IUtilService {
	@Autowired
	AccountMapper accountMapper;
	
	public String getMd5(String plainText) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  
  
            int i;  
  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            //32位加密  
            return buf.toString();  
            // 16位的加密  
            //return buf.toString().substring(8, 24);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        }  
  
    }
	
	public int checkAccount(String username,String password){
		Account temp = accountMapper.selectByPrimaryKey(username);
		if(temp == null) return 0;
		String passwdMd5 = getMd5(password);
		String passwdSQL = temp.getPassword();
		if(passwdMd5.equals(passwdSQL)){
			return temp.getAccountType();
		}
		return 0;
	}
	
	public int getAccountInstitutionsId(String username,String password){
		Account temp = accountMapper.selectByPrimaryKey(username);
		if(temp == null) return 0;
		String passwdMd5 = getMd5(password);
		String passwdSQL = temp.getPassword();
		if(passwdMd5.equals(passwdSQL)){
			return temp.getInstitutionsId();
		}
		return 0;
	}
}
