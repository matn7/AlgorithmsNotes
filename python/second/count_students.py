from collections import defaultdict

class Solution(object):
    # O(n) time | O(1) space
    def countStudents(self, students, sandwiches):
        """
        :type students: List[int]
        :type sandwiches: List[int]
        :rtype: int
        """
        counts = defaultdict(int)

        for s in students:
            counts[s] += 1

        res = len(students)

        for s in sandwiches:
            if s not in counts or counts[s] == 0:
                return res
            
            counts[s] -= 1
            res -= 1
        return res

solution = Solution()
students = [1,1,0,0]
sandwiches = [0,1,0,1]
print(solution.countStudents(students, sandwiches))
