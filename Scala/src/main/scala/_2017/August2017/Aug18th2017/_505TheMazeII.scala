package _2017.August2017.Aug18th2017
import java.util

class _505TheMazeII {

  object Solution {

    def shortestDistance(maze: Array[Array[Int]], start: Array[Int], dest: Array[Int]): Int = {
      val distance: Array[Array[Int]] = Array.ofDim[Int](maze.length, maze(0).length) //new Array[Array[Int]](maze.length, maze(0).length)
      for (row <- distance) {
        util.Arrays.fill(row, Integer.MAX_VALUE)
      }
      distance(start(0))(start(1)) = 0
      dfs(maze, start, distance)
      return if (distance(dest(0))(dest(1)) == Integer.MAX_VALUE) {
        -(1)
      }
      else {
        distance(dest(0))(dest(1))
      }
    }

    private def dfs(maze: Array[Array[Int]], start: Array[Int], distance: Array[Array[Int]]): Unit = {
      val dirs: Array[Array[Int]] = Array(Array(0, 1), Array(0, -(1)), Array(-(1), 0), Array(1, 0))
      for (dir <- dirs) {
        var x: Int = start(0) + dir(0)
        var y: Int = start(1) + dir(1)
        var count: Int = 0
        while ( {
          x >= 0 && y >= 0 && x < maze.length && y < maze(0).length && maze(x)(y) == 0
        }) {
          x += dir(0)
          y += dir(1)
          count += 1
        }
        if (distance(start(0))(start(1)) + count < distance(x - dir(0))(y - dir(1))) {
          distance(x - dir(0))(y - dir(1)) = distance(start(0))(start(1)) + count
          dfs(maze, Array[Int](x - dir(0), y - dir(1)), distance)
        }
      }
    }

  }

}