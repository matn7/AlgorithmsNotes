class Solution(object):
    # O(n) time | O(1) space
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        dummy = ListNode(0, None)
        slow = head
        fast = head

        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        if not slow:
            return
    
        next = slow.next
        slow.next = None

        reversed = self.reverse(next)
        slow = head

        while slow and reversed:
            if not dummy.next:
                dummy.next = slow
            
            sn = slow.next
            slow.next = reversed
            rn = reversed.next
            reversed.next = sn
            slow = sn
            reversed = rn

    
    def reverse(self, node):
        prev = None
        curr = node
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

head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, None)))))
solution = Solution()
solution.reorderList(head)
print(head)
