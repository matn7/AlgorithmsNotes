class Solution(object):
    # O(n) time | O(n) space
    def isBalanced(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """

        def dfs(node):
            if not node:
                return 0
            
            left = dfs(node.left)
            right = dfs(node.right)

            if left != -1 and right != -1 and abs(left - right) <= 1:
                return 1 + max(left, right)
            return -1
        
        return dfs(root) != -1
    
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
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

solution = Solution()
print(solution.isBalanced(root))


