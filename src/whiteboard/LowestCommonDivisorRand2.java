package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonDivisorRand2 {

    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        // Write your code here.
        if (topManager == reportOne || topManager == reportTwo) {
            return topManager;
        }
        OrgInfo info = lcmHelper(topManager, reportOne, reportTwo);
        return info.mgr; // Replace this line.
    }

    static OrgInfo lcmHelper(OrgChart node, OrgChart one, OrgChart two) {
        int numReports = 0;
        List<OrgChart> neighbors = node.directReports;
        for (OrgChart neighbor : neighbors) {
            OrgInfo info = lcmHelper(neighbor, one, two);
            if (info.mgr != null) {
                return info;
            }
            numReports += info.numReports;
        }
        if (node == one || node == two) {
            numReports++;
        }
        if (numReports == 2) {
            return new OrgInfo(numReports, node);
        }
        return new OrgInfo(numReports, null);
    }

    static class OrgInfo {
        int numReports;
        OrgChart mgr;

        public OrgInfo(int numReports, OrgChart mgr) {
            this.numReports = numReports;
            this.mgr = mgr;
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
