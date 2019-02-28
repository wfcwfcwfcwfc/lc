package io.fengchao.leetcode.problems;

public class ValidPalindrome {
  /**
   * @param s: A string
   * @return: Whether the string is a valid palindrome
   */
  public boolean isPalindrome(String s) {
    // write your code here
    if(s == null) {
      return false;
    }
    if(s.length() == 0) {
      return true;
    }
    int start = 0;
    int end = s.length() - 1;

    s = s.toLowerCase();

    while(start < end) {
      while(!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))) {
        start++;
      }
      while(!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))) {
        end--;
      }
      if(start > end || s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  public static void main(String[] args) {
    ValidPalindrome vp = new ValidPalindrome();
    String str = "A man, a plan, a canal: Panama";
    boolean bl = vp.isPalindrome(str);
    System.out.println(bl);
  }
}