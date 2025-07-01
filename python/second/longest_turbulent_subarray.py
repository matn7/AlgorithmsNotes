class Solution(object):
    # O(n) time | O(1) space
    def maxTurbulenceSize(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        l = 0
        r = 1
        res = 1
        prev = ""

        while r < len(arr):
            if arr[r] > arr[r - 1] and not ">" == prev:
                res = max(res, r - l + 1)
                r += 1
                prev = ">"
            elif arr[r] < arr[r - 1] and not "<" == prev:
                res = max(res, r - l + 1)
                r += 1
                prev = "<"
            else:
                r = r + 1 if arr[r] == arr[r - 1] else r
                l = r - 1
                prev = ""

        return res
    
solution = Solution()
arr = [9,4,2,10,7,8,8,1,9]

print(solution.maxTurbulenceSize(arr))

