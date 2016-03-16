class Experiment2 {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        } else if (alg.equals("Shell")) {
            Shell.sort(a);
        }return timer.elapsedTime();
    } //time

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        StdOut.printf("Running %s Sort.\n", alg);
        for (int t = 0; t < T; t++) {
            StdOut.printf("--Iteration %d\n", t);
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.exp(1.5);
            } //for
            total += time(alg, a);
        } //for
        return total;
    } //timeRandomInput

    public static void main(String args[]) {
        if (args.length != 4) {
            StdOut.printf("USAGE: String alg1, String alg2, int array_size, int repeats");
        } else {
            String alg1 = args[0];
            String alg2 = args[1];
            int N = Integer.parseInt(args[2]);
            int T = Integer.parseInt(args[3]);
            double t1 = timeRandomInput(alg1, N, T);
            double t2 = timeRandomInput(alg2, N, T);
            StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
            StdOut.printf(" %.3f times faster than %s\n", t2/t1, alg2);
        } //if-else
    } //main

} //SortCompare
