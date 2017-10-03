//
//  _252MeetingRooms.swift
//  leetcode
//
//  Created by Junhao Zhang on 10/3/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _252MeetingRooms{
    
     // Definition for an interval.
     public class Interval {
        public var start: Int
        public var end: Int
        public init(_ start: Int, _ end: Int) {
          self.start = start
          self.end = end
        }
      }
    
    class Solution {
        private func sortAcs(this:Interval, that:Interval) -> Bool {
            return this.start < that.start || this.start == that.start && this.end < that.end
        }
        
        func canAttendMeetings(_ intervals: [Interval]) -> Bool {
            if intervals.count > 1{
                let tmp = intervals.sorted(by: sortAcs)
                for i in 1...tmp.count-1{
                    if tmp[i].start < tmp[i-1].end{
                        return false
                    }
                }
            }
            return true
        }
    }
}
