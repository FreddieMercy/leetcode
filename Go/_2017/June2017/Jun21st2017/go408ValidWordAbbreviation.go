package go408ValidWordAbbreviation

import (
	"strconv"
)

func ValidWordAbbreviation(word string, abbr string) bool {

	//func validWordAbbreviation(word string, abbr string) bool {

	var table = [10]string{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
	var i, j = 0, 0
	for i < len(word) && j < len(abbr) {
		if word[i] == abbr[j] {
			i += 1
			j += 1
			continue
		}
		found := false
		for _, b := range table {
			if b == string(abbr[j]) {
				found = true
			}
		}

		if !found {
			return false
		}

		nums := "" //string(abbr[j])
		for j < len(abbr) && found {
			if nums != "" || string(abbr[j]) != "0" {
				nums += string(abbr[j])
			} else {
				return false //IDK why it can't be. Just for passing the Test case 
			}
			j += 1
			found = false
			if j < len(abbr) {
				for _, b := range table {
					if b == string(abbr[j]) {
						found = true
					}
				}
			}
		}
		tmp, e := strconv.Atoi(nums)
		if e != nil {
			return false
		}
		i += tmp
	}

	return i == len(word) && j == len(abbr)
}
