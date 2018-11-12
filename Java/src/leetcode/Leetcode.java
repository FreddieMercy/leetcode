/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;


import jdk.management.resource.internal.inst.InitInstrumentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

class q6_7 {
    /**
     * ratio 1:1
     */
    private static int boys = 0;
    private static int girls = 0;
    private static int families = 10000;

    public static void testAlgo(){
        for (int i = 0; i < families; i++){
            Random r = new Random();
            int b = 0;
            int g = 0;
            while (g == 0){
                if (r.nextBoolean()){
                    g++;
                }
                else{
                    b++;
                }
            }
            boys += b;
            girls += g;
            float ratio = girls / (float)(boys + girls);
            System.out.println("#" + (i+1) + " family: G-" + girls + " B-" + boys + " Ratio:" + ratio);
        }
    }
}

public class Leetcode {

    public static void main(String[] args) {
        Thread th1 = new Thread(){

            @Override
            public void run(){
                for(int i = 0; i < 1000; ++i){
                    //yield();
                    System.out.println(i);
                }
            }

        };
        Thread th2 = new Thread(){

            @Override
            public void run(){
                for(char i = 'a'; i <= 'z'; ++i){
                    System.out.println(i);
                }
            }

        };

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; ++i)
                    System.out.println("I am Runnable");
            }
        });
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; ++i)
                    System.out.println("I am Runnable2");
            }
        };
        //runnable.run();
        //th1.start();
        //th1.interrupt();

        /*
        try {
            th1.join();
        }
        catch (Exception e){
            System.out.println("-------------------------------------------------------------------------------------------");
        }
        */
        //th2.start();
        //th3.start();

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("I am callable");
                return 0;
            }
        };

        try{
            callable.call();

        }
        catch (Exception e){

        }

        for(Integer i : primesTo(100)){
            System.out.print(i);
            System.out.print(" ");
        }

        q6_7 x = new q6_7();
        x.testAlgo();

    }

    private static List<Integer>  primesTo(int n){
        List<Integer> ans = new ArrayList<>();
        boolean[] flags = new boolean[n+1];
        Integer prime = 2;
        while(prime!=null&&prime<=n){
            crossOff(flags, prime);
            ans.add(prime);
            prime = nextPrime(flags, prime);
        }

        return ans;
    }

    private static void crossOff(boolean[] flags, int prime){
        for(int i = prime*prime; i < flags.length; i+=prime){
            flags[i]=true;
        }
    }
    private static Integer nextPrime(boolean[] flags, int prime){
        for(int i = prime+1; i < flags.length; i++){
            if(!flags[i]){
                return i;
            }
        }
        return null;
    }
}


