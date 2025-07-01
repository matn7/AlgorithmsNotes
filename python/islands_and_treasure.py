class Solution:
    # O(n * m) time | O(n * m) space
    def islandsAndTreasure(self, grid):
        gates = []

        for r in range(len(grid)):
            for c in range(len(grid[r])):
                if grid[r][c] == 0:
                    gates.append([r,c])
        
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        while gates:
            position = gates.pop()
            row = position[0]
            col = position[1]
            cost = grid[row][col]

            for dir in directions:
                newRow = row + dir[0]
                newCol = col + dir[1]

                if self.isValidPos(grid, newRow, newCol) and grid[newRow][newCol] != -1 and cost + 1 < grid[newRow][newCol]:
                    grid[newRow][newCol] = cost + 1
                    gates.append([newRow, newCol])
    
    def isValidPos(self, grid, row, col):
        return row >= 0 and row <= len(grid) - 1 and col >= 0 and col <= len(grid[row]) - 1


grid = [
  [2147483647,-1,0,2147483647],
  [2147483647,2147483647,2147483647,-1],
  [2147483647,-1,2147483647,-1],
  [0,-1,2147483647,2147483647]
]

solution = Solution()
solution.islandsAndTreasure(grid)

for r in range(len(grid)):
    vals = []
    for c in range(len(grid[r])):
        vals.append(grid[r][c])
    print(vals)

        