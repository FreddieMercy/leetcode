package _448FindAllNumbersDisappearedinanArray

func findDisappearedNumbers(nums []int) []int {
    return FindDisappearedNumbers(nums)
}

func FindDisappearedNumbers(a []int) []int {
    for i := range a {
        for a[a[i]-1] != a[i] {
            a[a[i]-1], a[i] = a[i], a[a[i]-1]
        }
    }
    
    out := []int{}
    for i, v := range a {
        if v != i+1 {
            out = append(out, i+1)
        }
    }
    return out
}