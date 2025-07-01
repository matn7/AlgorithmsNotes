class Solution(object):
    # O(n * m) time | O(n * m) space
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        dp = {}
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        def dfs(r, c, prev):
            if r < 0 or r >= len(matrix) or c < 0 or c >= len(matrix[r]) or prev >= matrix[r][c]:
                return 0
            
            if (r, c) in dp:
                return dp[(r, c)]
            
            currMax = 1
            curr = matrix[r][c]

            for dir in directions:
                currMax = max(currMax, 1 + dfs(r + dir[0], c + dir[1], curr))
            
            dp[(r, c)] = currMax
            return currMax

        maxPath = 0
        for r in range(len(matrix)):
            for c in range(len(matrix[r])):
                maxPath = max(maxPath, dfs(r, c, -1))
        return maxPath
    
solution = Solution()
matrix = [[9,9,4],[6,6,8],[2,1,1]]

print(solution.longestIncreasingPath(matrix))