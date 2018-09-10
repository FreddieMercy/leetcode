package GoogleInterview.ProductOfArrayExceptSelf;

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        output[0] = 1;
        output[nums.length-1] = 1;

        int left = 0;
        int lValue = 1;
        int right = nums.length-1;
        int rValue = 1;

        for(int i = 1; i < nums.length;++i){

            left++;
            right--;

            lValue *= nums[i-1];
            rValue *= nums[nums.length-i];

            if(left<right) {
                output[i] = lValue;
                output[nums.length - 1 - i] = rValue;
            }
            else if(left==right){
                output[i] = lValue*rValue;
            }
            else{
                output[i] *= lValue;
                output[nums.length - 1 - i] *= rValue;
            }
        }

        return output;

    }
}