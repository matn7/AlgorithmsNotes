package october_2023;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonManager {

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

        A.addNeighbor(B);
        A.addNeighbor(C);
        B.addNeighbor(D);
        B.addNeighbor(E);
        D.addNeighbor(H);
        D.addNeighbor(I);
        C.addNeighbor(F);
        C.addNeighbor(G);

        leastCommonManager(A, E, I);
    }

    // O(n) time | O(d) space
    public static OrgChart leastCommonManager(OrgChart topMgr, OrgChart one, OrgChart two) {
        OrgChart manager = leastCommonManagerHelper(topMgr, one, two).manager;
        return manager;
    }

    private static OrgChartInfo leastCommonManagerHelper(OrgChart mgr, OrgChart one, OrgChart two) {
        if (mgr == null) {
            return new OrgChartInfo(0, null);
        }
        int numReports = 0;
        List<OrgChart> neighbors = mgr.neighbors;
        for (OrgChart neighbor : neighbors) {
            OrgChartInfo info = leastCommonManagerHelper(neighbor, one, two);
            if (info.manager != null) {
                return info;
            }
            numReports += info.numReports;
        }
        if (mgr == one || mgr == two) {
            numReports++;
        }
        if (numReports == 2) {
            return new OrgChartInfo(numReports, mgr);
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
        char id;
        List<OrgChart> neighbors;

        public OrgChart(char id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(OrgChart neighbor) {
            this.neighbors.add(neighbor);
        }
    }

}
