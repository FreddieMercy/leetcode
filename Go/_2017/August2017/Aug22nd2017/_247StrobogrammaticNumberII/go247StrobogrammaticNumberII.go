package go247StrobogrammaticNumberII

//"strconv"

func FindStrobogrammatic(n int) []string { //func findStrobogrammatic(n int) []string {
	ans := []string{""}
	if n%2 == 1 {
		ans = []string{"0", "1", "8"}
	}
	for i := n%2 + 2; i <= n; i += 2 {
		var tmp []string
		for _, j := range ans {
			if i != n {
				tmp = append(tmp, []string{"0" + j + "0", "1" + j + "1", "8" + j + "8", "9" + j + "6", "6" + j + "9"}...)
			} else {
				tmp = append(tmp, []string{"1" + j + "1", "8" + j + "8", "9" + j + "6", "6" + j + "9"}...)
			}

		}
		ans = tmp
	}
	return ans
}
