package aufgabe7;

public class BitonicArray {

    //O-Notation: O(n)
    public static int findPeakIterative(int[] a) {
        int maxpos = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[i+1]){
                return maxpos = i;
            }
            if (a[i] > a[maxpos]) {
                //max = a[i];
                maxpos = i;
            }
        }
        return maxpos;
    }

    //O-Notation: O(log n)
    public static int findPeakDivideAndConquer(int[] a) {
        return f(0, a.length - 1, a);
    }

    private static int f(int links, int rechts, int[] a) {
        if (links == rechts) {
            return links;
        } else {
            int mitte = (links + rechts) / 2;
            int linkerIndex = links;
            int rechterIndex = rechts;
            if (a[mitte] > a[mitte + 1]){
                linkerIndex = f(links, mitte, a);
            } else {
                rechterIndex = f(mitte + 1, rechts, a);
            }

            if (a[linkerIndex] > a[rechterIndex]) {
                return linkerIndex;
            } else {
                return rechterIndex;
            }
        }
    }
    /**
     * Iterativ
     * 10000000 / 3129369 = 0,3129
     * 100000000 / 33927811 = 0,3392
     * ⇾ ungefähr gleich ⇾ konstant
     * 1000000000 ~ 326050000 microsecond, da linear
     *
     * Teile-Herrsche
     * 1235 ∗ 9/8 = 1389,375 microsecond für 1000000000
     */
}
