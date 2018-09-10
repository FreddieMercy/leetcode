package GoogleInterview.QueueReconstructionbyHeight;

import sun.jvm.hotspot.memory.DictionaryEntry;

import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {

        List<int[]> People = new LinkedList<>();

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }

                return o1[1]-o2[1];
            }
        });


        for(int[] i : people){
            People.add(i[1], i);
        }

        return People.toArray(new int[people.length][2]);

    }
}
