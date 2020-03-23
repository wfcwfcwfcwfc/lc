package io.fengchao.corejava;

public class CharactersPrac {
  public static void main(String[] args) {
    String str = "Hello, World!";

    for(int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      Character.isAlphabetic(c);
      Character.toLowerCase(c);
      Character.isLetter(c);
      Character.isDigit(c);
      Character.isLetterOrDigit(c);
    }


    String ipv6 = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
    String[] splitV6 = ipv6.split(":");
    System.out.println(splitV6.length);

  }

}
