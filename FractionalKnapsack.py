def fractional_knapsack(capacity, items):
    items.sort(key=lambda x: x[1]/x[0], reverse=True)

    total_value = 0

    for weight, value in items:
        if capacity >= weight:
            capacity -= weight
            total_value += value
        else:
            total_value += value * (capacity/weight)
            break

    return total_value


items = [(10, 60), (20, 100), (30, 120)]
capacity = 50

print("Maximum value:", fractional_knapsack(capacity, items))