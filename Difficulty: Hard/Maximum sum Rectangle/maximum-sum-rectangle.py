class Solution:
    def maxRectSum(self, mat):
        if not mat or not mat[0]:
            return 0

        n = len(mat)
        m = len(mat[0])
        max_sum = float('-inf')

        for top in range(n):
            temp = [0] * m  # Temporary array for column sums

            for bottom in range(top, n):
                for col in range(m):
                    temp[col] += mat[bottom][col]

                # Apply Kadane's algorithm to temp[]
                curr_sum = temp[0]
                max_curr_sum = temp[0]
                for i in range(1, m):
                    curr_sum = max(temp[i], curr_sum + temp[i])
                    max_curr_sum = max(max_curr_sum, curr_sum)

                max_sum = max(max_sum, max_curr_sum)

        return max_sum
