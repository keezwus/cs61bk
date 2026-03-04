package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> bugList = new BuggyAList<>();
        AListNoResizing<Integer> goodList = new AListNoResizing<>();

        bugList.addLast(4);
        goodList.addLast(4);

        bugList.addLast(5);
        goodList.addLast(5);

        bugList.addLast(6);
        goodList.addLast(6);

        bugList.removeLast();
        goodList.removeLast();
        assertSame(goodList.getLast(), bugList.getLast());

        bugList.removeLast();
        goodList.removeLast();
        assertSame(goodList.getLast(), bugList.getLast());
    }

    @Test
    public  void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                bL.addLast(randVal);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bSize = bL.size();
                assertSame(size,bSize);
                System.out.println("size: " + size);
            } else if (operationNumber == 2 && L.size() != 0 && bL.size() != 0) {
                int last = L.getLast();
                int bLast = L.getLast();
                assertSame(last,bLast);
                System.out.println("last = " + last );
            } else if (operationNumber == 3 && L.size() != 0 && bL.size() != 0) {
                int rmLast = L.removeLast();
                int bRmLast = bL.removeLast();
                assertSame(rmLast,bRmLast);
                System.out.println("removed " + rmLast);
            } else {
                System.out.println("empty List");
            }
        }
    }
}