/*
class Solution {

    private void helper(int[][] costs, int house, int color,int soFar, int[] ans) {

        for (int c = 0; c < costs[0].length; ++c) {
            if (c != color) {
                if (house==costs.length-1) {
                    ans[0] = Math.min(ans[0], costs[house][c]+soFar);
                } else {
                    soFar += costs[house][c];
                    helper(costs, house + 1, c, soFar, ans);
                    soFar-=costs[house][c];
                }
            }
        }
    }
    public int minCostII(int[][] costs) {
        // Write your solution here
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        for (int c = 0; c < costs[0].length; ++c)
            if(costs.length!=1)
                helper(costs, 1, c, costs[0][c], ans);
            else
                ans[0] = Math.min(ans[0], costs[0][c]);
        return ans[0];
    }
}

class Solution {
    private boolean contains(String s, StringBuilder sb){
        int i = 0;
        for(int j = 0; j < s.length(); ++j){
            if(s.charAt(j) == sb.charAt(i)){
                i++;
            }
            if(i>=sb.length()){
                return true;
            }
        }

        return false;
    }

    private void nextPermutation(StringBuilder sb){
        Integer i = null;
        for(int index = 0; index < sb.length()-1; ++index){
            if(sb.charAt(index) < sb.charAt(index+1)){
                i = index;
            }
        }

        if(i == null){
            //throw new Exception("It is not possible");
        }

        int j = i+1;
        for(int index = i+1; index < sb.length(); ++index){
            if(sb.charAt(index)>sb.charAt(i)){
                j = index;
            }
        }

        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);

        int left = i+1;
        int right = sb.length()-1;

        while(left<right){
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, c);
            left++;
            right--;
        }
    }

    public String removeDuplicateLetters(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        boolean[] count = new boolean[26];
        for(char c :s.toCharArray()){
            count[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count.length; ++i){
            if(count[i]){
                sb.append((char)(i+'a'));
            }
        }

        while(!contains(s, sb)){
            nextPermutation(sb);
        }

        return sb.toString();
    }
}


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static class Ptr{
        Set<String> ans = new HashSet<>();
        int size = Integer.MAX_VALUE;
    }
    private void helper(String s, StringBuilder sb, int index, Ptr ptr, int left, int right){
        if(index>=s.length()){
            if(left==right){
                int tmp = s.length()-sb.length();
                if(tmp<ptr.size){
                    ptr.size = tmp;
                    ptr.ans = new HashSet<>();
                    ptr.ans.add(sb.toString());
                }
                else if(tmp==ptr.size){
                    ptr.ans.add(sb.toString());
                }
            }

            return;
        }
        for(int i = index; i < s.length();++i){
            boolean added = true;
            char c = s.charAt(i);
            int l = left;
            int r = right;
            if(c!=')'&&c!='('){
                sb.append(c);
                helper(s, sb, i+1, ptr, l, r);
                sb.deleteCharAt(sb.length()-1);
                return;
            }
            else{
                if(c=='('){
                    sb.append(c);
                    l++;
                }
                else{
                    if(left>right){
                        sb.append(c);
                        r++;
                    }
                    else{
                        added = false;
                    }
                }
            }

            if(added){
                helper(s, sb, i+1, ptr, l, r);
                sb.deleteCharAt(sb.length()-1);
            }
        }

        helper(s, sb, Integer.MAX_VALUE, ptr, left, right);
    }
    public List<String> removeInvalidParentheses(String s) {
        //10:45
        //"" is valid
        //ignore non-p
        Ptr ptr = new Ptr();

        helper(s, new StringBuilder(), 0, ptr,0, 0);

        if(ptr.ans.size()==0){
            ptr.ans.add("");
        }

        List<String> rtn = new ArrayList<>();

        for(String str : ptr.ans){
            rtn.add(str);
        }

        return rtn;
    }
}


class Solution {
    public String helper(StringBuilder s, int[] index, boolean[] open) {
        //3:37
        StringBuilder sn = new StringBuilder();
        int num = -1;
        //num==0
        //num not set
        int i = index[0];
        while(i < s.length()){
            int d = s.charAt(i)-'0';
            if(0<=d&&d<=9){
                if(num<0){
                    num = 0;
                }
                num*=10;
                num+=d;
            }
            else{
                if(open[0]&&s.charAt(i)==']'){
                    i++;
                    open[0]=false;
                    break;
                }
                if(s.charAt(i)=='['&&num>=0){//brack unbalanced //num==-1 still?
                    i++;
                    int[] tmp  = new int[]{i};
                    boolean[] found = new boolean[]{true};
                    String str = helper(s, tmp, found);
                    i = tmp[0];

                    if(found[0]){
                        sn.append(""+num);
                        sn.append(str);
                    }
                    else{
                        for(int j = 0; j < num;++j){
                            sn.append(str);
                        }
                        num = -1;
                        continue;
                    }
                }
                else{
                    if(num>=0){
                        sn.append(""+num);
                        num=-1;
                    }
                    sn.append(s.charAt(i));
                }

            }
            ++i;
        }
        index[0]=i;
        return sn.toString();
    }
    public String decodeString(String s) {
        return helper(new StringBuilder(s), new int[1], new boolean[]{false});
    }
}
public class Leetcode {
    class Solution {
        public String helper(StringBuilder s, int[] index, boolean[] open) {
            //3:37
            StringBuilder sn = new StringBuilder();
            int num = -1;
            //num==0
            //num not set
            int i = index[0];
            while(i < s.length()){
                int d = s.charAt(i)-'0';
                if(0<=d&&d<=9){
                    if(num<0){
                        num = 0;
                    }
                    num*=10;
                    num+=d;
                }
                else{
                    if(open[0]&&s.charAt(i)==']'){
                        i++;
                        open[0]=false;
                        break;
                    }
                    if(s.charAt(i)=='['&&num>=0){//brack unbalanced //num==-1 still?
                        i++;
                        int[] tmp  = new int[]{i};
                        boolean[] found = new boolean[]{true};
                        String str = helper(s, tmp, found);
                        i = tmp[0];

                        if(found[0]){
                            sn.append(""+num);
                            sn.append(str);
                        }
                        else{
                            for(int j = 0; j < num;++j){
                                sn.append(str);
                            }
                            num = -1;
                            continue;
                        }
                    }
                    else{
                        if(num>=0){
                            sn.append(""+num);
                            num=-1;
                        }
                        sn.append(s.charAt(i));
                    }

                }
                ++i;
            }
            index[0]=i;
            return sn.toString();
        }
        public String decodeString(String s) {
            return helper(new StringBuilder(s), new int[1], new boolean[]{false});
        }
    }
    public static void main(String[] args) {
        Solution x = new Solution();
        System.out.println(x.decodeString("3[a2[c]]"));
    }
}
*/