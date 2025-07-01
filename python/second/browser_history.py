class BrowserHistory(object):

    def __init__(self, homepage):
        """
        :type homepage: str
        """
        self.linkedlist = ListNode(homepage)
        self.curr = self.linkedlist
        

    def visit(self, url):
        """
        :type url: str
        :rtype: None
        """
        newNode = ListNode(url)

        self.curr.next = newNode
        newNode.prev = self.curr

        self.curr = self.curr.next
        

    def back(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        while self.curr.prev != None and steps > 0:
            self.curr = self.curr.prev
            steps -= 1
        return self.curr.val
        

    def forward(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        while self.curr.next != None and steps > 0:
            self.curr = self.curr.next
            steps -= 1
        return self.curr.val
        

class ListNode(object):
    def __init__(self, val, next = None, prev = None):
        self.val = val
        self.next = next
        self.prev = prev