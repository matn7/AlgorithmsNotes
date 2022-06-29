package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager2 {

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

    // O(n) time | O(d) space
    // #2: 17/06/2022
    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        // Write your code here.
        return getLowestCommonManagerHelper(topManager, reportOne, reportTwo).manager; // Replace this line.
    }

    private static OrgInfo getLowestCommonManagerHelper(OrgChart manager, OrgChart reportOne,
                                                        OrgChart reportTwo) {
        int directReport = 0;
        OrgChart current = manager;
        List<OrgChart> reports = current.directReports;
        for (OrgChart report : reports) {
            OrgInfo info = getLowestCommonManagerHelper(report, reportOne, reportTwo);
            if (info.directReports == 2) {
                return info;
            }
            directReport += info.directReports;
        }
        if (directReport == 2) {
            return new OrgInfo(directReport, current);
        }
        if (current == reportOne || current == reportTwo) {
            directReport += 1;
        }
        return new OrgInfo(directReport, current);
    }

    static class OrgInfo {
        int directReports;
        OrgChart manager;

        public OrgInfo(int directReports, OrgChart manager) {
            this.directReports = directReports;
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
