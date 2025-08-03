class Solution:
    def applyDiff2D(self, mat, opr):
        n = len(mat)
        m = len(mat[0])

        # Step 1: Initialize difference matrix with extra row and column
        diff = [[0] * (m + 1) for _ in range(n + 1)]

        # Step 2: Apply operations to the diff matrix
        for v, r1, c1, r2, c2 in opr:
            diff[r1][c1] += v
            if r2 + 1 < n:
                diff[r2 + 1][c1] -= v
            if c2 + 1 < m:
                diff[r1][c2 + 1] -= v
            if r2 + 1 < n and c2 + 1 < m:
                diff[r2 + 1][c2 + 1] += v

        # Step 3: Row-wise prefix sum
        for i in range(n):
            for j in range(1, m):
                diff[i][j] += diff[i][j - 1]

        # Step 4: Column-wise prefix sum
        for j in range(m):
            for i in range(1, n):
                diff[i][j] += diff[i - 1][j]

        # Step 5: Add diff to original matrix
        res = []
        for i in range(n):
            row = []
            for j in range(m):
                row.append(mat[i][j] + diff[i][j])
            res.append(row)

        return res
