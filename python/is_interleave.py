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
        
        dp = [ [ None ] * (len(s1) + 1) for _ in range(len(s2) + 1)  ]

        def dfs(i, j):
            if i + j == len(s3):
                
                return True
            if dp[i][j]:
                return dp[i][j]
            
            k = i + j
            found = False
            if i < len(s1) and s1[i] == s3[k]:
                found = dfs(i + 1, j)
                if found:
                    return True
                
            if j < len(s2) and s2[j] == s3[k]:
                found = dfs(i, j + 1)
            
            dp[i][j] = found
            return found

        return dfs(0, 0)
    

solution = Solution()
s1 = "aabcc"
s2 = "dbbca"
s3 = "aadbbcbcac"
print(solution.isInterleave(s1, s2, s3))
