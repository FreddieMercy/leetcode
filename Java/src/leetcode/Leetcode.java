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
import GoogleInterview.SudokuSolver.Solution;
public class Leetcode {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        Solution x = new Solution();
        char[][] board = new char[][] {{'.','2','6','5','.','.','.','9','.'},{'5','.','.','.','7','9','.','.','4'},{'3','.','.','.','1','.','.','.','.'},{'6','.','.','.','.','.','8','.','7'},{'.','7','5','.','2','.','.','1','.'},{'.','1','.','.','.','.','4','.','.'},{'.','.','.','3','.','8','9','.','2'},{'7','.','.','.','6','.','.','4','.'},{'.','3','.','2','.','.','1','.','.'}};
//        char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        x.solveSudoku(board);

        for(char[] b : board){
            for(char c : b){
                System.out.print(c);
                System.out.print(' ');
            }

            System.out.println();
        }
    }
}