# Iterative
def binary_search_iter(arr, x):
    low, high = 0, len(arr)-1
    while low <= high:
        mid = (low + high)//2
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            low = mid + 1
        else:
            high = mid - 1
    return -1


# Recursive
def binary_search_rec(arr, low, high, x):
    if low <= high:
        mid = (low + high)//2
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            return binary_search_rec(arr, mid+1, high, x)
        else:
            return binary_search_rec(arr, low, mid-1, x)
    return -1


arr = sorted(list(map(int, input("Enter sorted array: ").split())))
x = int(input("Enter element to search: "))

print("Iterative Index:", binary_search_iter(arr, x))
print("Recursive Index:", binary_search_rec(arr, 0, len(arr)-1, x))