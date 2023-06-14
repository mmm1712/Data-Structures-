import java.util.*;
public class HW7_1 {
    public static void main(String[] args) {
        // Your solution will be tested as such, with random input lists such as the following
        List < Integer > ints = new ArrayList < > (Arrays.asList(1, 2, 3));
        MyIterator iter = new MyIterator(ints.iterator());
        System.out.println("\n Example 1: \n");
        System.out.println(iter.next()); // 1
        System.out.println(iter.lookAhead()); // 2
        System.out.println(iter.next()); // 2
        System.out.println(iter.next()); // 3
        System.out.println(iter.hasNext()); // false

        List < Integer > ints2 = new ArrayList < > (Arrays.asList(100));
        MyIterator iter2 = new MyIterator(ints2.iterator());
        System.out.println("\n Example 2: \n");
        System.out.println(iter2.next()); // 100
        System.out.println(iter2.lookAhead()); // null
        System.out.println(iter2.next()); // null
        System.out.println(iter2.hasNext()); // false

    }
}
class MyIterator implements Iterator < Integer > {

    List < Integer > list = new ArrayList < Integer > ();
    Iterator < Integer > iter;
    int curIndex = -1;

    public MyIterator(Iterator < Integer > iterator) {
        this.iter = iterator;
        while (iterator.hasNext()) {
            int n = iterator.next();
            list.add(n);
        }
    }

    /**
     * PURPOSE: lookAhead(): returns the next element in the iteration without advancing the iterator.
     * PARAMETERS: n/a
     * RETURN VALUES: int: the next element in the iteration ; null
     */

    public Integer lookAhead() {
        if (hasNext()) {
            return list.get(curIndex + 1);
        } else {
            return null;
        }
    }

    /**
     * PURPOSE: next(): returns the next element in the iteration.
     * PARAMETERS: n/a
     * RETURN VALUES: int: the next element in the iteration ; null
     */

    @Override
    public Integer next() {
        if (hasNext()) {
            curIndex++;
            return list.get(curIndex);
        }
        return null;
    }

    /**
     * PURPOSE: hasNext(): returns true if the iteration has more elements, false otherwise.
     * PARAMETERS: n/a
     * RETURN VALUES: boolean true/false
     */

    @Override
    public boolean hasNext() {
        if (list.size() > curIndex + 1)
            return true;
        else
            return false;
    }
}