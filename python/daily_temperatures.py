class Solution(object):
    # O(n) time | O(n) space
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        res = [0] * len(temperatures)
        idxStack = []
        for i, temp in enumerate(temperatures):
            while len(idxStack) != 0 and temp > temperatures[idxStack[-1]]:
                idx = idxStack.pop()
                res[idx] = i - idx
            idxStack.append(i)
        
        return res
    
solution = Solution()
print(solution.dailyTemperatures([73,74,75,71,69,72,76,73]))
