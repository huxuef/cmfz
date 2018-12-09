package com.baizhi.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class TestMD5 {

    @Test
    public void testMd5(){
        Md5Hash md5Hash = new Md5Hash("0000123456"); // salt=dsaz 明文密码=123456
        System.out.println(md5Hash);
    }
}
