import random

# # Create a 5x5 2D list with random integers between 0 and 100
# matrix = [[random.randint(0, 100) for _ in range(5)] for _ in range(5)]
matrix = [
    [1, 2, 3, 4, 5],
    [6, 7, 8, 9, 10],
    [11, 12, 13, 14, 15],
    [16, 17, 18, 19, 20],
    [21, 22, 23, 24, 25]
]

# Print the 2D list
for row in matrix:
    print(row)