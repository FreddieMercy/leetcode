using System;
namespace Leetcode._2017.August2017.Aug29th2017._283MoveZeroes
{
    public class Solution
    {
        public void MoveZeroes(int[] nums)
        {
            int indexOfZero = int.MinValue;
            for (int i = 0; i < nums.Length;++i){
                if(nums[i]==0){
                    if (indexOfZero == int.MinValue)
                    {
                        indexOfZero = i;
                    }
                }
                else if(indexOfZero!=int.MinValue){
                    nums[indexOfZero] = nums[i];
                    nums[i] = 0;
                    indexOfZero++;
                }
            }
        }
    }
}
