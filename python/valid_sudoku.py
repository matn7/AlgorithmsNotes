class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for row in range(9):
            rows = set()
            for c in range(9):
                if board[row][c] == '.':
                    continue
                if board[row][c] in rows:
                    return False
                rows.add(board[row][c])
        
        for col in range(9):
            cols = set()
            for r in range(9):
                if board[r][col] == '.':
                    continue
                if board[r][col] in cols:
                    return False
                cols.add(board[r][col])

        for row in range(3):
            for col in range(3):
                grid = set()
                for r in range(row * 3, row * 3 + 3, 1):
                    for c in range(col * 3, col * 3 + 3, 1):
                        if board[r][c] == '.':
                            continue
                        if board[r][c] in grid:
                            return False
                        grid.add(board[r][c])
        return True

solution = Solution()
board = [
    ['5', '3', '.', '.', '7', '.', '.', '.', '.'],
    ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
    ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
    ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
    ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
    ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
    ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
    ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
    ['.', '.', '.', '.', '8', '.', '.', '7', '9']
]

print(solution.isValidSudoku(board))