class Trie(object):

    # O(n) time | O(t) space
    root = None
    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word):
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
        

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        curr = self.root
        for i, c in enumerate(word):
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return True if curr.word else False
        

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        curr = self.root
        for i, c in enumerate(prefix):
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return True
        
class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.word = False

trie = Trie()
trie.insert("apple")
print(trie.search("apple"))
print(trie.search("app"))
print(trie.startsWith("app"))
trie.insert("app")
print(trie.search("app"))        