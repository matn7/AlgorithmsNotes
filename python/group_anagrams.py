from collections import defaultdict

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        res = defaultdict(list)

        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            res[tuple(count)].append(s)
        
        return list(res.values())
        
    # # O(n * m log(m)) time | O(n) space
    # def groupAnagrams(self, strs):
    #     """
    #     :type strs: List[str]
    #     :rtype: List[List[str]]
    #     """
    #     res = defaultdict(list)

    #     for s in strs:
    #         sort = ''.join(sorted(s))
    #         res[sort].append(s)
        
    #     return list(res.values())
    
anagrams = Solution()
print(anagrams.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
