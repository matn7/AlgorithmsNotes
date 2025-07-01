class Solution(object):
    # O(n * m) time | O(n * m) space
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rotten = []
        freshFruit = 0

        for r in range(len(grid)):
            for c in range(len(grid[r])):
                if grid[r][c] == 2:
                    rotten.append([r, c])
                if grid[r][c] == 1:
                    freshFruit += 1
        
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        res = 0
        while rotten:
            size = len(rotten)
            rotted = False

            for i in range(size):
                position = rotten.pop(0)
                row = position[0]
                col = position[1]

                for dir in directions:
                    newRow = row + dir[0]
                    newCol = col + dir[1]
                    if self.isValidPos(grid, newRow, newCol) and grid[newRow][newCol] == 1:
                        rotted = True
                        grid[newRow][newCol] = 2
                        freshFruit -= 1
                        rotten.append([newRow, newCol])

            if rotted:
                res += 1
        
        return res if freshFruit == 0 else -1
    
    def isValidPos(self, grid, row, col):
        return row >= 0 and row <= len(grid) - 1 and col >= 0 and col <= len(grid[row]) - 1


#grid = [[2,1,1],[1,1,0],[0,1,1]]
# grid = [[2,1,1],[0,1,1],[1,0,1]]
grid = [[0,2]]
solution = Solution()
print(solution.orangesRotting(grid))