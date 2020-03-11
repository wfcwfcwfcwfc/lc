package io.fengchao.leetcode.problems;

public class ValidateUTF8 {
  public static void main(String[] args) {
    ValidateUTF8 validateUTF8 = new ValidateUTF8();
    int[] input = {240,162,138,147};
    boolean result = validateUTF8.validUtf8(input);
    System.out.println(result);

  }

  public boolean validUtf8(int[] data) {
    if(data == null || data.length == 0) {
      return false;
    }

    int pos = 0;
    while(pos < data.length) {
      if(data[pos] >> 7 == 0b0) {
        pos++;
      } else if (data[pos] >> 5 == 0b110 && check(data, pos, 1)) {
        pos+= 2;
      } else if (data[pos] >> 4 ==  0b1110 && check(data, pos, 2)) {
        pos+= 3;
      } else if (data[pos] >> 3 == 0b11110 && check(data, pos, 3)) {
        pos+= 4;
      } else {
        return false;
      }
    }

    return true;
  }

  private boolean check(int[] data, int pos, int len) {
    for(int i = 1; i <= len; i++) {
      if(pos + i >= data.length) {
        return false;
      }
      if(data[pos + i] >> 6 != 0b10) {
        return false;
      }
    }
    return true;
  }
}