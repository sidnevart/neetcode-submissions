func hasDuplicate(nums []int) bool {
    set := make(map[int]bool)
    for _, i := range nums {
        if _, ok := set[i]; ok {
            return true
        } 
        set[i] = true
    }
    return false   
}

