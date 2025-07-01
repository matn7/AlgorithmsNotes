from collections import defaultdict
class DetectSquares(object):

    def __init__(self):
        self.freqMap = defaultdict(int)
        self.points = []
        
    # O(1) time | O(1) space
    def add(self, point):
        """
        :type point: List[int]
        :rtype: None
        """
        self.freqMap[(point[0], point[1])] += 1
        self.points.append(point)
        

    # O(n) time | O(1) space
    def count(self, point):
        """
        :type point: List[int]
        :rtype: int
        """
        x = point[0]
        y = point[1]
        res = 0

        for pt in self.points:
            px = pt[0]
            py = pt[1]

            if abs(x - px) != abs(y - py) or x == px or y == py:
                continue

            res += self.freqMap[(x, py)] * self.freqMap[(px, y)]

        return res
        