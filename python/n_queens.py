class Solution(object):
    # O(n!) time | O(n^2) space
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        cols = set()
        posDiag = set()
        negDiag = set()
        res = []
        board = [ ["."] * n for r in range(n) ]

        def backtrack(r):
            if r == n:
                part = ["".join(row) for row in board]
                res.append(part)
                return
            
            for c in range(n):
                if c in cols or (r + c) in posDiag or (r - c) in negDiag:
                    continue
                cols.add(c)
                posDiag.add(r + c)
                negDiag.add(r - c)
                board[r][c] = "Q"

                backtrack(r + 1)

                board[r][c] = "."
                cols.remove(c)
                posDiag.remove(r + c)
                negDiag.remove(r - c)

        backtrack(0)

        return res

solution = Solution()
print(solution.solveNQueens(4))