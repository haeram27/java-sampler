import java.util.*;

public class BitsetExam {

    public static void main(String[] args) {

        BitSet bitset = new BitSet(8);

        // assign values to bitset
        bitset.set(0);
        bitset.set(1);
        bitset.set(2);
        bitset.set(5);
        bitset.set(6);
        bitset.set(7);

        // print the sets
        System.out.println("Bitset: " + bitset);

        // print the sets
        System.out.println("Bitset Value(2): " + bitset.get(2));
        System.out.println("Bitset Value(3): " + bitset.get(3));

        // get index 1 to 4 of bitset
        System.out.println("New Bitset: " + bitset.get(1, 4));
    }
}