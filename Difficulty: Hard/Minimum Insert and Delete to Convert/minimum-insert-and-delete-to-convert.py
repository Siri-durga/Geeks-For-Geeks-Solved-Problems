from bisect import bisect_left

class Solution:
    def minInsAndDel(self, a, b):
        pos = {val: i for i, val in enumerate(b)}

        seq = []
        for x in a:
            if x in pos:
                seq.append(pos[x])

        lis = []

        for x in seq:
            idx = bisect_left(lis, x)
            if idx == len(lis):
                lis.append(x)
            else:
                lis[idx] = x

        lcs = len(lis)

        return (len(a) - lcs) + (len(b) - lcs)