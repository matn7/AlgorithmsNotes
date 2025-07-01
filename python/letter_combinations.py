class Solution(object):
    # O(n * 4^n) time | O(n) space
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        keymap = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "qprs",
            "8": "tuv",
            "9": "wxyz",
        }
        res = []

        def backtrack(i, part):
            if i == len(digits):
                res.append(part)
                return
            
            curr = digits[i]
            for c in keymap[curr]:
                backtrack(i + 1, part + c)

        if digits:
            backtrack(0, "")

        return res
    
solution = Solution()
print(solution.letterCombinations("23"))    
