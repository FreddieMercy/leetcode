using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;
using System.Collections;
namespace Leetcode._2017.August2017.Aug09th2017._218TheSkylineProblem
{
    /*
     //int[,] nums = {{2190, 661048, 758784},{9349, 881233, 563276},{12407, 630134, 38165},{22681, 726659, 565517},{31035, 590482, 658874},{41079, 901797, 183267},{41966, 103105, 797412},{55007, 801603, 612368},{58392, 212820, 555654},{72911, 127030, 629492},{73343, 141788, 686181},{83528, 142436, 240383},{84774, 599155, 787928},{106461, 451255, 856478},{108312, 994654, 727797},{126206, 273044, 692346},{134022, 376405, 472351},{151396, 993568, 856873},{171466, 493683, 664744},{173068, 901140, 333376},{179498, 667787, 518146},{182589, 973265, 394689},{201756, 900649, 31050},{215635, 818704, 576840},{223320, 282070, 850252},{252616, 974496, 951489},{255654, 640881, 682979},{287063, 366075, 76163},{291126, 900088, 410078},{296928, 373424, 41902},{297159, 357827, 174187},{306338, 779164, 565403},{317547, 979039, 172892},{323095, 698297, 566611},{323195, 622777, 514005},{333003, 335175, 868871},{334996, 734946, 720348},{344417, 952196, 903592},{348009, 977242, 277615},{351747, 930487, 256666},{363240, 475567, 699704},{365620, 755687, 901569},{369650, 650840, 983693},{370927, 621325, 640913},{371945, 419564, 330008},{415109, 890558, 606676},{427304, 782478, 822160},{439482, 509273, 627966},{443909, 914404, 117924},{446741, 853899, 285878},{480389, 658623, 986748},{545123, 873277, 431801},{552469, 730722, 574235},{556895, 568292, 527243},{568368, 728429, 197654},{593412, 760850, 165709},{598238, 706529, 500991},{604335, 921904, 990205},{627682, 871424, 393992},{630315, 802375, 714014},{657552, 782736, 175905},{701356, 827700, 70697},{712097, 737087, 157624},{716678, 889964, 161559},{724790, 945554, 283638},{761604, 840538, 536707},{776181, 932102, 773239},{855055, 983324, 880344}};
            //int[,] nums = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
            //int[,] nums = { { 1, 10, 1 }, {1, 9, 2}, {1, 8, 3}, {12, 15, 3} };
            int[,] nums = {{4547,253463,513907},{16593,154606,197418},{20536,587972,480271},{25155,135407,277021},{45693,480063,10484},{57392,70775,887782},{69423,760082,373899},{93047,222798,416217},{105421,832604,877583},{113118,797930,760771},{128302,234173,548113},{137036,889837,902341},{151470,195177,920702},{153020,398494,465441},{153980,501882,565647},{159005,416356,28559},{218765,535515,140331},{303595,627878,399999},{333489,449295,827098},{359242,830671,455392},{390291,400129,693584},{429774,450923,637981},{493315,563384,655884},{500860,718561,769319},{507299,817616,228},{537517,989102,300696},{543853,843011,695472},{550404,559944,90888},{617555,907369,523648},{622624,989745,894596},{640808,867707,963706},{697210,716449,705689},{804555,914745,764029}};
            //int[,] nums = { { 1, 14, 1}, {2, 13, 2}, {3, 12, 3}, {4, 11, 4}, {5, 10, 5}, {6,9,6}, {7, 8, 7} };
            Console.WriteLine(x.GetSkyline(nums));
     */
    public class Solution
    {
        private class sortAscendingHelper : IComparer<Building>
        {
            public int Compare(Building a, Building b)
            {
                if (a.Left != b.Left)
                {
                    return a.Left - b.Left;
                }
                if (a.Height != b.Height)
                {
                    return b.Height - a.Height;
                }
                return b.Right - a.Right;
            }
        }
        private class sortSetHelper : IComparer<Building>
        {
            public int Compare(Building a, Building b)
            {
                if (a.Height != b.Height)
                {
                    return b.Height - a.Height;
                }
                if (a.Left != b.Left)
                {
                    return a.Left - b.Left;
                }
                return b.Right - a.Right;
            }
        }
        private class Building
        {
            private int _left, _right, _height;
            public Building(int l, int r, int h)
            {
                _left = l;
                _right = r;
                _height = h;
            }

            public int Left
            {
                get
                {
                    return _left;
                }
            }
            public int Right
            {
                get
                {
                    return _right;
                }
            }
            public int Height
            {
                get
                {
                    return _height;
                }
            }

        }
        public IList<int[]> GetSkyline(int[,] buildings)
        {
            List<int[]> ans = new List<int[]>();
            if (buildings.Length > 0)
            {
                SortedSet<Building> s = new SortedSet<Building>(new sortAscendingHelper());
                SortedSet<Building> stack = new SortedSet<Building>(new sortSetHelper());
                stack.Add(new Building(0, 0, 0));
                for (int i = 0; i < buildings.GetLength(0); ++i)
                {
                    s.Add(new Building(buildings[i, 0], buildings[i, 1], buildings[i, 2]));
                }
                Building cur = new Building(0, 0, 0);
                while (s.Count > 0)
                {
                    Building b = s.Min;
                    s.Remove(b);
                    if (b.Right > cur.Right&&b.Left<cur.Right)
                    {
                        s.Add(new Building(cur.Right, b.Right, b.Height));
                    }
                    if (b.Height > cur.Height || b.Left > cur.Right || (b.Left == cur.Right && b.Height != cur.Height))
                    {
                        if (ans.Count > 0 && b.Left > cur.Right)
                        {
                            while (stack.Min.Right > 0 && stack.Min.Right <= cur.Right)
                            {
                                stack.Remove(stack.Min);
                            }
                            ans.Add(new int[] { cur.Right, stack.Min.Height });
                            cur = new Building(cur.Right, stack.Min.Right, stack.Min.Height);
                            if (cur.Right > 0)
                            {
                                s.Add(b);
                                continue;
                            }
                        }
                        while (stack.Min.Right > 0 && stack.Min.Right < b.Left)
                        {
                            stack.Remove(stack.Min);
                        }
                        if (stack.Min.Right == 0 || b.Left == stack.Min.Right || stack.Min.Height <= b.Height)
                        {
                            stack.Add(cur);
                            cur = b;
                            ans.Add(new int[] { cur.Left, cur.Height });
                        }
                        else
                        {
                            cur = new Building(b.Left, stack.Min.Right, stack.Min.Height);
                            ans.Add(new int[] { cur.Left, cur.Height });
                            s.Add(b);
                        }
                    }
                    else if (b.Height == cur.Height)
                    {
                        cur = new Building(cur.Left, Math.Max(cur.Right, b.Right), cur.Height);
                    }
                }
                while (cur.Right > 0)
                {
                    while (stack.Min.Right > 0 && stack.Min.Right <= cur.Right)
                    {
                        stack.Remove(stack.Min);
                    }
                    ans.Add(new int[] { cur.Right, stack.Min.Height });
                    cur = new Building(cur.Right, stack.Min.Right, stack.Min.Height);
                }
            }
            return ans;
        }
    }
}