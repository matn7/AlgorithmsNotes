class Solution(object):
    # O(m * 4^n) time | O(n) space
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """

        def backtrack(r, c, i):
            if i == len(word):
                return True
            
            if (r < 0 or r >= len(board) or c < 0 or c >= len(board[r]) 
                    or word[i] != board[r][c] or board[r][c] == '#'):
                return False

            curr = board[r][c]    
            board[r][c] = '#'

            res = (backtrack(r + 1, c, i + 1) or backtrack(r - 1, c, i + 1) 
                   or backtrack(r, c + 1, i + 1) or backtrack(r, c - 1, i + 1))

            board[r][c] = curr
            return res


        for r in range(len(board)):
            for c in range(len(board[r])):
                if board[r][c] == word[0]:
                    if backtrack(r, c, 0):
                        return True
        
        return False
    
solution = Solution()

board = [
    ['A', 'B', 'C', 'E'],
    ['S', 'F', 'C', 'S'],
    ['A', 'D', 'E', 'E']
]

word = "ABCCED"

print(solution.exist(board, word))    