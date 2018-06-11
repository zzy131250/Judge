package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://community.topcoder.com/tc?module=ProblemDetail&rd=4709&pm=1889
 */
public class AvoidRoads {

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Road {
        Point start;
        Point end;

        public Road(Point start, Point end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Point dest;
    public static List<Road> badRoads = new ArrayList<>();
    public static long ways;

    public static boolean isBadRoad(Road r) {
        for (Road tmp: badRoads) {
            if (tmp.start.x == r.start.x && tmp.start.y == r.start.y &&
                    tmp.end.x == r.end.x && tmp.end.y == r.end.y) return true;
        }
        return false;
    }

    public static void move(Point p) {
        if (p.x > dest.x || p.y > dest.y) return;
        if (p.x == dest.x && p.y == dest.y) {
            ways ++;
            return;
        }
        boolean isBad1 = isBadRoad(new Road(p, new Point(p.x, p.y+1)));
        boolean isBad2 = isBadRoad(new Road(p, new Point(p.x+1, p.y)));
        if (!isBad1) move(new Point(p.x, p.y+1));
        if (!isBad2) move(new Point(p.x+1, p.y));
    }

    // dfs
    public static long numWays(int width, int height, String[] bad) {
        dest = new Point(width, height);
        for (String b: bad) {
            String[] items = b.split(" ");
            Point start = new Point(Integer.parseInt(items[0]), Integer.parseInt(items[1]));
            Point end = new Point(Integer.parseInt(items[2]), Integer.parseInt(items[3]));
            badRoads.add(new Road(start, end));
        }
        move(new Point(0, 0));
        return ways;
    }

    public static boolean isBadRoadDp(String[] bad, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < bad.length; i++) {
            int[] points = Arrays.stream(bad[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            if (x1 == points[0] && y1 == points[1] &&
                    x2 == points[2] && y2 == points[3]) return true;
        }
        return false;
    }

    // dp
    public static long numWaysDp(int width, int height, String[] bad) {
        if (width < 0 || height < 0) return 0;
        if (width == 0  && height == 0) return 1;
        long result = 0;
        if (!isBadRoadDp(bad, width-1, height, width, height)) result += numWaysDp(width-1, height, bad);
        if (!isBadRoadDp(bad, width, height-1, width, height)) result += numWaysDp(width, height-1, bad);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numWaysDp(6, 6, new String[] {"0 0 0 1","5 6 6 6"}));
    }

}
