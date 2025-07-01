class Solution(object):
    # O(n) time | O(n) space
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        return self.helper(root, p, q).manager

    def helper(self, node, p, q):
        if not node:
            return TreeInfo(0, None)
        
        left = self.helper(node.left, p, q)
        right = self.helper(node.right, p, q)

        count = left.count + right.count

        if left.manager:
            return left
        
        if right.manager:
            return right
        
        if node == p:
            count += 1
        
        if node == q:
            count += 1

        if count == 2:
            return TreeInfo(count, node)
        
        return TreeInfo(count, None)        


class TreeInfo(object):
    def __init__(self, count, manager):
        self.count = count
        self.manager = manager

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
    
root = TreeNode(6)
root.left = TreeNode(2)
root.right = TreeNode(8)
root.left.left = TreeNode(0)
root.left.right = TreeNode(4)
root.right.left = TreeNode(7)
root.right.right = TreeNode(9)
root.left.right.left = TreeNode(3)
root.left.right.right = TreeNode(5)

p = root.left
q = root.right

solution = Solution()
print(solution.lowestCommonAncestor(root, p, q).val)