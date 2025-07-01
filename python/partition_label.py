class Solution(object):
    # O(n) time | O(m) space -> O(1) space
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        lastSeen = {}
        for i in range(len(s)):
            lastSeen[s[i]] = i
        
        count = 0
        res = []
        end = 0
        for i in range(len(s)):
            count += 1
            end = max(end, lastSeen[s[i]])

            if i == end:
                res.append(count)
                count = 0

        return res
        

s = "ababcbacadefegdehijhklij"

solution = Solution()
print(solution.partitionLabels(s))
