class Solution(object):
    # O(n) time | O(n) space
    def goodNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        
        return self.helper(root, float("-infinity"))

    def helper(self, node, prev):
        if not node:
            return 0
        prev = max(prev, node.val)
        left = self.helper(node.left, prev)
        right = self.helper(node.right, prev)
        res = 0
        if node.val >= prev:
            res += 1
        return res + left + right
