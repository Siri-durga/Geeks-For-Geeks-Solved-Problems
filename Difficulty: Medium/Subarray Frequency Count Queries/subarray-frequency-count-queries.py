from collections import defaultdict
from bisect import bisect_left, bisect_right

class Solution:
    def freqInRange(self, arr, queries):
        pos = defaultdict(list)

        # Store indices of each element
        for i, val in enumerate(arr):
            pos[val].append(i)

        ans = []

        for l, r, x in queries:
            if x not in pos:
                ans.append(0)
                continue

            indices = pos[x]

            left = bisect_left(indices, l)
            right = bisect_right(indices, r)

            ans.append(right - left)

        return ans