class Solution(object):
    # O(n + m) time | O(1) space
    def mergeTwoLists(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        pass
        dummy = ListNode(0)
        curr = dummy

        while list1 and list2:
            if list1.val <= list2.val:
                curr.next = list1
                list1 = list1.next
            else:
                curr.next = list2
                list2 = list2.next
            curr = curr.next
        
        if not list1:
            curr.next = list2
        if not list2:
            curr.next = list1
        return dummy.next

        
class ListNode(object):
    def __init__(self, val, next = None):
        self.val = val
        self.next = next
    
    def __repr__(self) -> str:
        res = str(self.val)
        if self.next:
            res += str(self.next)
        return res


solution = Solution()
list1 = ListNode(1, ListNode(2, ListNode(4, None)))
list2 = ListNode(1, ListNode(3, ListNode(4, None)))

print(solution.mergeTwoLists(list1, list2))
