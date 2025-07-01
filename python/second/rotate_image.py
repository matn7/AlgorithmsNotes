class Solution(object):
    # O(n^2) time | O(1) space
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        l = 0
        r = len(matrix) - 1

        while l < r:
            top = l
            bottom = r

            for i in range(r - l):
                topLeft = matrix[top][l + i]
                matrix[top][l + i] = matrix[bottom - i][l]
                matrix[bottom - i][l] = matrix[bottom][r - i]
                matrix[bottom][r - i] = matrix[top + i][r]
                matrix[top + i][r] = topLeft
            l += 1
            r -= 1

matrix = [[1,2,3],[4,5,6],[7,8,9]]

solution = Solution()
solution.rotate(matrix)
print(matrix)
