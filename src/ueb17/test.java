package ueb17;

import java.util.*;

import java.util.function.BiFunction;
public class test {
/* w  w  w  . j ava 2s . c om*/
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    String result = calculator.calc((a, b) -> ": " + (a * b),3,  5);

    System.out.println(result);

  }
}

class Calculator {
  public String calc(BiFunction<Integer, Integer, String> bi, Integer i1, Integer i2) {
      return bi.apply(i1, i2);
  }
}
