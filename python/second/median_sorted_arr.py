class Solution(object):
    # O(log(min(n, m))) time | O(1) space
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        A = nums1
        B = nums2

        if (len(B) < len(A)):
            B, A = A, B

        total = len(A) + len(B)
        half = (total + 1) // 2

        L = 0
        R = len(A)

        while L <= R:
            i = (L + R) // 2
            j = half - i

            aLeft = A[i - 1] if i > 0 else float("-infinity")
            aRight = A[i] if i < len(A) else float("infinity")
            bLeft = B[j - 1] if j > 0 else float("-infinity")
            bRight = B[j] if j < len(B) else float("infinity")

            if aLeft <= bRight and bLeft <= aRight:
                if total % 2 != 0:
                    return max(aLeft, bLeft)
                return (max(aLeft, bLeft) + min(aRight, bRight)) / 2
            elif aLeft > bRight:
                R = i - 1
            else:
                L = i + 1
        return -1

solution = Solution()
# nums1 = [1,3]
# nums2 = [2]
nums1 = [1,2]
nums2 = [3,4]
print(solution.findMedianSortedArrays(nums1, nums2))