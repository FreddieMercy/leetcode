package GoogleInterview.MedianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    private Double helper(int m, int s1, int s2, int[] nums1, int nums2[]){

        if(s1>=nums1.length)
            return (double)nums2[s2+m-1];
        if(s2>=nums2.length)
            return (double)nums1[s1+m-1];

        if(m==1)
            return (double)Math.min(nums1[s1], nums2[s2]);

        int span = m/2-1;
        int mid1 = s1+span;
        int mid2 = s2+span;
        int v1 = Integer.MAX_VALUE;
        int v2 = Integer.MAX_VALUE;

        if(mid1< nums1.length)
            v1 = nums1[mid1];
        if(mid2<nums2.length)
            v2 = nums2[mid2];

        if(v1>v2)
            return helper(m-span-1, s1, mid2+1, nums1, nums2);
        return helper(m-span-1, mid1+1, s2, nums1, nums2);

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        int m = total/2;

        if(total%2==1){
            return helper(m+1,0,0,nums1, nums2);
        }
        return (helper(m,0,0,nums1, nums2)+helper(m+1,0,0,nums1, nums2))/2;
    }
}


/*

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length+nums2.length;
        int m = total/2-1;
        boolean even = total%2==0;
        int s1 = 0;
        int s2 = 0;

        int span1;
        int span2;

        List<Integer> values = new ArrayList<>();

        while(m>3){

            span1 = m/2-1;
            span2 = m/2-1;

            if(!(s1+span1 < nums1.length && s2+span2 < nums2.length)){
                if(s1>=nums1.length){
                    if(even){
                        return ((double)(nums2[s2+m]-nums2[s2+m+1]))/2+nums2[s2+m+1];
                    }
                    return nums2[s2+m];
                }
                if(s2>=nums2.length){
                    if(even){
                        return ((double)(nums1[s1+m]-nums1[s1+m+1]))/2+nums1[s1+m+1];
                    }
                    return nums1[s1+m];
                }
                if(s2+span2<nums2.length){
                    span1 = nums1.length-1-s1;
                    span2 = m-span1-1;
                }
                else{
                    span2 = nums2.length-1-s2;
                    span1 = m-span2-1;
                }
            }
            if(nums1[s1+span1] > nums2[s2+span2]){
                s2 = s2+span2+1;
                m=m-span2-1;
            }
            else{
                s1 = s1+span1+1;
                m = m -span1-1;
            }
        }

        for(int i = s1; i < nums1.length;++i){
            values.add(nums1[i]);
            if(i>s1+3){
                break;
            }
        }
        for(int i = s2; i < nums2.length;++i){
            values.add(nums2[i]);
            if(i>s2+3){
                break;
            }
        }
        values.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        if(even){
            return ((double)(values.get(m)-values.get(m+1)))/2+values.get(m+1);
        }
        return values.get(m+1);
    }
}

*/