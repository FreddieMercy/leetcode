package GoogleInterview.ReverseVowelsOfAString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        StringBuilder str = new StringBuilder(s);
        int i = 0;
        int j = str.length()-1;
        if(j<=0)
            return s;
        while(i<j){
            boolean left = vowels.contains(str.charAt(i));
            boolean right = vowels.contains(str.charAt(j));
            if(!left)
                i++;
            if(!right)
                j--;
            if(left&&right)
            {
                char c = str.charAt(i);
                str.setCharAt(i, str.charAt(j));
                str.setCharAt(j, c);
                i++;
                j--;
            }
        }

        return str.toString();
    }
}