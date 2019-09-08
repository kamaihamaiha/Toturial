package com.kk.download;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;

/**
 * @Author: 张开旭
 * @Date: 2018/6/25
 * @E-mail: zhangkaixu@eyecool.cn
 * @Ltd: 山东眼神智能科技有限公司(www.facekey.cn)
 * @Address: 山东省济南市高新区齐鲁软件园B座508
 * @Des: this is 数学计算的工具类
 */
public class ArithmeticUtil {




    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bytesToHexString(digest.digest());
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和bytesToInt（）配套使用
     *
     * @param value 要转换的int值
     * @return byte数组
     */
    public static byte[] intToBytes(int value) {
        byte[] src = new byte[4];
        src[3] = (byte) ((value >> 24) & 0xFF);
        src[2] = (byte) ((value >> 16) & 0xFF);
        src[1] = (byte) ((value >> 8) & 0xFF);
        src[0] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * int[] 转换为 byte[]
     *
     * @param values
     * @return
     */
    public static byte[] intsToBytes(int[] values) {
        byte[] src = new byte[4 * values.length];
        for (int i = 0; i < values.length; i++) {
            src[i + 3] = (byte) ((values[i] >> 24) & 0xFF);
            src[i + 2] = (byte) ((values[i] >> 16) & 0xFF);
            src[i + 1] = (byte) ((values[i] >> 8) & 0xFF);
            src[i + 0] = (byte) (values[i] & 0xFF);
        }
        return src;
    }

    /**
     * 计算 2 个数的比
     *
     * @param numberA
     * @param numberB
     * @return
     */
    public static int[] computeRadio(int numberA, int numberB) {
        int[] resultNums = new int[2];
        int greatestCommonDivisor = computeGreatestCommonDivisor(numberA, numberB);
        if (greatestCommonDivisor != 0) {
            resultNums[0] = numberA / greatestCommonDivisor;
            resultNums[1] = numberB / greatestCommonDivisor;
        }
        return resultNums;
    }

    /**
     * 计算 2 个数的最大公约数
     *
     * @param numberA
     * @param numberB
     * @return 如果返回0, 就是传入的数不正确
     */
    private static int computeGreatestCommonDivisor(int numberA, int numberB) {
        if (numberA == 0 || numberB == 0) {
            return 0;
        }
        int min;
        if (numberA < numberB) {
            min = numberA;
        } else {
            min = numberB;
        }
        //遍历 min,找公约数，最后满足条件的就是最大公约数[要遍历完]
        int maxDivisor = 1;
        for (int i = 1; i <= min; i++) {
            if (numberA % i == 0) {
                if (numberB % i == 0) {
                    //找到了一个公约数
                    maxDivisor = i;
                }
            }
        }
        return maxDivisor;
    }


    /**
     * 获取 2 个数的比
     *
     * @param valueA           除数
     * @param valueB           被除数
     * @param significantDigit 保留有效数字位数
     * @return 返回 double 类型的数字
     */
    public static double getRatio(long valueA, long valueB, int significantDigit) {
        if (valueB == 0) {
            return 0.00;
        }
        double radioD = (double) valueA / valueB;
        BigDecimal bg = new BigDecimal(radioD);
        double radioResult = bg.setScale(significantDigit, BigDecimal.ROUND_HALF_UP).doubleValue();
        return radioResult;
    }

    public static String bytes2HexString(byte[] b) {
        String r = "";

        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r += hex.toUpperCase();
        }

        return r;
    }


    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
