import math
class Solution(object):
    # O(k * sqrt(M)) time | O(M / log(M)) space
    def distinctPrimeFactors(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        primes = set()

        for num in nums:
            while num % 2 == 0:
                primes.add(2)
                num = num // 2
            
            for i in range(3, int(math.sqrt(num)) + 1):
                while num % i == 0:
                    primes.add(i)
                    num = num // i
                
            if num != 1:
                primes.add(num)

        return len(primes)
    

solution = Solution()
#nums = [2,4,3,7,10,6]
nums = [30]
print(solution.distinctPrimeFactors(nums))
