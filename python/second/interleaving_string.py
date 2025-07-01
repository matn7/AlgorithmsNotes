class Solution(object):
    # O(n * m) time | O(n * m) space
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if len(s1) + len(s2) != len(s3):
            return False
        
        dp = {}

        def dfs(i, j):
            if i + j == len(s3):
                return True
            if (i, j) in dp:
                return dp[(i, j)]
            k = i + j
            res = False
            if i < len(s1) and s1[i] == s3[k]:
                res = dfs(i + 1, j)
                if res:
                    return True
            if not res and j < len(s2) and s2[j] == s3[k]:
                res = dfs(i, j + 1)
            dp[(i, j)] = res
            return res

        return dfs(0, 0)
    

solution = Solution()
s1 = "aabcc"
s2 = "dbbca"
s3 = "aadbbcbcac"
print(solution.isInterleave(s1, s2, s3))
