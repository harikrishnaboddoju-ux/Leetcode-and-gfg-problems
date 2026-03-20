class Solution:
    def minAbsDiff(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        res_rows, res_cols = m - k + 1, n - k + 1
        ans = [[0] * res_cols for _ in range(res_rows)]
        
        for i in range(res_rows):
            for j in range(res_cols):
                distinct_elements = set()
                for r in range(i, i + k):
                    for c in range(j, j + k):
                        distinct_elements.add(grid[r][c])
                if len(distinct_elements) <= 1:
                    ans[i][j] = 0
                    continue
                sorted_vals = sorted(list(distinct_elements))
                min_diff = float('inf')
                for p in range(len(sorted_vals) - 1):
                    diff = sorted_vals[p+1] - sorted_vals[p]
                    if diff < min_diff:
                        min_diff = diff
                
                ans[i][j] = min_diff
                
        return ans