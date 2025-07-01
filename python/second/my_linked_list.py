class MyLinkedList(object):

    def __init__(self):
        self.array = []

    def get(self, index):
        """
        :type index: int
        :rtype: int
        """
        if len(self.array) <= index:
            return -1
        return self.array[index]
        

    def addAtHead(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.array.insert(0, val)
        

    def addAtTail(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.array.append(val)
        

    def addAtIndex(self, index, val):
        """
        :type index: int
        :type val: int
        :rtype: None
        """
        if len(self.array) < index:
            return
        self.array.insert(index, val)
        

    def deleteAtIndex(self, index):
        """
        :type index: int
        :rtype: None
        """
        if len(self.array) <= index:
            return
        self.array.pop(index)
        
