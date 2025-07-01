class Solution(object):
    # O(n * m) time | O(n * m) space
    def pacificAtlantic(self, heights):
        """
        :type heights: List[List[int]]
        :rtype: List[List[int]]
        """
        pacific = set()
        atlantic = set()

        def dfs(r, c, ocean, prev):
            if r < 0 or r >= len(heights) or c < 0 or c >= len(heights[r]) or (r,c) in ocean or heights[r][c] < prev:
                return
            ocean.add((r, c))
            curr = heights[r][c]
            dfs(r + 1, c, ocean, curr)
            dfs(r - 1, c, ocean, curr)
            dfs(r, c + 1, ocean, curr)
            dfs(r, c - 1, ocean, curr)
            

        for r in range(len(heights)):
            dfs(r, 0, pacific, heights[r][0])
            dfs(r, len(heights[0]) - 1, atlantic, heights[r][len(heights[0]) - 1])

        for c in range(len(heights[0])):
            dfs(0, c, pacific, heights[0][c])
            dfs(len(heights) - 1, c, atlantic, heights[len(heights) - 1][c])

        res = []
        for r in range(len(heights)):
            for c in range(len(heights[r])):
                if (r, c) in pacific and (r, c) in atlantic:
                    res.append([r,c])
        return res
    


heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
solution = Solution()

print(solution.pacificAtlantic(heights))


#ROWS, COLS = len(heights), len(heights[0])
#directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
#pac = [[False] * COLS for _ in range(ROWS)]
#atl = [[False] * COLS for _ in range(ROWS)]
