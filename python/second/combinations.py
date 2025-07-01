class Solution(object):
    # O(n * 2^n) time | O(n) space
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        result = []
        part = []

        def backtrack(s):
            if len(part) == k:
                result.append(part[::])
                return
            
            for i in range(s, n + 1):
                part.append(i)
                backtrack(i + 1)
                part.pop()
        
        backtrack(1)

        return result
    
solution = Solution()
print(solution.combine(4, 2))