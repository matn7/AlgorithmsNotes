class Solution:
    # @param n, an integer
    # @return an integer
    # O(1) time | O(1) space
    def reverseBits(self, n):
        res = 0
        for i in range(32):
            bit = (n >> i) & 1
            res += (bit << (31 - i))
        return res