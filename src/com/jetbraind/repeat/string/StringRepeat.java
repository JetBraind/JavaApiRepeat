package com.jetbraind.repeat.string;

import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

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
         * 忽略大小写比较大小
         */
        count = str.compareToIgnoreCase("5D25");
        System.out.println(count);

        /**
         * 判断在指定范围内，两个字符串是否相等
         * 第一个参数是元字符串的偏移量，偏移3位，指向的是4
         * 第二个参数是目标字符串
         * 第三个参数是目标字符串的偏移量
         * 第四个参数是比较的长度
         */
        str = "123456789";
        boolean flag = str.regionMatches(3, "456", 0, 3);
        System.out.println(flag);

        /**
         * 和上一个方法用法一样，只不过加了第一个参数是判断是否忽略大小写的判断
         * 如果第一个参数是true，则忽略大小写
         */
        str = "abcdefg";
        flag = str.regionMatches(true, 3, "DEF", 0, 3);
        System.out.println(flag);

        /**
         * 判断字符串从是否以指定的字符开始,
         * 第一个参数需要判断的字符，
         * 第二个参数是偏移量
         */
        flag = str.startsWith("ab", 0);
        System.out.println(flag);

        /**
         * 判断字符串从是否以指定的字符开始,
         * 第一个参数需要判断的字符，偏移量为0的情况
         */
        flag = str.startsWith("ab");
        System.out.println(flag);

        /**
         * 判断是否以指定的字符串结尾
         */
        flag = str.endsWith("fg");
        System.out.println(flag);

        /**
         * 字符串的hash值
         */
        code = str.hashCode();
        System.out.println(code);

        /**
         * 判断字符串参数是否包含在源字符串中，并返回和源字符串第一个字符的偏移量
         * 不存在则会返回-1
         */
        int a = str.indexOf("df");
        System.out.println(a);
        /**
         * 和上一个方法一样，只不过传入的是字符串的Unicode值，会把当前数值转换为一个字节来比较
         */
        a = str.indexOf(98);
        System.out.println(a);

        /**
         *从指定位置开始判断，传入的数值是否存在，返回第一次出现位置和字符串整体相比的偏移量
         * 第二个参数表示从哪一个位置开始判断
         */
        a = str.indexOf(98, 1);
        System.out.println(a);

        /**
         * 判断指定字符串是否存在，返回最后一次出现在字符串中的位置
         */
        str = "123456789";
        int position = str.lastIndexOf("9");
        System.out.println(position);

        /**
         * 从第二个参数开始，从右向左第一个参数最后一次出现的位置
         */
        String data = "2365683";
        position = data.lastIndexOf("6", 5);
        System.out.println(position);

        /**
         * 从指定位置开始截取字符串
         */
        str = "123456789";
        String subStr = str.substring(2);
        System.out.println(subStr);

        /**
         * 从开始位置截取到结束位置
         */
        str = "21358334";
        subStr = str.substring(1, 3);
        System.out.println(subStr);

        /**
         * 从Charsequence中截取指定长度的字符串
         */
        CharSequence charSequence = "123456789";
        charSequence = charSequence.subSequence(1, 4);
        System.out.println(charSequence);

        /**
         * 拼接字符串
         */
        str = "123";
        s = "456";
        String concat = str.concat(s);
        System.out.println(concat);

        /**
         * 替换指定的字符
         */
        str = "2233445566";
        str = str.replace('4', '3');
        System.out.println(str);

        /**
         * 使用正则表达式判断是否匹配
         */
        str = "0123456";
        flag = str.matches("[0-9]*");
        System.out.println(flag);

        /**
         * 是否包含指定的字符串
         */
        str = "123456";
        flag = str.contains("23");
        System.out.println(flag);

        /**
         * 这个传递的是一个可变字符串参数，在每一个参数后面加上传递的第一个字符串
         */
        str = String.join("123", "456", "789", "000");
        System.out.println(str);

        /**
         * 转大写
         */
        str = "abc";
        str = str.toUpperCase();
        System.out.println(str);

        /**
         * 转小写
         */
        str = "ABC";
        str = str.toLowerCase();
        System.out.println(str);

        /**
         * 去掉前后空格
         */
        str = "  123 456 ";
        str = str.trim();
        System.out.print(str);
        System.out.print(str);
        System.out.println();
        /**
         * 转换成字符数组
         */
        str = "123456";
        ch = str.toCharArray();

        String sf = String.format("123???", "1", "2", "3");
        System.out.println(sf);
        /**
         * 把数字转换成字符串
         */
        int i = 132456;
        str = String.valueOf(i);
        System.out.println(str);
    }

}
