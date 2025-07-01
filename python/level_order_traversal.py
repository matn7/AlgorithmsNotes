from collections import deque
class Solution(object):
    # O(n) time | O(n) space
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        if not root:
            return []
        res = []
        q = deque()
        q.append(root)

        while q:
            level = []
            size = len(q)
            for i in range(size):
                pop = q.popleft()
                level.append(pop.val)
                    
                if pop.left:
                    q.append(pop.left)
                    
                if pop.right:
                    q.append(pop.right)

            res.append(level)
        return res
        

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
print(solution.levelOrder(root))
