class Solution(object):
    # O(n * k) time | O(n) space
    def findCheapestPrice(self, n, flights, src, dst, k):
        """
        :type n: int
        :type flights: List[List[int]]
        :type src: int
        :type dst: int
        :type k: int
        :rtype: int
        """
        dp = [ float("infinity") ] * n
        dp[src] = 0

        for i in range(k + 1):
            newDp = dp[::]
            for flight in flights:
                s = flight[0]
                d = flight[1]
                c = flight[2]

                if dp[s] == float("infinity"):
                    continue

                if dp[s] + c < dp[d]:
                    newDp[d] = min(newDp[d], dp[s] + c)
            dp = newDp

        return dp[dst] if dp[dst] != float("infinity") else -1
    

solution = Solution()

n = 3
flights = [[0,1,100],[1,2,100],[0,2,500]]
src = 0
dst = 2
k = 1

print(solution.findCheapestPrice(n, flights, src, dst, k))
