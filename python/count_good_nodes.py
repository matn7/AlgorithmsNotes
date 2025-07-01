class Solution(object):
    # O(n) time | O(n) space
    def goodNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def dfs(node, pathMax):
            if not node:
                return 0
            count = 0
            if node.val >= pathMax:
                count += 1
            pathMax = max(pathMax, node.val)
            return count + dfs(node.left, pathMax) + dfs(node.right, pathMax)

        return dfs(root, float("-infinity"))


class TreeNode(object):
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        result = str(self.val)
        result += str(self.left) if self.left else ''
        result += str(self.right) if self.right else ''
        return result
    

root = TreeNode(3)
root.left = TreeNode(1)
root.right = TreeNode(4)
root.left.left = TreeNode(3)
root.right.left = TreeNode(1)
root.right.right = TreeNode(5)

solution = Solution()
print(solution.goodNodes(root))

