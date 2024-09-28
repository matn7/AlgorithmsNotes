package august_2024;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManagerV2 {

    public static void main(String[] args) {
        OrgChart A = new OrgChart('A');
        OrgChart B = new OrgChart('B');
        OrgChart C = new OrgChart('C');
        OrgChart D = new OrgChart('D');
        OrgChart E = new OrgChart('E');
        OrgChart F = new OrgChart('F');
        OrgChart G = new OrgChart('G');
        OrgChart H = new OrgChart('H');
        OrgChart I = new OrgChart('I');

        A.directReports.add(B);
        A.directReports.add(C);

        B.directReports.add(D);
        B.directReports.add(E);

        D.directReports.add(H);
        D.directReports.add(I);

        C.directReports.add(F);
        C.directReports.add(G);

        OrgChart lowestCommonManager = getLowestCommonManager(A, E, I);
        System.out.println(lowestCommonManager);

    }

    // O(n) time | O(n) space
    public static OrgChart getLowestCommonManager(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        if (manager == null) {
            return null;
        }
        return helper(manager, reportOne, reportTwo).manager;
    }

    private static OrgChartInfo helper(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {

        int numReports = 0;
        List<OrgChart> directReports = manager.directReports;

        for (OrgChart directReport : directReports) {
            OrgChartInfo info = helper(directReport, reportOne, reportTwo);
            if (info.manager != null) {
                return info;
            }
            numReports += info.numReports;
        }

        if (manager == reportOne || manager == reportTwo) {
            numReports++;
        }
        if (numReports == 2) {
            return new OrgChartInfo(numReports, manager);
        }
        return new OrgChartInfo(numReports, null);
    }

    static class OrgChartInfo {
        int numReports;
        OrgChart manager;

        public OrgChartInfo(int numReports, OrgChart manager) {
            this.numReports = numReports;
            this.manager = manager;
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
