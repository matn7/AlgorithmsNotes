class MyCalendar(object):

    def __init__(self):
        self.root = None        

    def book(self, startTime, endTime):
        """
        :type startTime: int
        :type endTime: int
        :rtype: bool
        """
        if not self.root:
            self.root = Node(startTime, endTime)
            return True
        
        return self.insert(self.root, startTime, endTime)
    
    def insert(self, node, start, end):
        if end <= node.start:
            if not node.left:
                node.left = Node(start, end)
                return True
            return self.insert(node.left, start, end)
        elif start >= node.end:
            if not node.right:
                node.right = Node(start, end)
                return True
            return self.insert(node.right, start, end)
        else:
            return False


class Node(object):
    def __init__(self, start, end, left = None, right = None):
        self.start = start
        self.end = end
        self.left = left
        self.right = right
