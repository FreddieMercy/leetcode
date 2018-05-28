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
	int move(int size, int current, int steps) {

		steps %= size;

		int tmp = current + steps;

		if (tmp >= 0 && tmp < size) {
			return tmp;
		}

		if (tmp < 0) {
			return size + tmp;
		}

		return tmp - size;
	}
public:
	bool circularArrayLoop(vector<int>& nums) {
		
		for (int i = 0; i < nums.size();++i) {
			vector<bool> dp(nums.size());

			int cur = i;
			int counter = 0;
			bool sign = nums[i] < 0;

			while (!dp[cur] && (nums[cur]<0) == sign) {
				dp[cur] = true;
				counter++;
				cur = move(nums.size(), cur, nums[cur]);
			}

			if (dp[cur] && counter > 1 && cur == i) {
				return true;
			}
		}

		return false;
	}
};

