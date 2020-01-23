package com.learning.PageObjectsDesign;



import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Base64;

public class CalculateEnc{

    public static String encode() throws Exception {
        Long  timestamp  =  System.currentTimeMillis ();
        String key = "SEC62a844ddaef18248d50c740af647ef8c9d001094498ec0fba9fe2bd97da4d812";
        System.out.println(timestamp);
        String  stringToSign  =  timestamp + "\n" + key;
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] signData = sha256_HMAC.doFinal(stringToSign.getBytes("UTF-8"));
        return URLEncoder.encode(new String(Base64.getEncoder().encode(signData)),"UTF-8");
        //return URLEncoder.encode(new String(Base64.encode(key.getBytes())),"UTF-8");
    }

//https://oapi.dingtalk.com/robot/send?access_token=cfe236b055a85d65d870287253fb996fd0239e64dcf2a27678af704e06e82897

    //SEC62a844ddaef18248d50c740af647ef8c9d001094498ec0fba9fe2bd97da4d812

    public static void main(String[] args) throws Exception{

        //byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        //System.out.print(URLEncoder.encode(new String(Base64.encode(signData)),"UTF-8"));

        System.out.println(encode());


    }




    }
