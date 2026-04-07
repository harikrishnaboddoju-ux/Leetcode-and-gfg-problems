import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        int[] womenPartner = new int[n];
        int[] menPartner = new int[n];
        int[] nextProposal = new int[n];
        int[][] womenRank = new int[n][n];

        Arrays.fill(womenPartner, -1);
        Arrays.fill(menPartner, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                womenRank[i][women[i][j]] = j;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            int w = men[m][nextProposal[m]++];

            if (womenPartner[w] == -1) {
                womenPartner[w] = m;
                menPartner[m] = w;
            } else {
                int mPrime = womenPartner[w];
                if (womenRank[w][m] < womenRank[w][mPrime]) {
                    womenPartner[w] = m;
                    menPartner[m] = w;
                    menPartner[mPrime] = -1;
                    freeMen.add(mPrime);
                } else {
                    freeMen.add(m);
                }
            }
        }

        return menPartner;
    }

    public int[] stableMarriage(int n, int[][] men, int[][] women) {
        return stableMarriage(men, women);
    }
}