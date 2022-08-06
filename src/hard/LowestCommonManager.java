package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowestCommonManager {

    public static void main(String[] args) {
        OrgChart topManager = new OrgChart('A');
        OrgChart B = new OrgChart('B');
        OrgChart C = new OrgChart('C');
        OrgChart D = new OrgChart('D');
        OrgChart E = new OrgChart('E');
        OrgChart F = new OrgChart('F');

        topManager.directReports = Arrays.asList(B, C, D, E, F);

        OrgChart G = new OrgChart('G');
        OrgChart H = new OrgChart('H');
        OrgChart I = new OrgChart('I');

        C.directReports = Arrays.asList(G, H, I);

        OrgChart J = new OrgChart('J');

        C.directReports = Arrays.asList(J);

        OrgChart K = new OrgChart('K');
        OrgChart L = new OrgChart('L');

        D.directReports = Arrays.asList(K, L);

        OrgChart M = new OrgChart('M');
        OrgChart N = new OrgChart('N');

        F.directReports = Arrays.asList(M, N);

        OrgChart O = new OrgChart('O');
        OrgChart P = new OrgChart('P');
        OrgChart Q = new OrgChart('Q');
        OrgChart R = new OrgChart('R');

        H.directReports = Arrays.asList(O, P, Q, R);

        OrgChart T = new OrgChart('T');
        OrgChart U = new OrgChart('U');

        P.directReports = Arrays.asList(T, U);

        OrgChart V = new OrgChart('V');

        R.directReports = Arrays.asList(V);

        OrgChart W = new OrgChart('W');
        OrgChart X = new OrgChart('X');
        OrgChart Y = new OrgChart('Y');

        V.directReports = Arrays.asList(W, X, Y);

        OrgChart Z = new OrgChart('Z');

        X.directReports = Arrays.asList(Z);

        OrgChart lowestCommonManager = getLowestCommonManager(topManager, I, P);
        System.out.println(lowestCommonManager.name);
    }

    // O(n) time | O(d) space (d depth of organization tree)
    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    private static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numImportantReports = 0;
        for (OrgChart directReport : manager.directReports) {
            OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
            if (orgInfo.lowestCommonManager != null) {
                return orgInfo;
            }
            numImportantReports += orgInfo.numImportantReports;
        }
        if (manager == reportOne || manager == reportTwo) {
            numImportantReports += 1;
        }
        OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
        return new OrgInfo(lowestCommonManager, numImportantReports);
    }

    static class OrgInfo {
        OrgChart lowestCommonManager;
        int numImportantReports;

        public OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
            this.lowestCommonManager = lowestCommonManager;
            this.numImportantReports = numImportantReports;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

}
