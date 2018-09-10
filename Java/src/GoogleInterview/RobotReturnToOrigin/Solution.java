package GoogleInterview.RobotReturnToOrigin;

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for(char c : moves.toCharArray()){
            if(c=='U'){
                x++;
            }

            if(c=='D'){
                x--;
            }

            if(c=='L'){
                y++;
            }

            if(c=='R'){
                y--;
            }


        }


        return x==0&&y==0;
    }
}