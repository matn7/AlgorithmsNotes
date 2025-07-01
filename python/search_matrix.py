class Solution(object):
    # O(log(n)) time | O(1) space
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        top = 0
        bottom = len(matrix) - 1
        cols = len(matrix[0]) - 1
        row = 0
        while top <= bottom:
            row = (top + bottom) // 2
            l = matrix[row][0]
            r = matrix[row][cols]
            if target >= l and target <= r:
                break
            elif target < r:
                bottom = row - 1
            else:
                top = row + 1

        l = 0
        r = len(matrix[row]) - 1
        while l <= r:
            m = (l + r) // 2
            if target == matrix[row][m]:
                return True
            elif target > matrix[row][m]:
                l = m + 1
            else:
                r = m - 1
        
        return False

solution = Solution()
matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]

target = 9

print(solution.searchMatrix(matrix, target))