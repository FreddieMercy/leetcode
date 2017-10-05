using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;
using System.Collections;
namespace Leetcode._2017.August2017.Aug26th2017._227BasicCalculatorII
{
    public class Solution
    {
        private int evaluate(int x, char op, int y){
			switch (op)
			{
				case '+':
                    return x + y;
				case '-':
                    return x - y;
				case '*':
                    return x * y;
				case '/':
                    if(y==0){
                        return 0;
                    }
                    return x / y;
			}
            return y;
		}
        public int Calculate(string s)
        {
            int ret = 0, pre = 0, x = 0;
            string y = "";
            char op = '\0', preop = '\0';
            bool change = false;
            foreach (char c in s)
            {
                switch (c)
                {
                    case '+':
                        if (change)
                        {
                            ret = evaluate(x, op, int.Parse(y));
                            ret = evaluate(pre, preop, ret);
                            change = !change;
                            preop = '\0';
                        }
                        else
                        {
                            pre = ret;
                            ret = evaluate(x, op, int.Parse(y));
                        }
                        op = '+';
                        x = ret;
                        y = "";
                        break;
                    case '-':
                        if (change)
                        {
                            ret = evaluate(x, op, int.Parse(y));
                            ret = evaluate(pre, preop, ret);
                            change = !change;
                            preop = '\0';
                        }
                        else
                        {
                            pre = ret;
                            ret = evaluate(x, op, int.Parse(y));
                        }
                        op = '-';
                        x = ret;
                        y = "";
                        break;
                    case '*':
                        if (change)
                        {
                            ret = evaluate(x, op, int.Parse(y));
                            x = ret;
                        }
                        else
                        {
                            change = !change;
                            x = int.Parse(y);
                            pre = ret;
                            preop = op;
                        }
                        op = '*';
                        y = "";

                        break;
                    case '/':
                        if (change)
                        {
                            ret = evaluate(x, op, int.Parse(y));
                            x = ret;
                        }
                        else
                        {
                            change = !change;
                            x = int.Parse(y);
                            pre = ret;
                            preop = op;
                        }
                        op = '/';
                        y = "";
                        break;
                    case ' ':
                        break;
                    default:
                        y += c;
                        break;

                }
            }
            ret = evaluate(x, op, int.Parse(y));
            ret = evaluate(pre, preop, ret);

            return ret;
        }
    }
}
