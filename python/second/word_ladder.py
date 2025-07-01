class Solution(object):
    # O(m^2 * n) time | O(m^2 * n) space
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        adj = {}
        wordList.append(beginWord)

        for word in wordList:
            for i in range(len(word)):
                key = word[0:i] + "*" + word[i + 1:]
                if key not in adj:
                    adj[key] = []
                adj[key].append(word)
        
        visited = set()
        queue = []
        res = 1

        queue.append(beginWord)

        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if curr == endWord:
                    return res
                
                for j in range(len(curr)):
                    key = curr[0:j] + "*" + curr[j+1:]
                    neighbors = adj[key]
                    for nei in neighbors:
                        if nei not in visited:
                            visited.add(nei)
                            queue.append(nei)

            res += 1
        return 0

beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]

solution = Solution()
print(solution.ladderLength(beginWord, endWord, wordList))
