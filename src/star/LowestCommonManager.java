package star;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {

    // O(n) time | O(n) space
    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        // Write your code here.
        return getLowestCommonManagerHelper(topManager, reportOne, reportTwo).mgr; // Replace this line.
    }

    private static OrgInfo getLowestCommonManagerHelper(OrgChart manager, OrgChart one, OrgChart two) {
        int reports = 0;
        List<OrgChart> neighbors = manager.directReports;
        for (OrgChart neighbor : neighbors) {
            OrgInfo info = getLowestCommonManagerHelper(neighbor, one, two);
            if (info.mgr != null) {
                return info;
            }
            reports += info.reports;
        }
        if (manager == one || manager == two) {
            reports++;
        }
        if (reports == 2) {
            return new OrgInfo(manager, reports);
        }
        return new OrgInfo(null, reports);
    }

    static class OrgInfo {
        public OrgChart mgr;
        int reports;

        public OrgInfo(OrgChart mgr, int reports) {
            this.mgr = mgr;
            this.reports = reports;
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
