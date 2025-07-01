class Solution(object):
    # O(n) time | O(n) space
    def mergeTwoLists(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(0, None)
        curr = dummy

        def helper(list1, list2, curr):
            if not list1 and not list2:
                return
            if not list1:
                curr.next = list2
                return
            if not list2:
                curr.next = list1
                return
            if list1.val <= list2.val:
                curr.next = list1
                list1 = list1.next
            else:
                curr.next = list2
                list2 = list2.next

            curr = curr.next
            helper(list1, list2, curr)
            
        helper(list1, list2, curr)

        return dummy.next


    # O(n) time | O(1) space
    def mergeTwoListsIter(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(0, None)
        curr = dummy

        while list1 and list2:
            if list1.val <= list2.val:
                curr.next = list1
                list1 = list1.next
            else:
                curr.next = list2
                list2 = list2.next
            curr = curr.next
        
        if list1:
            curr.next = list1
        if list2:
            curr.next = list2

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


list1 = ListNode(1, ListNode(2, ListNode(3, None)))
list2 = ListNode(1, ListNode(3, ListNode(4, None)))

solution = Solution()
print(solution.mergeTwoLists(list1, list2))