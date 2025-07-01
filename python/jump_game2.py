class Solution(object):
    # O(n) time | O(1) space
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0
        
        jumps = 1
        maxReach = 0
        reach = nums[0]

        for i in range(1, len(nums) - 1):
            maxReach = max(maxReach, i + nums[i])
            reach -= 1

            if reach == 0:
                jumps += 1
                reach = maxReach - i

        return jumps
    

solution = Solution()
nums = [2,3,1,1,4]

print(solution.jump(nums))
