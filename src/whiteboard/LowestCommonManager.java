package whiteboard;

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

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        // Write your code here.

        OrgNode orgNode = getLowestCommonManagerHelper(topManager, reportOne, reportTwo);

        return orgNode.lowestCommonMgr; // Replace this line.
    }

    private static OrgNode getLowestCommonManagerHelper(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numReports = 0;
        List<OrgChart> reports = manager.directReports;

        for (OrgChart report : reports) {
            OrgNode reportNode = getLowestCommonManagerHelper(report, reportOne, reportTwo);
            if (reportNode.lowestCommonMgr != null) {
                return new OrgNode(reportNode.lowestCommonMgr, 2);
            }
            numReports += reportNode.numReports;
        }

        if (manager == reportOne || manager == reportTwo) {
            numReports += 1;
        }

        OrgChart lcm = numReports == 2 ? manager : null;

        return new OrgNode(lcm, numReports);
    }


    static class OrgNode {
        OrgChart lowestCommonMgr;
        int numReports;

        public OrgNode(OrgChart lowestCommonMgr, int numReports) {
            this.lowestCommonMgr = lowestCommonMgr;
            this.numReports = numReports;
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
