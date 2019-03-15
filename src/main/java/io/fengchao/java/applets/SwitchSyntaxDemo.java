package io.fengchao.java.applets;

import java.util.Scanner;

public class SwitchSyntaxDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String in = sc.nextLine();

    switch(in) {
      case "w":
        System.out.println("Wang");
        break;
      case "f":
        System.out.println("Fengchao");
        break;
      default:
          System.out.println("OK");
    }

  }
}
