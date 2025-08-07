class Solution:
    def minDifference(self, arr):
        def time_to_seconds(t):
            h, m, s = map(int, t.split(":"))
            return h * 3600 + m * 60 + s

        seconds = [time_to_seconds(t) for t in arr]
        seconds.sort()

        min_diff = float('inf')
        n = len(seconds)

        for i in range(1, n):
            min_diff = min(min_diff, seconds[i] - seconds[i - 1])

        # Check wrap-around difference between last and first
        wrap_diff = 86400 - seconds[-1] + seconds[0]
        min_diff = min(min_diff, wrap_diff)

        return min_diff
