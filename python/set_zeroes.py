class Solution(object):
    # O((n * m) * (n + m)) time | O(n * m) space
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        coord = []
        for r in range(len(matrix)):
            for c in range(len(matrix[r])):
                if matrix[r][c] == 0:
                    coord.append([r, c])
        
        while coord:
            curr = coord.pop()
            row = curr[0]
            col = curr[1]

            for c in range(len(matrix[row])):
                matrix[row][c] = 0
            
            for r in range(len(matrix)):
                matrix[r][col] = 0

matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

solution = Solution()
solution.setZeroes(matrix)

print(matrix)