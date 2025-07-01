class Solution(object):
    # O(n) time | O(n) space
    def diameterOfBinaryTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        res = [0]

        def helper(node):

            if not node:
                return 0
            
            left = helper(node.left)
            right = helper(node.right)
            res[0] = max(res[0], left + right)

            return 1 + max(left, right)

        helper(root)
            
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

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)        

solution = Solution()

print(solution.diameterOfBinaryTree(root))