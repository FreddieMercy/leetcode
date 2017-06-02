#include <iostream>
#include <functional>
#include <vector>
#include <queue>
#include <fstream>
#include <string>
#include <bitset>
#include <sstream>
#include "_54SpiralMatrix.h"

using namespace std;


int main(int argc, char*argv[])
{
	vector<int> v;
	v.push_back(1);
	v.push_back(11);

	vector<int> v1;
	v1.push_back(2);
	v1.push_back(12);

	vector<int> v2;
	v2.push_back(3);
	v2.push_back(13);

	vector<int> v3;
	v3.push_back(4);
	v3.push_back(14);

	vector<int> v4;
	v4.push_back(5);
	v4.push_back(15);

	vector<int> v5;
	v5.push_back(6);
	v5.push_back(16);

	vector<int> v6;
	v6.push_back(7);
	v6.push_back(17);

	vector<int> v7;
	v7.push_back(8);
	v7.push_back(18);

	vector<int> v8;
	v8.push_back(9);
	v8.push_back(19);

	vector<int> v9;
	v9.push_back(10);
	v9.push_back(20);

	vector<vector<int>> matrix;
	matrix.push_back(v);
	matrix.push_back(v1);
	matrix.push_back(v2);
	matrix.push_back(v3);
	matrix.push_back(v4);
	matrix.push_back(v5);
	matrix.push_back(v6);
	matrix.push_back(v7);
	matrix.push_back(v8);
	matrix.push_back(v9);

	Solution sth;

	vector<int> m = sth.spiralOrder(matrix);

	for (int i = 0; i < m.size(); i++)
	{
		cout << m[i];

		if (i < m.size() - 1)
		{
			cout << ", ";
		}
	}

	cout << "\n";

	return 0;
}
/*
int main(int argc, char*argv[])
{
	vector<int> v;
	v.push_back(1);
	v.push_back(2);
	v.push_back(3);

	vector<int> v1;
	v1.push_back(4);
	v1.push_back(5);
	v1.push_back(6);

	vector<int> v2;
	v2.push_back(7);
	v2.push_back(8);
	v2.push_back(9);

	vector<vector<int>> matrix;
	matrix.push_back(v);
	matrix.push_back(v1);
	matrix.push_back(v2);

	Solution sth;

	vector<int> m = sth.spiralOrder(matrix);

	for (int i = 0; i < m.size(); i++)
	{
		cout << m[i];

		if (i < m.size() - 1)
		{
			cout << ", ";
		}
	}

	cout << "\n";

	return 0;
}
*/