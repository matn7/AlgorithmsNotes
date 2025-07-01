class WordDictionary(object):

    root = None
    def __init__(self):
        self.root = TrieNode()
        
    # O(n) time | O(t + n) space
    def addWord(self, word):
        """
        :type word: str
        :rtype: None
        """
        curr = self.root
        for i, c in enumerate(word):
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.word = True
        

    # O(n) time | O(t + n) space
    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        curr = self.root
        return self.helper(word, 0, curr)

    def helper(self, word, j, curr):
        for i in range(j, len(word)):
            c = word[i]
            if c == '.':
                elems = curr.children
                for v in elems.values():
                    if self.helper(word, i + 1, v):
                        return True
                return False
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return curr.word
        
class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.word = False


solution = WordDictionary()
solution.addWord("bad")
solution.addWord("dad")
solution.addWord("mad")
print(solution.search("pad"))
print(solution.search("bad"))
print(solution.search(".ad"))
print(solution.search("b.."))

