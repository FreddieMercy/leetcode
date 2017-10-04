//
//  _490TheMaze.swift
//  leetcode
//
//  Created by Junhao Zhang on 10/3/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _490TheMaze{
    
    class Solution {
        func hasPath(_ maze: [[Int]], _ start: [Int], _ destination: [Int]) -> Bool {
            var visited : [[Bool]] = [[Bool]](repeating:[Bool](repeating:false, count: maze[0].count), count: maze.count)
            let dirs : [[Int]]=[[0, 1], [0, -1], [-1, 0], [1, 0]]
            var queue : [[Int]] = [[Int]]()
            
            queue.append(start)
            visited[start[0]][start[1]] = true
            
            while queue.count>0{
                let s = queue[0]
                queue.remove(at: 0)
                
                if s[0] == destination[0] && s[1] == destination[1]{
                    return true
                }
                
                for dir in dirs {
                    var x = s[0] + dir[0]
                    var y = s[1] + dir[1]
                    while x >= 0 && y >= 0 && x < maze.count && y < maze[0].count && maze[x][y] == 0 {
                        x += dir[0]
                        y += dir[1]
                    }
                    
                    if !visited[x - dir[0]][y - dir[1]] {
                        queue.append([x - dir[0], y - dir[1]])
                        visited[x - dir[0]][y - dir[1]] = true
                    }
                }
            }
            return false
        }
    }
}
