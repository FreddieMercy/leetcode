package _2017.June2017.Jun21st2017
import scala.collection.mutable.SortedSet

class _266PalindromePermutation {

  object Solution {
    def canPermutePalindrome(s: String): Boolean = {
        var set = SortedSet[Character]()
        for (i <- s){
            if(set.contains(i)){
                set -= i
            } else{
                set += i
            }
        }
        return set.size <= 1
    }
  }
}
