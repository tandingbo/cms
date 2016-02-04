package com.tanbobo.cms.base.utils.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * 文件加密
 */
public class FileEncryptionUtil {
    /**
     * 将文件转成base64 字符串
     *
     * @param file
     * @throws Exception
     */
    public static String encodeBase64File(File file) throws Exception {
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * 将base64字符解码保存文件
     *
     * @param base64Code
     * @param os
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code, OutputStream os) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        os.write(buffer);
        os.close();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encodeBase64File(new File("C:\\Users\\Administrator\\Desktop\\垃圾桶\\个人真实性核验单.png")));
    }
}
