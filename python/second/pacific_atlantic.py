class Solution(object):
    # O(n) time | O(n) space
    def pacificAtlantic(self, heights):
        """
        :type heights: List[List[int]]
        :rtype: List[List[int]]
        """

        def dfs(r, c, ocean, prev):
            if r < 0 or r >= len(heights) or c < 0 or c >= len(heights[r]) or (r,c) in ocean or prev > heights[r][c]:
                return
            ocean.add((r,c))
            curr = heights[r][c]
            dfs(r + 1, c, ocean, curr)
            dfs(r - 1, c, ocean, curr)
            dfs(r, c + 1, ocean, curr)
            dfs(r, c - 1, ocean, curr)

        res = []
        pacific = set()
        atlantic = set()

        for r in range(len(heights)):
            dfs(r, 0, pacific, -1)
            dfs(r, len(heights[r]) - 1, atlantic, -1)
        
        for c in range(len(heights[r])):
            dfs(0, c, pacific, -1)
            dfs(len(heights) - 1, c, atlantic, -1)

        for r in range(len(heights)):
            for c in range(len(heights[r])):
                if (r,c) in pacific and (r,c) in atlantic:
                    res.append([r,c]) 

        return res
    

heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]

solution = Solution()
print(solution.pacificAtlantic(heights))
