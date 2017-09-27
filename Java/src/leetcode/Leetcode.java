/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
import _2017.June2017.Jun10th2017._126WordLadderII.Solution;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */
public class Leetcode {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String [] word={"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String [] word = {"hot","dot","dog","lot","log","cog"};
        List<String> words = new ArrayList(Arrays.asList(word));
        Solution x = new Solution();
        //System.out.println(x.ladderLength("qa","sq",Arrays.asList(word)));
        System.out.println(x.findLadders("hit","cog",words));
    }
    
}