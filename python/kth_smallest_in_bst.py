class Solution(object):
    # O(n) time | O(n) space
    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """
        info = TreeInfo(-1, 0)

        def dfs(node):
            if not node:
                return
            dfs(node.left)
            if info.pos == k:
                return
            if info.pos < k:
                info.pos += 1
                info.val = node.val
                dfs(node.right)


        dfs(root)

        return info.val

class TreeInfo(object):
    def __init__(self, val, pos):
        self.val = val
        self.pos = pos


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
root.left = TreeNode(3)
root.right = TreeNode(6)
root.left.left = TreeNode(2)
root.left.right = TreeNode(4)
root.left.left.left = TreeNode(1)

solution = Solution()
print(solution.kthSmallest(root, 3))