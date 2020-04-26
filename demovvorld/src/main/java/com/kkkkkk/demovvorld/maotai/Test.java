package com.kkkkkk.demovvorld.maotai;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.security.SecureRandom;

public class Test {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager m = new ScriptEngineManager();
        //获取JavaScript执行引擎
        ScriptEngine engine = m.getEngineByName("JavaScript");
        //执行JavaScript代码
        engine.eval("function encryptByDES(key,message) {//传入加密的内容\n" +
                "\t   //把私钥转换成16进制的字符串\n" +
                "\t   var keyHex = CryptoJS.enc.Utf8.parse(key);\n" +
                "\t   //模式为ECB padding为Pkcs7\n" +
                "\t   var encrypted = CryptoJS.DES.encrypt(message, keyHex, {\n" +
                "\t       mode: CryptoJS.mode.ECB,\n" +
                "\t       padding: CryptoJS.pad.Pkcs7\n" +
                "\t   });\n" +
                "\t   //加密出来是一个16进制的字符串\n" +
                "\t   return encrypted.ciphertext.toString();\n" +
                "\t}" +
                " print('我爱你中国！' + encryptByDES(\"07:00-19:000\",\"07:00-19:000\"));");
    }
}
