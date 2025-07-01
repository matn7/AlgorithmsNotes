class Solution(object):
    # O(n * m) time | O(n * m) space
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        count = 0

        def sink(r, c):
            if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[r]) or grid[r][c] == "0":
                return
            grid[r][c] = "0"

            sink(r + 1, c)
            sink(r - 1, c)
            sink(r, c + 1)
            sink(r, c - 1)

        for r in range(len(grid)):
            for c in range(len(grid[r])):
                if grid[r][c] == "1":
                    count += 1
                    sink(r, c)

        return count

grid = [
  ["1","1","0","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","1","1"]
]

solution = Solution()
print(solution.numIslands(grid))