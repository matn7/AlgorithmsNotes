import heapq

class Solution(object):
    # O(E * log(V)) time | O(V + E) space
    def swimInWater(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid) - 1
        cols = len(grid[0]) - 1
        cost = grid[rows][cols]

        minHeap = [(cost, rows, cols)]

        maxInPath = grid[rows][cols]

        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        while minHeap:
            current = heapq.heappop(minHeap)
            cost1 = current[0]
            r1 = current[1]
            c1 = current[2]
            maxInPath = max(maxInPath, cost1)
            if r1 == 0 and c1 == 0:
                break

            if grid[r1][c1] == -1:
                continue

            grid[r1][c1] = -1
            for dir in directions:
                r2 = r1 + dir[0]
                c2 = c1 + dir[1]

                if self.isValidPos(grid, r2, c2) and grid[r2][c2] != -1:
                    cost2 = grid[r2][c2]
                    heapq.heappush(minHeap, (cost2, r2, c2))
        
        return maxInPath

    def isValidPos(self, grid, r, c):
        return r >= 0 and r <= len(grid) - 1 and c >= 0 and c <= len(grid[r]) - 1


solution = Solution()
grid = [
    [0,1,2,3,4],
    [24,23,22,21,5],
    [12,13,14,15,16],
    [11,17,18,19,20],
    [10,9,8,7,6]
]
print(solution.swimInWater(grid))
