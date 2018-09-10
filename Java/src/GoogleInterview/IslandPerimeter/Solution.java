package GoogleInterview.IslandPerimeter;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;

        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j]==1){
                    ans+=4*grid[i][j];
                    if(i<grid.length-1){
                        ans-=grid[i+1][j];
                    }
                    if(i>0){
                        ans-=grid[i-1][j];
                    }
                    if(j<grid[0].length-1){
                        ans-=grid[i][j+1];
                    }
                    if(j>0){
                        ans-=grid[i][j-1];
                    }
                }
            }
        }

        return ans;
    }
}