class Solution(object):
    # O(n * m) time | O(n + m) space
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1 == "0" or num2 == "0":
            return "0"
        dp = [0] * (len(num1) + len(num2))
        num1 = num1[::-1]
        num2 = num2[::-1]

        for i in range(len(num1)):
            n1 = ord(num1[i]) - ord("0")
            for j in range(len(num2)):
                n2 = ord(num2[j]) - ord("0")
                num = n1 * n2
                dp[i + j] += num % 10
                dp[i + j + 1] += num // 10 + dp[i + j] // 10
                dp[i + j] %= 10
        
        idx = len(dp) - 1
        while idx >= 0 and dp[idx] == 0:
            idx -= 1

        print(dp)

        res = ""
        while idx >= 0:
            res += str(dp[idx])
            idx -= 1

        return res


solution = Solution()
num1 = "123"
num2 = "456"
print(solution.multiply(num1, num2))

