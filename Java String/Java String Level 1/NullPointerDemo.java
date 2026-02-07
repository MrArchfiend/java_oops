public class NullPointerDemo {
    static void generate() {
        String text = null;
        text.length();
    }

    static void handle() {
        try {
            String text = null;
            text.length();
        } catch (NullPointerException e) {
            System.out.println("Handled");
        }
    }

    public static void main(String[] args) {
        try {
            generate();
        } catch (Exception e) {
        }
        handle();
    }
}
