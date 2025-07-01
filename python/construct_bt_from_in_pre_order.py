class Solution(object):
    # O(n^2) time | O(n^2) space
    idx = 0
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if self.idx == len(preorder) or len(inorder) == 0:
            return None
        
        nodeVal = preorder[self.idx]
        node = TreeNode(nodeVal)
        j = 0
        for i in range(len(inorder)):
            if nodeVal == inorder[i]:
                break
            j += 1
        
        leftInorder = inorder[0:j]
        rightInorder = inorder[j+1:]
        self.idx += 1

        node.left = self.buildTree(preorder, leftInorder)
        node.right = self.buildTree(preorder, rightInorder)

        return node
        
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
    

preorder = [3, 9, 20, 15, 7]
inorder = [9, 3, 15, 20, 7]

solution = Solution()
print(solution.buildTree(preorder, inorder))

