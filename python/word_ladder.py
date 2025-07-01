class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList:
            return 0
        
        adj = {}
        wordList.append(beginWord)

        for word in wordList:
            for j in range(len(word)):
                pat = word[0:j] + "*" + word[j + 1:]
                if not pat in adj:
                    adj[pat] = []
                adj[pat].append(word)
        
        visited = set()
        queue = []
        queue.append(beginWord)
        res = 1

        while queue:
            size = len(queue)
            for i in range(size):
                word = queue.pop(0)
                if word == endWord:
                    return res
                
                for j in range(len(word)):
                    pat = word[0:j] + "*" + word[j + 1:]
                    neighbors = adj[pat]
                    for nei in neighbors:
                        if not nei in visited:
                            visited.add(nei)
                            queue.append(nei)

            res += 1

        return 0

solution = Solution()
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]

print(solution.ladderLength(beginWord, endWord, wordList))
