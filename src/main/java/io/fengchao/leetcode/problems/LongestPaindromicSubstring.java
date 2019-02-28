package io.fengchao.leetcode.problems;

class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    if(s == null || s.length() == 0) {
      return "";
    }
    String result = s.substring(0, 1);
    int[][] palin = new int[s.length()][s.length()];
    int len = 1;

    for(int i = 0; i < s.length(); i++) {
      palin[i][i] = 1;
    }
    for(int i = 0; i < s.length() - 1; i++){
      if(s.charAt(i) == s.charAt(i + 1)) {
        palin[i][i + 1] = 1;
        len = 2;
        result = s.substring(i, i + 1 + 1);
      }
    }

    for(int i = 2; i < s.length(); i++) {
      for(int j = 0; j < s.length(); j++) {
        if(j + i < s.length() && palin[j + 1][j + i - 1] == 1 && s.charAt(j) == s.charAt(j + i)) {
          palin[j][j + i] = 1;
          if(i + 1 > len) {
            len = i + 1;
            result = s.substring(j, j + i + 1);
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
    String result = lp.longestPalindrome("aaaa");
    System.out.println(result);
  }
}
