from collections import defaultdict
class DetectSquares(object):

    def __init__(self):
        self.freq = defaultdict(int)
        self.points = []
        

    # O(1) time | O(n) space
    def add(self, point):
        """
        :type point: List[int]
        :rtype: None
        """
        self.freq[(point[0], point[1])] += 1
        self.points.append(point)
        

    # O(n) time | O(n) space
    def count(self, point):
        """
        :type point: List[int]
        :rtype: int
        """
        res = 0
        x = point[0]
        y = point[1]
        for pt in self.points:
            px = pt[0]
            py = pt[1]

            if abs(x - px) != abs(y - py) or x == px or y == py:
                continue

            res += self.freq[(x, py)] * self.freq[(px,y)]
        return res
        
solution = DetectSquares()

solution.add([3, 10])
solution.add([11, 2])
solution.add([3, 2])
solution.add([11, 2])
print(solution.count([11, 10]))
