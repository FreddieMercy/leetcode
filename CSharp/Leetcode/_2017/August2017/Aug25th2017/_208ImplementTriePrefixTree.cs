using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;

namespace Leetcode._2017.August2017.Aug25th2017._208ImplementTriePrefixTree
{
    public class Trie
    {
        private class Node{
            public Dictionary<Char, Node> next;
            public Node(){
                next = new Dictionary<char, Node>();
            }
        }
        private Node root = new Node(); 
        /** Initialize your data structure here. */
        public Trie()
        {

        }

        /** Inserts a word into the trie. */
        public void Insert(string word)
        {
            Node tmp = root;
            foreach(char c in word){
                if(!tmp.next.ContainsKey(c))
                {
                    tmp.next[c] = new Node();
                }
                tmp = tmp.next[c];
            }
            tmp.next['\n'] = null;
        }

        /** Returns if the word is in the trie. */
        public bool Search(string word)
        {
			Node tmp = root;
			foreach (char c in word)
			{
				if (!tmp.next.ContainsKey(c))
				{
                    return false;
				}
				tmp = tmp.next[c];
			}
            if(tmp.next.ContainsKey('\n')){
                return true;
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public bool StartsWith(string prefix)
        {
			Node tmp = root;
            foreach (char c in prefix)
            {
                if (!tmp.next.ContainsKey(c))
                {
                    return false;
                }
                tmp = tmp.next[c];
            }
            return true;
        }
    }

    /**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.Insert(word);
	 * bool param_2 = obj.Search(word);
	 * bool param_3 = obj.StartsWith(prefix);
	 */
}
