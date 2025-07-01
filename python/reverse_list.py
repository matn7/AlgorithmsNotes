class Solution(object):

    # O(n) time | O(n) space
    def reverseList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        
        def helper(curr, prev):
            if not curr:
                return prev
            
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
            return helper(curr, prev)

        return helper(head, None)

    # O(n) time | O(1) space
    def reverseListIter(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        prev = None
        curr = head

        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        
        return prev

class ListNode(object):
    def __init__(self, val, next):
        self.val = val
        self.next = next
    
    def __repr__(self) -> str:
        res = str(self.val)
        if self.next:
            res += str(self.next)
        return res

node = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, None)))))

solution = Solution()
print(solution.reverseList(node))
