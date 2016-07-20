package com.kaka;

import edu.princeton.cs.algs4.StdOut;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/6/28.
 */
public class main {
    public static void main(String[] args) {
//        ResizingArrayStack<String> stack=new ResizingArrayStack<String>();
//        stack.push("露露宝宝");
//        stack.push("爱");
//        stack.push("我");
//        for(String item : stack){
//            StdOut.println(item);
//        }

//        LinkedStack<String> stack = new LinkedStack<String>();
//        stack.push("露露宝宝");
//        stack.push("爱");
//        stack.push("我");
//        for (String item : stack) {
//            StdOut.println(item);
//        }
    }

    private static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            String tmp=buf.toString().substring(8, 24);
            byte[] bytes=tmp.getBytes();
            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));



        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}
