package _2017.June2017.Jun20th2017

class _624MaximumDistanceInArrays {
  object Solution {
    def maxDistance(arrays: List[List[Int]]): Int = {
      var res = 0
      var min_val = arrays(0)(0)
      var max_val = arrays(0)(arrays(0).length - 1)

      for(i<- 1 to arrays.length-1) {
        res = Math.max(res, Math.max(Math.abs(arrays(i)(arrays(i).length - 1) - min_val), Math.abs(max_val - arrays(i)(0))))
        min_val = Math.min(min_val, arrays(i)(0))
        max_val = Math.max(max_val, arrays(i)(arrays(i).length - 1))
      }
      return res
    }
  }

  /*

  Java code:

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0, min_val = arrays.get(0).get(0), max_val = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(res, Math.max(Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min_val), Math.abs(max_val - arrays.get(i).get(0))));
            min_val = Math.min(min_val, arrays.get(i).get(0));
            max_val = Math.max(max_val, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return res;
    }
}

   */
}
