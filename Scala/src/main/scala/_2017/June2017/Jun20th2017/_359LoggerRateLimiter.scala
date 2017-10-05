package _2017.June2017.Jun20th2017

class _359LoggerRateLimiter {

  /** Initialize your data structure here. */class Logger() {

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */



    private var timer:Map[String, Int] = Map[String, Int]()
    def shouldPrintMessage(timestamp:Int, message:String) : Boolean = {
      if(!timer.keySet.exists(_ == message) || timestamp - 10 >= timer.get(message).get){
        timer =  timer + (message -> timestamp) // immutable
        //timer(message) = timestamp or timer.put(message, timestamp) for scala.collection.mutable.Map
        return true
      }
      return false

    }
  }

  /**
    * Your Logger object will be instantiated and called as such:
    * var obj = new Logger();
    * Boolean param_1 = obj.shouldPrintMessage(timestamp,message);
    */

  /*
      I gave up on Scala b/c it is so slow and so buggy
      Java code:

       public class Logger {
          HashMap<String,Integer> map;

          public Logger() {
              map=new HashMap<>();
          }

          public boolean shouldPrintMessage(int timestamp, String message) {

              if(!map.containsKey(message)||timestamp-map.get(message)>=10){
                  map.put(message,timestamp);
                  return true;
              }
              return false;
          }
       }

   */
}
