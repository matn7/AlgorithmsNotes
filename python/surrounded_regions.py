class Solution(object):
    # O(n * m) time | O(n * m) space
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        def mark(r, c):
            if r < 0 or r >= len(board) or c < 0 or c >= len(board[r]) or board[r][c] != "O":
                return
            
            board[r][c] = "Y"
            mark(r + 1, c)
            mark(r - 1, c)
            mark(r, c + 1)
            mark(r, c - 1)


        for r in range(len(board)):
            for c in range(len(board[r])):
                if self.isOnBorder(board, r, c) and board[r][c] == "O":
                    mark(r, c)
                    
        for r in range(len(board)):
            for c in range(len(board[r])):
                if board[r][c] == "O":
                    board[r][c] = "X"
                elif board[r][c] == "Y":
                    board[r][c] = "O"
    
    def isOnBorder(self, board, r, c):
        return r == 0 or c == 0 or r == len(board) - 1 or c == len(board[r]) - 1
        
board = [
    ["X","X","X","X"],
    ["X","O","O","X"],
    ["X","X","O","X"],
    ["X","O","X","X"]
]        

solution = Solution()
solution.solve(board)

for r in range(len(board)):
    row = []
    for c in range(len(board[r])):
        row += board[r][c]
    print(row)