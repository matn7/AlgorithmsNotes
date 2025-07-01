class Solution(object):
    # O(n) time | O(h) space
    def maxPathSum(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        res = [root.val]

        def dfs(node):
            if not node:
                return 0
            leftBranch = max(dfs(node.left), 0)
            rightBranch = max(dfs(node.right), 0)

            maxBranch = max(leftBranch, rightBranch)

            res[0] = max(res[0], node.val)
            res[0] = max(res[0], node.val + maxBranch)
            res[0] = max(res[0], node.val + leftBranch + rightBranch)

            return node.val + maxBranch

        dfs(root)
        return res[0]

        
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


root = TreeNode(-10)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

solution = Solution()
print(solution.maxPathSum(root))    