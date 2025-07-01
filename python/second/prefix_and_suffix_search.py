class WordFilter(object):
    # O(n * m^3) time | O(n * m^3) space
    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.dp = {}

        for i in range(len(words)):
            w = words[i]
            for j in range(len(w)):
                pref = w[0:j + 1]
                for k in range(len(w)):
                    suff = w[k:]
                    key = str(pref) + "$" + str(suff)
                    self.dp[key] = i

        
    def f(self, pref, suff):
        """
        :type pref: str
        :type suff: str
        :rtype: int
        """
        key = str(pref) + "$" + str(suff)
        return self.dp[key] if key in self.dp else -1
        
