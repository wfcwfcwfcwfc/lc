package io.fengchao.leetcode.problems;

class CompressString {
  public int compress(char[] chars) {
    if(chars == null || chars.length == 0) {
      return 0;
    }
    int slow = 0;
    int fast = 0;
    int count = 0;
    while(fast < chars.length) {
      int pos = fast;
      while(fast < chars.length && chars[pos] == chars[fast]) {
        fast++;
        count++;
      }
      chars[slow] = chars[pos];
      if(count == 1) {
        slow++;
      } else {
        slow++;
        for(char digit : (count + "").toCharArray()) {
          chars[slow] = digit;
          slow++;
        }
      }
      count = 0;

    }
    return slow;
  }

  public static void main(String[] args) {
    CompressString cs = new CompressString();
    String str = "abc";
    int result = cs.compress(str.toCharArray());
    System.out.println(result);
  }
}
