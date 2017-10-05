package _2017.June2017.Jun22nd2017
import scala.collection.mutable.ListBuffer

class _293FlipGame {
  object Solution {
    def generatePossibleNextMoves(s: String): List[String] = {
      var ans = ListBuffer[String]()

      for(i <- 1 to s.length-1){
        if(s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
          ans += s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length())
        }
      }

      return ans.toList
    }
  }
}

