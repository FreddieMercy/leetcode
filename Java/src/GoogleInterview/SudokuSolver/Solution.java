package GoogleInterview.SudokuSolver;

import java.util.*;

public class Solution {

    private static int header = ~(512) + 1;

    private void do_dp(int i, int j, int[][] JiuGong, int[] row, int[] col, char[][] board, List<int[]> empty) {
        int value = 1 << (board[i][j] - '0' - 1);
        row[i] += new Integer(value);
        col[j] += new Integer(value);
        JiuGong[i / 3][j / 3] += value;
    }

    private void swap(List<int[]> empty, int i, int j) {
        int[] tmp = empty.get(i);
        empty.set(i, empty.get(j));
        empty.set(j, tmp);
    }

    private int compare(int[] o1, int[] o2, Map<Integer, Integer> digits, int[] col, int[] row, int[][] JiuGong) {
        int left = ~(header | col[o1[1]]) & ~(header | row[o1[0]]) & ~(header | JiuGong[o1[0] / 3][o1[1] / 3]);
        int right = ~(header | col[o2[1]]) & ~(header | row[o2[0]]) & ~(header | JiuGong[o2[0] / 3][o1[1] / 3]);
        int l = left;
        int r = right;

        Integer l_tmp = digits.get(left);
        Integer r_tmp = digits.get(right);

        int l_digit = (l_tmp == null) ? 0 : l_tmp;
        int r_digit = (r_tmp == null) ? 0 : r_tmp;

        while (left != 0 || right != 0) {
            if ((left & 1) == 1)
                l_digit++;
            if ((right & 1) == 1)
                r_digit++;

            left >>>= 1;
            right >>>= 1;
        }

        if (l_tmp == null)
            digits.put(l, l_digit);

        if (r_tmp == null)
            digits.put(r, r_digit);

        return l_digit - r_digit;
    }

    private void mergeSort(List<int[]> empty, Map<Integer, Integer> digits, int[] col, int[] row, int[][] JiuGong, int start, int end, int[][] memory) {

        if (end <= start) {
            return;
        }

        if (end == start + 1) {
            memory[start] = empty.get(start);
            return;
        }

        int mid = (end - start) / 2 + start;

        mergeSort(empty, digits, col, row, JiuGong, start, mid, memory);
        mergeSort(empty, digits, col, row, JiuGong, mid, end, memory);

        int left = start;
        int right = mid;
        int indexes = start;

        while (left < mid || right < end) {
            if (left < mid && right < end) {
                if (compare(memory[left], memory[right], digits, col, row, JiuGong) < 0)
                    empty.set(indexes, memory[left++]);
                else
                    empty.set(indexes, memory[right++]);

            } else {
                if (left < mid)
                    empty.set(indexes, memory[left++]);
                else
                    empty.set(indexes, memory[right++]);
            }
            indexes++;
        }

        for (int j = start; j < end; ++j) {
            memory[j] = empty.get(j);
        }

    }

    public void solveSudoku(char[][] board) {

        int[][] JiuGong = new int[board.length / 3][board[0].length / 3];
        int[] row = new int[board.length];
        int[] col = new int[board.length];
        List<int[]> empty = new ArrayList<>();
        Map<Integer, Integer> digits = new HashMap<>();

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (board[i][j] != '.')
                    do_dp(i, j, JiuGong, row, col, board, empty);
                else
                    empty.add(new int[]{i, j});

        mergeSort(empty, digits, col, row, JiuGong, 0, empty.size(), new int[empty.size()][2]);

        solveIt(0, JiuGong, row, col, board, empty);

    }

    private boolean solveIt(int index, int[][] JiuGong, int[] row, int[] col, char[][] board, List<int[]> empty) {
        if (index < empty.size()) {
            int[] pos = empty.get(index);
            int i = pos[0];
            int j = pos[1];
            int need_b = ~(header | col[j]) & ~(header | row[i]) & ~(header | JiuGong[i / 3][j / 3]);
            int need = 0;


            while (need_b != 0) {
                need++;
                if ((need_b & 1) == 1) {
                    board[i][j] = (char) (need + '0');
                    int value = 1 << (board[i][j] - '0' - 1);
                    JiuGong[i / 3][j / 3] += value;
                    row[i] += value;
                    col[j] += value;
                    if (solveIt(index + 1, JiuGong, row, col, board, empty)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                        JiuGong[i / 3][j / 3] -= value;
                        row[i] -= value;
                        col[j] -= value;
                    }
                }

                need_b = need_b >>> 1;
            }

            return false;
        }

        return true;
    }

}