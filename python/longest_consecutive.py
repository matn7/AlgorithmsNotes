class Solution(object):
    # O(n) time | O(n) space
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        elements = set()
        for num in nums:
            elements.add(num)
        
        seen = set()
        res = 0

        for num in nums:
            if num in seen:
                continue
            curr = 1
            seen.add(num)

            toLeft = num - 1
            while toLeft in elements:
                seen.add(toLeft)
                toLeft = toLeft - 1
                curr = curr + 1

            toRight = num + 1
            while toRight in elements:
                seen.add(toRight)
                toRight = toRight + 1
                curr = curr + 1

            res = max(res, curr)

        return res 
    
solution = Solution()

print(solution.longestConsecutive([100,4,200,1,3,2]))