package io.fengchao.corejava;

public class JavaStringDemo {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abcde";
        System.out.println(str1 == str2);

        String str3 = new String("abcde");
        System.out.println(str1 == str3);

        str3.intern();
        System.out.println(str1 == str3);

    }
}
