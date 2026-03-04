package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {

        AList<Integer> Ns = new AList<Integer>();
        AList<Integer> opCounts = Ns;
        AList<Double> times = new AList<Double>();

        int testCounts = 8;
        int baseN = 1000;

        for (int i = 0;i < testCounts;i++){

            int testN = (int)(baseN * Math.pow(2,i));
            Ns.addLast(testN);

            AList<Integer> testList = new AList<Integer>();
            Stopwatch sw = new Stopwatch();

            for(int j = 0;j < testN;j++){
                testList.addLast(1);
            }
            times.addLast(sw.elapsedTime());
        }

        printTimingTable(Ns,times,opCounts);
    }
}
