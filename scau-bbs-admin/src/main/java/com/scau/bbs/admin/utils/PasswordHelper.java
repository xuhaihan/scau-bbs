package com.scau.bbs.admin.utils;

import com.scau.bbs.common.entity.AdminUser;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by xhh on 2019/1/14.
 */
public class PasswordHelper {
    //private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(AdminUser user) {
        //String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getUsername()), hashIterations).toHex();
        //String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
        user.setPassword(newPassword);
    }
}
