package io.eeaters.delivery.shunfeng;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

class SignGenerate {


    public static String generateSign(String postData, String appId, String appKey) {
        StringBuilder sb =  new StringBuilder();
        sb.append(postData);
        sb.append("&" + appId + "&" + appKey);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(sb.toString().getBytes("utf-8"));
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < md5.length; offset++) {
                i = md5[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return Base64.encodeBase64String(buf.toString().getBytes("utf-8"));
        } catch (Exception exception) {
            //todo
            throw null;
        }
    }
}
