package io.fengchao.corejava;

import java.util.HashMap;
import java.util.Map;

public class MathDemo {
  public static void main(String[] args) {
    int fmod = Math.floorMod(-3, 8);
    System.out.println(fmod);

    Map<Character, Integer> pmap = new HashMap<>();
    Map<Character, Integer> smap = new HashMap<>();

    pmap.put('a', 1);
    pmap.put('b', 2);
    pmap.put('c', 3);

    pmap.equals(smap);
    smap.put('a', 1);
    pmap.equals(smap);
    smap.put('b', 2);
    smap.put('c', 3);
    pmap.equals(smap);
  }
}
