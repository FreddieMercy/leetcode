package _2017.June2017.Jun21st2017

class _276PaintFence {
  object Solution {
    def numWays(n: Int, k: Int): Int = {
      if(n == 0){
        return 0
      }
      if(n == 1){
        return k
      }
      if(n == 2){
        return k*k
      }
      var diffColorCounts = k*(k-1)
      var sameColorCounts = k
      for(i<-2 to n-1) {
        var temp = diffColorCounts
        diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1)
        sameColorCounts = temp
      }
      return diffColorCounts + sameColorCounts
    }
  }
}
