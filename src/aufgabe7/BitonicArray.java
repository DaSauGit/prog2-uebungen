package aufgabe7;

public class BitonicArray {
    public static int findPeakIterative(int[] a) {
        int maxpos = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[maxpos]) {
                //max = a[i];
                maxpos = i;
            }
        }
        return maxpos;
    }

    public static int findPeakDivideAndConquer(int[] a) {
        return f(0, a.length - 1, a);
    }

    private static int f(int links, int rechts, int[] a) {
        if (links == rechts) {
            return links;
        } else {
            int mitte = (links + rechts) / 2;

            int linkerIndex = f(links, mitte, a);
            int rechterIndex = f(mitte + 1, rechts, a);

            if (a[linkerIndex] > a[rechterIndex]) {
                return linkerIndex;
            } else {
                return rechterIndex;
            }
        }
    }
}
