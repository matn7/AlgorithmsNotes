class Solution(object):
    # O(n) time | O(n) space
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        posMap = {}
        for i,c in enumerate(s):
            posMap[c] = i
        
        size = 0
        end = 0
        res = []

        for i,c in enumerate(s):
            size += 1
            end = max(end, posMap[c])
            if i == end:
                res.append(size)
                size = 0
        return res
    
s = "ababcbacadefegdehijhklij"
solution = Solution()
print(solution.partitionLabels(s))