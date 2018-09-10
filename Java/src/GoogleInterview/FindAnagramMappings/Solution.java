package GoogleInterview.FindAnagramMappings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] ans = new int[B.length];
        for(int i = 0; i < B.length;++i){
            m.put(B[i], i);
        }

        for(int i = 0; i < A.length;++i){
            ans[i] = m.get(A[i]);
        }

        return ans;

    }
}