/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.Utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adriana
 */
@Component("utils")
public class Utils {
    
    @Autowired
    private HttpServletRequest request;
    
     public Map getHttpHeaders(){
       Map<String, String> map = new HashMap <String, String>();
       Enumeration headerNames = request.getHeaderNames();
         while (headerNames.hasMoreElements()) {
             String key = (String)headerNames.nextElement();
             String value = request.getHeader(key);
             map.put(key, value);
         }
         return map;
     }
     
     public String generateToken() throws UnsupportedEncodingException{
         
        Instant instant = Instant.now();
        String info = instant.getEpochSecond() + "";
        return UUID.randomUUID().toString() + "+" + Base64.getEncoder().encodeToString(info.getBytes("utf-8"));
                
     }
     
     public String md5 (String cad) throws NoSuchAlgorithmException{
     
       MessageDigest md = MessageDigest.getInstance("MD5");
       byte[] messageDigest = md.digest(cad.getBytes());
       BigInteger number = new BigInteger(1, messageDigest);
       String hashtext = number.toString(16);
       // Now we need to zero pad it if you actually want the full 32 chars.
       while (hashtext.length() < 32) {
           hashtext = "0" + hashtext;

       }
       return hashtext;
     }
    
}
