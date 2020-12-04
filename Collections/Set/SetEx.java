import java.io.*;
import java.util.*;

public class SetEx {

    private void duplicate() {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(1); list.add(1);
        list.add(2); list.add(2); list.add(2);
        list.add(3); list.add(3); list.add(3);

        Set<Integer> ts = new TreeSet<>(list);
        Set<Integer> hs = new HashSet<>(list);
        Set<Integer> lhs = new LinkedHashSet<>(list);

        System.out.println("== list ==================");
        for (Integer i : list) {
            System.out.print(i);
        }
        System.out.println("\n");

        System.out.println("== ts ==================");
        ts.addAll(list);
        for (Integer i : ts) {
            System.out.print(i);
        }
        System.out.println("\n");

        System.out.println("== hs ==================");
        hs.addAll(list);
        for (Integer i : ts) {
            System.out.print(i);
        }
        System.out.println("\n");

        System.out.println("== lhs ==================");
        lhs.addAll(list);
        for (Integer i : ts) {
            System.out.print(i);
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        new SetEx().duplicate();
    }
}