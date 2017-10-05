package _2017.June2017.Jun20th2017

import scala.collection.mutable.ListBuffer

class _346MovingAverageFromDataStream {

  /** Initialize your data structure here. */class MovingAverage(size: Int) {

    private var Size : Int = size
    private var Windows = ListBuffer[Int]()

    def next(value : Int) : Double = {

        if(Windows.length >= Size){
           Windows.remove(0)
        }

        Windows += value

        return Windows.sum / Windows.length
    }
  }

  /*

  Java

  public class MovingAverage {
      private int [] window;
      private int n, insert;
      private long sum;

      /** Initialize your data structure here. */
      public MovingAverage(int size) {
          window = new int[size];
          insert = 0;
          sum = 0;
      }

      public double next(int val) {
          if (n < window.length)  n++;
          sum -= window[insert];
          sum += val;
          window[insert] = val;
          insert = (insert + 1) % window.length;

          return (double)sum / n;
      }
  }

   */

  /**
    * Your MovingAverage object will be instantiated and called as such:
    * var obj = new MovingAverage(size);
    * Double param_1 = obj.next(val);
    */
}
