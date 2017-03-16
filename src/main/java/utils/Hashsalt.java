package utils;

import entity.User;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Properties;
import java.util.UUID;

public class Hashsalt {
    private static Properties properties;
    public boolean equals(String password,User user) {
        String encryptPassword = encrypt(password + user.getSalt()); //(3-B)
        if (encryptPassword.compareTo(user.getUserPassword()) == 0) { // (3-C)
            return true;
        }

        return false;
    }

    public  User saveTo(String password) {
        UUID uuid = UUID.randomUUID();
        String salt = uuid.toString().replace("-", "");
        String hashPassword = encrypt(password + salt);
        User u=new User();
        u.setSalt(salt);
        u.setUserPassword(hashPassword);
        return u;
    }

    public String encrypt(String password) {
        String algorithm = EnvUtils.getProperty("algorithm");
        String keyString = EnvUtils.getProperty("stevenKey3");
        SecretKey key = new SecretKeySpec(keyString.getBytes(), algorithm);

        try {
            Mac m = Mac.getInstance(algorithm);
            m.init(key);
            m.update(password.getBytes());
            byte[] mac = m.doFinal();
            return toHexString(mac);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        return StringUtils.EMPTY;
    }

    //(4)
    private String toHexString(byte[] in) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < in.length; i++){
            int temp=0xFF & in[i];
            String hex = Integer.toHexString(temp);
            if (hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
