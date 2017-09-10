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
	vector<int> getRow(int rowIndex) {
		vector<int> ans = { 1 };

		for (int i = 0; i < rowIndex; ++i) {
			int tmp = ans[i] * (rowIndex - i) / (i + 1);
			ans.push_back(tmp);
		}
		return ans;
	}
};