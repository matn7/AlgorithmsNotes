class NumMatrix(object):

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        ROWS = len(matrix)
        COLS = len(matrix[0])
        self.sumMat =  [ [0] * (COLS + 1) for _ in range(ROWS + 1) ]

        for r in range(ROWS):
            prefix = 0
            for c in range(COLS):
                above = self.sumMat[r][c + 1]
                prefix += matrix[r][c]
                self.sumMat[r + 1][c + 1] = prefix + above


    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        row1 += 1
        col1 += 1
        row2 += 1
        col2 += 1
        bottomRight = self.sumMat[row2][col2]
        above = self.sumMat[row1 - 1][col2]
        left = self.sumMat[row2][col1 - 1]
        topLeft = self.sumMat[row1 - 1][col1 - 1]
        return bottomRight - above - left + topLeft
        