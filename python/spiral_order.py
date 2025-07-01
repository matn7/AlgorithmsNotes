class Solution(object):
    # O(n * m) time | O(n * m) space
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        res = []
        top = 0
        bottom = len(matrix) - 1
        left = 0
        right = len(matrix[0]) - 1

        while top <= bottom and left <= right:
            for i in range(left, right + 1):
                res.append(matrix[top][i])

            for i in range(top + 1, bottom + 1):
                res.append(matrix[i][right])
            
            for i in range(right - 1, left - 1, -1):
                if top == bottom:
                    break
                res.append(matrix[bottom][i])
            
            for i in range(bottom - 1, top, -1):
                if left == right:
                    break
                res.append(matrix[i][left])
            top += 1
            bottom -= 1
            left += 1
            right -= 1
        return res

solution = Solution()
matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
print(solution.spiralOrder(matrix))