package io.fengchao.corejava.applets.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Streams {
  public static void main(String[] args) {
    Person person1 = new Person();
    person1.value = "Fengchao";
    Person person2 = new Person();
    person2.value = "Wang";

    List<Person> list = new ArrayList<Person>();
    list.add(person1);
    list.add(person2);
    list.stream().forEach(new Consumer<Person>() {
      @Override
      public void accept(Person person) {
        person.value = "ppp2";
      }
    });
    list.forEach(person -> {
      System.out.println(person.value);
    });
  }
}

class Person {
  public String value;
}
