package go581ShortestUnsortedContinuousSubarray_Medium

import (
	"math"
)
type Stack struct{ vec []int }

func (s Stack) Empty() bool { return len(s.vec) == 0 }
func (s Stack) Peek() int   { return s.vec[len(s.vec)-1] }
func (s Stack) Len() int    { return len(s.vec) }
func (s *Stack) Push(i int)  { s.vec = append(s.vec, i) }
func (s *Stack) Pop() int {
  d := s.vec[len(s.vec)-1]
  s.vec = s.vec[:len(s.vec)-1]
  return d
}

func findUnsortedSubarray(nums []int) int {
	var l int = len(nums)-1
	var r int = 0
	stack := new(Stack)
	//stack.Push( -int(^uint(0) >> 1)  - 1 )

	for i:=0; i < len(nums); i+=1 {
		for stack.Len()> 0 && nums[stack.Peek()] > nums[i] {
			l = int(math.Min(float64(l),float64(stack.Pop())))
		}
		stack.Push(i)
	}
	stack.Empty()

	for i:= len(nums)-1; i >=0; i-=1 {
		for stack.Len()> 0 && nums[stack.Peek()] < nums[i] {
			r = int(math.Max(float64(r),float64(stack.Pop())))
		}
		stack.Push(i)
	}

	if(r<=l){
		return 0
	}
	return r-l+1
}