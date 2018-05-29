package _248StrobogrammaticNumberIII

import (
	"fmt"
	"strconv"
	"strings"
)

func strobogrammaticInRange(low string, high string) int {
	table := map[rune]int{'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}
	var f = []int{0, 3, 4, 12}
	buildf := func(l int) { //max(len(low), len(high))
		for i := 4; i < max(3, l)+1; i += 1 {
			f = append(f, f[i-2]*5)
		}
	}

	getRef := func(a string) string {
		if a == "0" || a == "1" || a == "8" {
			return a
		}
		if a == "6" {
			return "9"
		}
		return "6"

	}

	isRef := func(a string, b string) bool {
		if a == "0" || a == "1" || a == "6" || a == "8" || a == "9" {
			return b == getRef(a)
		}
		return false
	}

	isSBG := func(num string) bool {

		for i := 0; i < (len(num)+1)/2; i += 1 {
			if !isRef(string(num[i]), string(num[len(num)-1-i])) {
				return false
			}
		}
		return true
	}

	findSBG := func(num string) int {
		l := len(num)
		if l == 1 {
			n, e := strconv.Atoi(num)
			if e != nil {
				fmt.Errorf("e != nil")
			}
			if n == 0 {
				return 1
			}
			if n < 8 {
				return 2
			}
			return 3
		}
		cover := []string{"0", "1", "6", "6", "6", "6", "6", "8", "8", "9"}
		la := []bool{false, false, true, true, true, true, false, true, false, false}
		bases := []int{0, 1, 0, 0, 0, 0, 2, 0, 3, 4}

		c := ""
		isLA := false
		cur := 0
		exp := 4
		for i := 0; i < l/2; i += 1 {
			if isLA {
				c += "0"
			} else {
				c += cover[table[rune(num[i])]]
				isLA = la[table[rune(num[i])]]
			}

			if i == 0 {
				cur = cur*exp + bases[table[rune(c[i])]] - 1
			} else {
				cur = cur*exp + bases[table[rune(c[i])]]
			}

			exp = 5
		}

		if l%2 == 1 {
			toAdd := ""
			if isLA {
				toAdd = "0"
			} else {
				cover[6] = "1"
				cover[7] = "1"
				cover[9] = "8"
				toAdd = cover[table[rune(num[l/2])]]
			}
			c += toAdd
			if toAdd == "0" {
				cur = cur * 3
			} else if toAdd == "1" {
				cur = cur*3 + 1
			} else {
				cur = cur*3 + 2
			}
		}
		cur += 1

		for i := (l + 1) / 2; i < l; i += 1 {
			getRef(string(c[l-1-i]))
		}

		if strings.Compare(c, num) > 0 {
			cur -= 1
		}

		for i := 1; i < l; i++ {
			cur += f[i]
		}
		return cur
	}

	if len(low) > len(high) {
		return 0
	}

	buildf(max(len(low), len(high)))

	if isSBG(low) {
		return max(findSBG(high)-findSBG(low)+1, 0)
	}
	return max(findSBG(high)-findSBG(low), 0)

}

/*


//Java:

class Solution {
    int[] f;
    public int strobogrammaticInRange(String low, String high) {
        if (low.length()>high.length()) return 0;
        buildf(Math.max(low.length(),high.length()));

        int ret=findSBG(high)-findSBG(low)+(isSBG(low)?1:0);
        return Math.max(ret,0);
    }

    private void buildf(int l) {
        int size=Math.max(3,l)+1;
        f=new int[size];
        f[1]=3;
        f[2]=4;
        f[3]=12;
        for (int i=4;i<size;i++) f[i]=f[i-2]*5;
    }

    private int findSBG(String num) {
        int l=num.length();
        if (l==1) {
            int n=Integer.parseInt(num);
            if (n==0) return 1;
            if (n<8) return 2;
            return 3;
        }
        char[] cover={'0','1','6','6','6','6','6','8','8','9'};
        boolean[] la={false,false,true,true,true,true,false,true,false,false};
        int[] bases={0,1,0,0,0,0,2,0,3,4};
        String c="";
        boolean isLA=false;
        int cur=0;
        int exp=4;
        for (int i=0;i<l/2;i++) {
            if (isLA) {
                c+="0";
            } else {
                int index=(int)(num.charAt(i)-'0');
                c+=cover[index];
                isLA=la[index];
            }
            cur=cur*exp+bases[(int)(c.charAt(i)-'0')]+((i==0)?0:1)-1;
            exp=5;
        }
        if (l%2==1) {
            char toAdd;
            if (isLA) toAdd='0';
            else {
                cover[6]='1';
                cover[7]='1';
                cover[9]='8';
                toAdd=cover[(int)(num.charAt(l/2)-'0')];
            }
            c+=toAdd;
            if (toAdd=='0') cur=cur*3;
            else if (toAdd=='1') cur=cur*3+1;
            else cur=cur*3+2;
        }
        cur+=1;
        for (int i=(l+1)/2;i<l;i++) c+=getRef(c.charAt(l-1-i));
        if (c.compareTo(num)>0) cur-=1;
        for (int i=1;i<l;i++) cur+=f[i];
        return cur;
    }

    private boolean isRef(char a, char b) {
        if (a=='0' || a=='1' || a=='6' || a=='8' || a=='9') return b==getRef(a);
        return false;
    }

    private char getRef(char a) {
        if (a=='0' || a=='1' || a=='8') return a;
        if (a=='6') return '9';
        else return '6';
    }

    private boolean isSBG(String num) {
        for (int i=0;i<(num.length()+1)/2;i++) if (!isRef(num.charAt(i),num.charAt(num.length()-1-i))) return false;
        return true;
    }
}

*/
