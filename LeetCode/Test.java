public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("....");
        sb.replace(1, 2, "Q");
        System.out.println(sb.toString());
    }
}
