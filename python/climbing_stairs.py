class Solution(object):
    # O(n) time | O(1) space
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        prev = 1
        prevprev = 1
        if n == 0:
            return prevprev
        if n == 1:
            return prev
        res = prev + prevprev

        for _ in range(3, n + 1):
            prevprev = prev
            prev = res
            res = prev + prevprev

        return res


    # O(n) time | O(n) space
    def climbStairs2(self, n):
        """
        :type n: int
        :rtype: int
        """
        cache = [-1] * n

        def dfs(i):
            if i > n:
                return 0
            if i == n:
                return 1
            if cache[i] != -1:
                return cache[i]
            cache[i] = dfs(i + 1) + dfs(i + 2)
            return cache[i]

        return dfs(0)
    

solution = Solution()

print(solution.climbStairs(5))
