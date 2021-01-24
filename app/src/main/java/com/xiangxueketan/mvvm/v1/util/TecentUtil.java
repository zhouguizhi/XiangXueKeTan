package com.xiangxueketan.mvvm.v1.util;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:47
 * @Version: 1.0
 */
public class TecentUtil {
    public static final String secretId = "AKIDiMsQ3qToz1ExN61KEwhxx547XuF823Xn7dy4";
    public static final String secretKey = "l35tas0wiN7bzXuZuzJ0afEu5q8a1j7LL7j31jn4";
    private static final String CONTENT_CHARSET = "UTF-8";
    private static final String HMAC_ALGORITHM = "HmacSHA1";
    private TecentUtil(){
    }

    private static String sign(String secret, String timeStr) {
        //get signStr
        String signStr = "date: " + timeStr + "\n" + "source: " + "source";
        //get sig
        try {
            Mac mac1  = Mac.getInstance(HMAC_ALGORITHM);

            byte[] hash;
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(CONTENT_CHARSET), mac1.getAlgorithm());
            mac1.init(secretKey);
            hash = mac1.doFinal(signStr.getBytes(CONTENT_CHARSET));
            String sig = new String(Base64.encode(hash));
            System.out.println("signValue--->" + sig);
            return sig;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAuthorization(String timeStr){
        String sig = sign(secretKey, timeStr);
        return  "hmac id=\"" + secretId + "\", algorithm=\"hmac-sha1\", headers=\"date source\", signature=\"" + sig + "\"";
    }

    public static String getTimeStr(){
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(cd.getTime());
    }
}
