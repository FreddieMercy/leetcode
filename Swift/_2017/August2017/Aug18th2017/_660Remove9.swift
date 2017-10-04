//
//  _660Remove9.swift
//  leetcode
//
//  Created by Junhao Zhang on 10/3/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _660Remove9{
    class Solution {
        func newInteger(_ n: Int) -> Int {
            return Int(String(n, radix:9))!
        }
    }
}
