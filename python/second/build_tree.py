class Solution(object):
    # O(n) time | O(n) space
    idx = 0

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if self.idx == len(preorder) or len(inorder) == 0:
            return None

        val = preorder[self.idx]
        i = 0
        while i < len(inorder) and inorder[i] != val:
            i += 1
        
        newNode = TreeNode(val)

        leftIn = inorder[0:i]
        rightIn = inorder[i + 1:]
        self.idx += 1
        newNode.left = self.buildTree(preorder, leftIn)
        newNode.right = self.buildTree(preorder, rightIn)

        return newNode


        
class TreeNode(object):
    def __init__(self, val, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right