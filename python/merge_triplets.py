class Solution(object):
    # O(n) time | O(1) space
    def mergeTriplets(self, triplets, target):
        """
        :type triplets: List[List[int]]
        :type target: List[int]
        :rtype: bool
        """
        res = [False] * 3

        for triplet in triplets:
            if triplet[0] > target[0] or triplet[1] > target[1] or triplet[2] > target[2]:
                continue

            res[0] = res[0] or triplet[0] == target[0]
            res[1] = res[1] or triplet[1] == target[1]
            res[2] = res[2] or triplet[2] == target[2]

        return res[0] and res[1] and res[2]
    
solution = Solution()
triplets = [[2,5,3],[1,8,4],[1,7,5]]
target = [2,7,5]
print(solution.mergeTriplets(triplets, target))
