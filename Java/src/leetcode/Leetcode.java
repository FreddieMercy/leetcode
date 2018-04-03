/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
//import _2017.June2017.Jun10th2017._126WordLadderII.Solution;
import com.sun.tools.javac.util.ArrayUtils;
import javafx.util.Pair;

import java.lang.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 *
 * @author junhao.zhang.freddie
 */

interface sth{
    int index  = 10;
    void test();
}
class Solution implements sth {

    public void test() {
        System.out.println(index + 1);
    }

    public void kthSmallest() {
        test();
        System.out.println("2");
    }
}





public class Leetcode {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        Solution x = new Solution();
        x.kthSmallest();
    }
}