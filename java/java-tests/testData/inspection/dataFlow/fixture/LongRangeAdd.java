import java.util.*;

public class LongRangeAdd {
  void test(int x, int y) {
    if (x > 0 && x < 10) {
      if (<warning descr="Condition 'y > x + 10 && y < 0' is always 'false'">y > x + 10 &&
           <warning descr="Condition 'y < 0' is always 'false' when reached">y < 0</warning></warning>){
        System.out.println("Impossible");
      }
    }
  }

  void testLoop() {
    for (int i = 0; i < 10; i = i + 1) {
      if (<warning descr="Condition 'i + 1 == 15' is always 'false'">i + 1 == 15</warning>) {
        System.out.println("Impossible");
      }
      if (<warning descr="Condition 'i + 1 == -10' is always 'false'">i + 1 == -10</warning>) {
        System.out.println("Impossible");
      }
      System.out.println(i);
    }
  }

  void testNestedLoop() {
    for (int i = 0; i < 10; i = i + 1) {
      for (int j = 0; j < 10; j = j + 1) {
        if (i + j == 0) {
          if (<warning descr="Condition 'i != 0' is always 'false'">i != 0</warning>) {
            System.out.println("never");
          }
          if (<warning descr="Condition 'j != 0' is always 'false'">j != 0</warning>) {
            System.out.println("never");
          }
        }
        if (<warning descr="Condition 'i + j == 20' is always 'false'">i + j == 20</warning>) {
          System.out.println("never");
        }
      }
    }
  }
}
