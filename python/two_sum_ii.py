class Solution(object):
    # O(n) time | O(1) space
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        i = 0
        j = len(numbers) - 1

        while i < j:
            num1 = numbers[i]
            num2 = numbers[j]

            sum = num1 + num2

            if sum > target:
                j = j - 1
            elif sum < target:
                i = i + 1
            else:
                return [i + 1, j + 1]
        
        return []
    
solution = Solution()

print(solution.twoSum([2, 7, 11, 15], 9))

