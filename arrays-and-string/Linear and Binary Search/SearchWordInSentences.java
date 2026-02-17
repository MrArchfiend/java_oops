public class SearchWordInSentences {

    static String search(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word))
                return s;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java is powerful",
                "Linear search is simple",
                "Binary search is fast"
        };
        System.out.println(search(sentences, "Binary"));
    }
}
