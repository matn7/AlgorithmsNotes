class Solution(object):
    # O(n) time | O(1) space
    def removeNthFromEnd(self, head, n):
        """
        :type head: Optional[ListNode]
        :type n: int
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(0, None)
        dummy.next = head
        slow = dummy
        fast = head
        for i in range(n):
            fast = fast.next
        
        if not fast:
            return head.next
        
        while slow and fast:
            slow = slow.next
            fast = fast.next
        
        slow.next = slow.next.next
        return dummy.next

class ListNode(object):
    def __init__(self, val, next):
        self.val = val
        self.next = next
    
    def __repr__(self) -> str:
        res = str(self.val)
        if self.next:
            res += str(self.next)
        return res
    
head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, None)))))

solution = Solution()
print(solution.removeNthFromEnd(head, 5))
