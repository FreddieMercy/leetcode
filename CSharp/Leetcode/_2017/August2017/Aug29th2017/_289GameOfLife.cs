using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;
using System.Collections;
namespace Leetcode._2017.August2017.Aug29th2017._289GameOfLife
{
    public class Solution
    {
        private int[,] _board;
        private bool checkInBoard(int y, int x)
        {
            if (y >= 0 && y < _board.GetLength(0) && x >= 0 && x < _board.GetLength(1))
            {
                return true;
            }
            return false;
        }
        private int Lives(int x, int y)
        {
            int lives = 0;
            if (checkInBoard(x + 1, y) && _board[x + 1, y] == 1)
            {
                lives++;
            }
            if (checkInBoard(x + 1, y + 1) && _board[x + 1, y + 1] == 1)
            {
                lives++;
            }
            if (checkInBoard(x + 1, y - 1) && _board[x + 1, y - 1] == 1)
            {
                lives++;
            }
            if (checkInBoard(x, y + 1) && _board[x, y + 1] == 1)
            {
                lives++;
            }
            if (checkInBoard(x, y - 1) && _board[x, y - 1] == 1)
            {
                lives++;
            }
            if (checkInBoard(x - 1, y + 1) && _board[x - 1, y + 1] == 1)
            {
                lives++;
            }
            if (checkInBoard(x - 1, y) && _board[x - 1, y] == 1)
            {
                lives++;
            }
            if (checkInBoard(x - 1, y - 1) && _board[x - 1, y - 1] == 1)
            {
                lives++;
            }

            return lives;
        }
        public void GameOfLife(int[,] board)
        {
            _board = board.Clone() as int[,];
            for (int row = 0; row < board.GetLength(0); ++row)
            {
                for (int col = 0; col < board.GetLength(1); ++col)
                {
                    int lives = this.Lives(row, col);
                    if (_board[row, col] == 0)
                    {
                        if (lives == 3)
                        {
                            board[row, col] = 1;
                        }
                    }
                    else if (lives < 2 || lives > 3)
                    {
                        board[row, col] = 0;
                    }
                }
            }
        }
    }
}
