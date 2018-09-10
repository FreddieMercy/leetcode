package GoogleInterview.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private void helper(int X, int Y, int height, int width, int[][] matrix, List<Integer> ans, int direction){//width/height start from 0

        if(direction == 0) {

            if (width < 0 || height<0) {
                return;
            }

            if(width==0){
                for (int i = 0; i <= height; ++i) {
                    ans.add(matrix[i+X][Y]);
                }
                return;
            }

            if(height==0){
                for (int i = 0; i <= width; ++i) {
                    ans.add(matrix[X][Y+i]);
                }

                return;
            }

            for (int i = 0; i < width; ++i) {
                ans.add(matrix[X][Y+i]);
            }

            helper(X,Y+width, height, width, matrix,ans,(direction+1)%4);
        }

        if(direction == 1){

            for (int i = 0; i < height; ++i) {
                ans.add(matrix[i+X][Y]);
            }

            helper(X+height,Y, height, width, matrix,ans,(direction+1)%4);
        }

        if(direction == 2){

            for (int i = 0; i < width; ++i) {
                ans.add(matrix[X][Y-i]);
            }

            helper(X,Y-width, height, width-2, matrix,ans,(direction+1)%4);
        }

        if(direction == 3){

            for (int i = 0; i < height; ++i) {
                ans.add(matrix[X-i][Y]);
            }

            helper(X-height+1,Y+1, height-2, width, matrix,ans,(direction+1)%4);
        }

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if(matrix.length>0) {
            helper(0, 0, matrix.length - 1, matrix[0].length - 1, matrix, ans, 0);
        }

        return ans;
    }
}


