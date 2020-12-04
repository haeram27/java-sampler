public class StackOverflow{
    public static void recur(int i) {
        System.out.println(i);
        recur(i+1);  // StackOverflowError at i = 11225
    }
    
    public static void main(String[] args) {
        System.out.println("StackOverflowError");;
        recur(1);
    }
}