import static org.junit.Assert.*;
import org.junit.Test;
/*
@resource https://github.com/xkz0777/CS61B-sp18/blob/master/proj1gold/TestArrayDequeGold.java
*/
public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String record = "";
        for (int j = 0; j < 10000; ++j) {
            double n = StdRandom.uniform();
            int i = StdRandom.uniform(1000);
            if (n < 0.25) {
                sad.addFirst(i);
                ads.addFirst(i);
                record += "addFirst(" + i + ")\n";
            } else if (n < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                record += "addLast(" + i + ")\n";
            } else if (n < 0.75) {
                if (ads.isEmpty() || sad.isEmpty()) {
                    continue;
                }
                Integer actual = sad.removeFirst();
                Integer expected = ads.removeFirst();
                record += "removeFirst()\n";
                assertEquals(record, actual, expected);
            } else {
                if (ads.isEmpty() || sad.isEmpty()) {
                    continue;
                }
                Integer actual = sad.removeLast();
                Integer expected = ads.removeLast();
                record += "removeLast()\n";
                assertEquals(record, actual, expected);
            }
        }
    }
}
