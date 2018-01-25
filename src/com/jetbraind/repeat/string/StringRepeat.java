package com.jetbraind.repeat.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * String是在java.lang包下的一个类，被final关键字修饰，即不可以被继承，
 * 实现了Serializable、Comparable、CharSequence接口,可以序列化和反序列化，进行比较
 */
public class StringRepeat {
    public static void main(String[] args) {
        /**
         * 创建一个新的String对象，代表了和参数有相同的字符序列
         */

        String s = "123456";
        String str = new String(s);
        System.out.println(str);
        /**
         *分配一个新的字符串，代表了在当前数组中包含的字符序列，包含的是对当前数组的复制，
         * 随后字符数组的修改不会影响新创建的字符序列
         */
        char[] ch = new char[]{'1', '2', '3', '4'};
        str = new String(ch);
        System.out.println(str);

        /**
         * 从字符数组的子数组中分配一个字符串对象，第二个参数是偏移量，第三个参数是截取数量，
         * 数量超出范围，会报IndexOutOfBoundsException异常
         */
        str = new String(ch, 1, 2);
        System.out.println(str);

        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        str = new String(ints, 0, ints.length);

        /**
         * 将字符数组转换成字符串，并指定字符编码
         */
        byte[] bytes = s.getBytes();
        try {
            str = new String(bytes, 0, bytes.length, "UTF-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /**
         * 将字符数组转换成字符串，并指定字符集
         */
        str = new String(bytes, 0, bytes.length, Charset.defaultCharset());
        System.out.println(str);

        try {
            str = new String(bytes, "UTF-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        str = new String(bytes, Charset.defaultCharset());
        System.out.println(str);

        str = new String(bytes, 0, bytes.length);
        System.out.println(str);

        str = new String(bytes);
        System.out.println(str);

        /**
         * 将指定的StringBuffer中的所有字符拷贝并分配给一个新创建的字符串对象，
         * 后续对StringBuffer的任何修改不会影响当前字符串对象
         */
        StringBuffer buffer = new StringBuffer("123456789");
        str = new String(buffer);
        System.out.println(str);

        StringBuilder builder = new StringBuilder("163456");
        str = new String(builder);
        System.out.println(str);

        /**
         * 返回字符串的长度
         */
        int len = str.length();
        System.out.println(len);

        /**
         * 仅当前字符串的长度为0时返回true
         */
        boolean isEmpty = str.isEmpty();
        System.out.println(isEmpty);

        /**
         * 返回指定索引上的字符,不能越界
         */
        char c = str.charAt(0);
        System.out.println(c);

        /**
         * 返回指定索引上的字符的Unicode编码
         */
        int code = str.codePointAt(0);
        System.out.println(code);
        /**
         * 返回指定索引前一个位置上的字符的Unicode编码
         */
        code = str.codePointBefore(1);
        System.out.println(code);

        /**
         * 返回指定范围的字符的Unicode字符的个数
         */
        code = str.codePointCount(0, 6);
        System.out.println(code);
        /**
         * 将一个字符串中部分添加到另一个字符数组中去
         * 第一个参数是源字符串组初始位置
         *  第二个参数是源字符串结束位置
         *  第三个参数是目标字符数组
         *  第四个参数是目标字符数组的指定位置
         */
        char[] chars = new char[5];
        chars[0] = '1';
        chars[1] = '1';
        chars[2] = '1';
        str.getChars(1, 3, chars, chars.length - 2);
        System.out.println(new String(chars));

        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        bytes = str.getBytes(Charset.defaultCharset());
        bytes = str.getBytes();

        /**
         * 仅仅当参数是一个字符串对象，并且和目标字符串有着相同的序列时返回true
         */
        boolean isEquals = str.equals(str);

        /**
         * 和指定的StringBuffer拥有相同的内容
         */
        str.contentEquals(buffer);
        /**
         * 这里的StringBuilder指的是一个CharSequence对象，CharSequence是字符串的老祖宗
         */
        str.contentEquals(builder);

        /**
         * 忽略大小写之后是否会相等
         */
        str.equalsIgnoreCase(str);

        /**
         * 比较两个字符串的大小，如果两个字符串在每一个索引上的字符都相等，返回两个字符串的长度差，
         * 否则返回第一个不同位置上的字符的Unicode编码的差值，可为负数
         */
        int count = str.compareTo("235");
        System.out.println(count);

        /**
         * 忽略大小写比较
         */
        count = str.compareToIgnoreCase("5D25");
        System.out.println(count);
    }
}
