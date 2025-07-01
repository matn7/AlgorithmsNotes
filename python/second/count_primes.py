class Solution(object):
    # O(n * log(log(n))) time | O(n) space
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2:
            return 0
        sieve = self.getPrimes(n)
        count = 0
        for i in range(n):
            if sieve[i]:
                count += 1

        return count
    
    def getPrimes(self, n):
        sieve = [ True ] * n
        sieve[0] = False
        sieve[1] = False

        for i in range(2, n):
            if sieve[i]:
                for j in range(i * 2, n, i):
                    sieve[j] = False
        
        return sieve
    
solution = Solution()
print(solution.countPrimes(10))