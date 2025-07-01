class Solution(object):
    # O(n * m) time | O(n * m) space
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        dp = [ [-1] * (len(matrix[0]) + 1) for _ in range(len(matrix) + 1) ]

        def dfs(r, c, prev):
            if r < 0 or r >= len(matrix) or c < 0 or c >= len(matrix[r]) or matrix[r][c] <= prev:
                return 0
            if dp[r][c] != -1:
                return dp[r][c]
            res = 1
            curr = matrix[r][c]

            for dir in directions:
                res = max(res, 1 + dfs(r + dir[0], c + dir[1], curr))
            dp[r][c] = res
            return res
            

        maxPath = 1
        for r in range(len(matrix)):
            for c in range(len(matrix[r])):
                maxPath = max(maxPath, dfs(r, c, -1))

        return maxPath
    

solution = Solution()
matrix = [[9,9,4],[6,6,8],[2,1,1]]
print(solution.longestIncreasingPath(matrix))