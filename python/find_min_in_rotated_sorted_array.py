class Solution(object):
    # O(log(n)) time | O(1) space
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        L = 0
        R = len(nums) - 1
        res = nums[0]

        while L <= R:
            if nums[L] < nums[R]:
                res = min(res, nums[L])
                break

            M = L + (R - L) // 2
            res = min(res, nums[M])
            if nums[M] >= nums[R]:
                L = M + 1
            else:
                R = M - 1

        return res

    
solution = Solution()
print(solution.findMin([3,4,5,1,2]))