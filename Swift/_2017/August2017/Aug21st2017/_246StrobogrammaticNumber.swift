//
//  _246StrobogrammaticNumber.swift
//  leetcode
//
//  Created by Junhao Zhang on 10/3/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _246StrobogrammaticNumber{
    class Solution {
        func isStrobogrammatic(_ num: String) -> Bool {
            //let table = ["0","1","6","9","8"]
            let dicti = ["0":"0","1":"1","6":"9","9":"6","8":"8"]
            /*
            for i in num.characters{
                if !table.contains(String(i)){
                    return false
                }
            }*/
            
            for i in 0...num.characters.count/2{
                if String(num[num.index(num.startIndex, offsetBy: i)]) != dicti[String(num[num.index(num.startIndex,offsetBy: num.characters.count-1-i)])]{
                    return false
                }
            }
            
            return true
        }
    }
}
