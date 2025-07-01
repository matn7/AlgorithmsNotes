class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        root = TrieNode()
        self.populate(root, words)

        res = set()
        visited = set()

        def helper(r, c, word, curr):
            if (r < 0 or r >= len(board) or c < 0 or c >= len(board[r]) or 
                (r,c) in visited or board[r][c] not in curr.children):
                return
            
            w = board[r][c]
            visited.add((r,c))
            curr = curr.children[w]
            word += w
            if curr.word:
                res.add(word)

            helper(r + 1, c, word, curr)
            helper(r - 1, c, word, curr)
            helper(r, c + 1, word, curr)
            helper(r, c - 1, word, curr)
            visited.remove((r,c))

        for r in range(len(board)):
            for c in range(len(board[r])):
                helper(r, c, "", root)

        return list(res)
    
    def populate(self, root, words):
        for word in words:
            curr = root
            for c in word:
                if c not in curr.children:
                    curr.children[c] = TrieNode()
                curr = curr.children[c]
            curr.word = True

class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.word = False

solution = Solution()
board = [
    ['o', 'a', 'a', 'n'],
    ['e', 't', 'a', 'e'],
    ['i', 'h', 'k', 'r'],
    ['i', 'f', 'l', 'v']
]
words = ["oath","pea","eat","rain"]

print(solution.findWords(board, words))