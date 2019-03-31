package io.fengchao.leetcode.problems;

class InterleavingString {

  public static void main(String[] args) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";

    boolean result = isInterleave(s1, s2, s3);
    System.out.println(result);
  }
  public static boolean isInterleave(String s1, String s2, String s3) {
    if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
      return false;
    }
    return helper(s1, s2, s3, 0, 0, 0);
  }

  private static boolean helper(String s1, String s2, String s3, int p1, int p2, int p3) {
    System.out.println("=== BEGIN - Node Info ===");
    System.out.println("s1 = " + s1.substring(p1));
    System.out.println("s2 = " + s2.substring(p2));
    System.out.println("s3 = " + s3.substring(p3));
    System.out.println("=== END ===");
    System.out.println();
    if(p1 == s1.length() && p2 == s2.length() && p3 == s3.length()) {
      return true;
    }
    boolean first = false;
    boolean second = false;
    if(p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
      first = helper(s1, s2, s3, p1 + 1, p2, p3 + 1);
    }
    if(p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
      second = helper(s1, s2, s3, p1, p2 + 1, p3 + 1);
    }
    return first || second;
  }
}