class Solution(object):
    # O(n) time | O(n) space
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """

        def dfs(node, min, max):
            if not node:
                return True
            
            left = dfs(node.left, min, node.val)
            right = dfs(node.right, node.val, max)

            return left and right and min < node.val and max > node.val
        
        return dfs(root, float("-infinity"), float("infinity"))

        
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

root = TreeNode(5)
root.left = TreeNode(1)
root.right = TreeNode(7)
root.right.left = TreeNode(6)
root.right.right = TreeNode(8)

solution = Solution()
print(solution.isValidBST(root))

