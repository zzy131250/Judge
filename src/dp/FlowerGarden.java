package dp;

import java.util.*;
import java.util.stream.IntStream;

/**
 * http://community.topcoder.com/tc?module=ProblemDetail&rd=5006&pm=1918
 */
public class FlowerGarden {

    private static class Flower {
        int height;
        int bloom;
        int wilt;

        public Flower(int h, int b, int w) {
            height = h;
            bloom = b;
            wilt = w;
        }
    }

    public static boolean isOverlap(Flower flower1, Flower flower2) {
        return !(flower1.wilt < flower2.bloom || flower1.bloom > flower2.wilt);
    }

    public static int[] getOrdering(int[] heights, int[] blooms, int[] wilts) {
        Flower[] flowers = new Flower[heights.length];
        for (int i = 0; i < flowers.length; i++) flowers[i] = new Flower(heights[i], blooms[i], wilts[i]);
        List<Flower> result = new ArrayList<>();
        result.add(flowers[0]);
        for (int i = 1; i < flowers.length; i++) {
            boolean added = false;
            for (int j = 0; j < result.size(); j++) {
                Flower f1 = flowers[i];
                Flower f2 = result.get(j);
                if (isOverlap(f1, f2)) {
                    if (f1.height > f2.height) continue;
                    else {
                        result.add(j, f1);
                        added = true;
                        break;
                    }
                } else continue;
            }
            if (!added) result.add(flowers[i]);
        }
        return result.stream().mapToInt(flower -> flower.height).toArray();
    }

    public static void main(String[] args) {
        Arrays.stream(getOrdering(IntStream.of(3,2,5,4).toArray(), IntStream.of(1,2,11,10).toArray(),
                IntStream.of(4,3,12,13).toArray())).forEach(System.out::println);
    }

}
