using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;

namespace Leetcode._2017.August2017.Aug25th2017._212WordSearchII
{
    public class Solution
    {
		private class Node
		{
			public Dictionary<Char, Node> next;
			public Node()
			{
				next = new Dictionary<char, Node>();
			}
		}
        private Node root = new Node();
        private bool[,] visited;// = new bool[1,1];
        private List<String> s = new List<string>();
        private char[,] _board;
        private int row, col;
        private void Insert(string word)
		{
			Node tmp = root;
			foreach (char c in word)
			{
				if (!tmp.next.ContainsKey(c))
				{
					tmp.next[c] = new Node();
				}
				tmp = tmp.next[c];
			}
			tmp.next['\n'] = null;
		}
        private bool contains(int i, int j, Node node = null, String input = ""){
			bool found = false;
			bool next = false;
			if (node == null)
			{
				node = root;
			}
			if (node.next.ContainsKey('\n'))
			{
				if (!s.Contains(input))
				{
					s.Add(input);
				}
				found = true;
			}
            if (i >= 0 && i < row && j >= 0 && j < col)
            {
                if (!visited[i, j])
                {
                    visited[i, j] = true;

                    if (node.next.ContainsKey(_board[i, j]))
                    {
                        next = contains(i + 1, j, node.next[_board[i, j]], input + _board[i, j]) | contains(i - 1, j, node.next[_board[i, j]], input + _board[i, j]) |

                            contains(i, j + 1, node.next[_board[i, j]], input + _board[i, j]) | contains(i, j - 1, node.next[_board[i, j]], input + _board[i, j]);
                    }

                    visited[i, j] = false;
                }
            }
            return found|next;
        }
		public IList<string> FindWords(char[,] board, string[] words)
        {
            _board = board;
            row = _board.GetLength(0);
            col = _board.GetLength(1);
            visited = new bool[row, col];
            foreach(String t in words){
                this.Insert(t);
            }

            for (int i = 0; i < row;++i){
                for (int j = 0; j < col; ++j)
                {
                    contains(i, j);
                }
            }

            return s;
        }
    }
}