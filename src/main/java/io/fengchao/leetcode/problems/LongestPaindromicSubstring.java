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


  public String longestPalindromen3(String s) {
    int L = s.length();

    for(int length = s.length(); length > 0; length--) {
      for(int start = 0; start + length <= s.length(); start++) {
        System.out.print(s.substring(start, start + length));
        if(isPalindrome(s, start, start + length - 1)) {
          return s.substring(start, start + length);
        }
      }
    }

    return "";


  }

  private boolean isPalindrome(String str, int start, int end) {
    if(str == null ) {
      return false;
    }
    if(str.length() == 0) {
      return true;
    }

    while(start < end) {
      if(str.charAt(start) == str.charAt(end)) {
        start++;
        end--;
      }
    }

    return start >= end;
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
    String result = lp.longestPalindromen3("babad");
    System.out.println(result);
  }
}
