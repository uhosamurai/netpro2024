class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    // ここに続きを実装していく。

    public int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumFromPtoQ(int p, int q) {
        int sum = 0;
        if (p > q) {
            return -1;
        } else {
            for (int i = p; i <= q; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public int sumFromArrayIndex(int[] a, int index) {
        int first = index;
        int sum = 0;
        if (first >= a.length) {
            return -1;
        } else {
            for (int i = first; i < a.length; i++) {
                sum += a[i];
            }
            return sum;
        }
    }

    public int selectMaxValue(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public int selectMaxIndex(int[] a) {
        int max = a[0];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                index = i;
            }
        }
        return index;
    }

    public int selectMinValue(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    public int selectMinIndex(int[] a) {
        int min = a[0];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    public void swapArrayElements(int[] p, int i, int j) {
        int tmp;
        tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }

    public boolean swapTwoArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        } else {
            for (int i = 0; i < a.length; i++) {
                int tmp = a[i];
                a[i] = b[i];
                b[i] = tmp;
            }
            return true;
        }
    }
}
