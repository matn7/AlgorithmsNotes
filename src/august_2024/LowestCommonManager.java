package august_2024;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {


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

        getLowestCommonManager(A, E, I);
    }

    // O(n) time | O(n) space
    public static OrgChart getLowestCommonManager(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        if (manager == null) {
            return null;
        }
        OrgChart manager1 = helper(manager, reportOne, reportTwo).manager;
        return manager1;

    }

    private static OrgInfo helper(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        List<OrgChart> directReports = manager.directReports;
        int numReports = 0;

        for (OrgChart reports : directReports) {
            OrgInfo info = helper(reports, reportOne, reportTwo);
            if (info.manager != null) {
                return info;
            }
            numReports += info.numReports;
        }

        if (manager == reportOne || manager == reportTwo) {
            numReports++;
        }

        if (numReports == 2) {
            return new OrgInfo(2, manager);
        }

        return new OrgInfo(numReports, null);
    }

    static class OrgInfo {
        int numReports;
        OrgChart manager;

        public OrgInfo(int numReports, OrgChart manager) {
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
