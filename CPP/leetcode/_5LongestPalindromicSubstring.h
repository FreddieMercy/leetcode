#include <iostream>
#include <functional>
#include <vector>
#include <queue>
#include <fstream>
#include <string>
#include <bitset>
#include <sstream>
#include <climits>
#include <cmath>
#include <map>
#include <utility>
#include <stdint.h>
#include <algorithm>
#include <stack>
#include <set>

using namespace std;

class Solution {
public:
	string longestPalindrome(string s) {
		if (s.empty()) {
			return "";
		}
		
		if (s.size() == 1) {
			return s;
		}
		
		int min_start = 0, max_len = 1;
		int i = 0;

		while(i < s.size()) {
			
			if (s.size() - i <= max_len / 2) {
				//max_len cannot be longer
				break;
			}
			int k = i, j = i;

			while (k < s.size() - 1 && s[k + 1] == s[k]) {
				//skip adjacent same chars from i
				++k;
			}

			i = k + 1;

			while (k<s.size() - 1 && j>0 && s[j - 1] == s[k + 1]) {//within range
				//中心开花
				++k;
				--j; 
			}

			int new_len = k - j + 1;
			if (max_len<new_len) { max_len = new_len; min_start = j; }
		}
		return s.substr(min_start, max_len);
	}
};



/*
//O(n^3)

class Solution {
private:
	bool isPalindrome(string s, int i, int j) {
		for (int index = 0; index <= (j+1 - i) / 2; ++index) {
			if (s[i+index] != s[j - index]) {
				return false;
			}
		}

		return true;
	}
public:
	string longestPalindrome(string s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); ++i) {
			for (int j = i; j < s.length(); ++j) {
				if (j - i>end - start&&isPalindrome(s, i, j)) {
					start = i;
					end = j;
				}
			}
		}

		return s.substr(start, end + 1-start);
	}
};
*/