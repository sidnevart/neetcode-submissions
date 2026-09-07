import s "sort"

func carFleet(target int, position []int, speed []int) int {
    cars := make([][2]int, len(position))

    for i := 0; i < len(position); i++ {
        cars[i] = [2]int{position[i], speed[i]}
    }

    s.Slice(cars, func(i, j int) bool {
        return cars[i][0] > cars[j][0]
    })

    stack := []float64{}

    for _, car := range cars {
        pos := car[0]
        spd := car[1]

        time := float64(target-pos) / float64(spd)

        if len(stack) == 0 || time > stack[len(stack)-1] {
            stack = append(stack, time)
        }
    }

    return len(stack)
}