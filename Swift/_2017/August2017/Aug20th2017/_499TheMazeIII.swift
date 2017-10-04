//
//  _499TheMazeIII.swift
//  leetcode
//
//  Created by Junhao Zhang on 10/3/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _499TheMazeIII{
    class Solution {
        private func roll (_ maze :inout [[Int]], _ row : Int, _ col : Int, _ hole : [Int], _ d_row : Int, _ d_col : Int, _ s : Int, _ path : String, _ res : inout (String, Int)) ->String{
            
            var rowBall = row
            var colBall = col
            var steps = s
            
            if steps < res.1{
                if d_row != 0 || d_col != 0{
                    while (rowBall + d_row) >= 0 && (colBall + d_col) >= 0 && (rowBall + d_row) <  maze.count
                        && (colBall + d_col) < maze[0].count && maze[rowBall + d_row][colBall + d_col] != 1 {
                            rowBall += d_row
                            colBall += d_col
                            steps += 1
                            if rowBall == hole[0] && colBall == hole[1] && steps < res.1{
                                res = (path, steps)
                            }
                    }
                }
                
                if maze[rowBall][colBall] == 0 || steps + 2 < maze[rowBall][colBall] {
                    maze[rowBall][colBall] = steps + 2 // '1' is for the walls.
                    if d_row == 0 {
                        roll(&maze, rowBall, colBall, hole, 1, 0, steps, path + "d", &res)
                    }
                    if d_col == 0 {
                        roll(&maze, rowBall, colBall, hole, 0, -1, steps, path + "l", &res)
                    }
                    if d_col == 0 {
                        roll(&maze, rowBall, colBall, hole, 0, 1, steps, path + "r", &res)
                    }
                    if d_row == 0 {
                      roll(&maze, rowBall, colBall, hole, -1, 0, steps, path + "u", &res)
                    }
                }
            }
            
            return res.0;
        }
  
        func findShortestWay(_ maze: [[Int]], _ ball: [Int], _ hole: [Int]) -> String {
            var tmp = maze
            var pair = ("impossible", Int(UInt8.max))
            return roll(&tmp, ball[0], ball[1], hole, 0, 0, 0, "", &pair)
        }
    }
}
