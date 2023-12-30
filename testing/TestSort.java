public class TestSort {
    public static void testSort() {


        // String[] means an array of string
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        if (input != expected) {
            System.out.println("Error! There seems to be a problem with Sort.sort.");
        }

        public static void main(String[] args) {
            testSort();
        }

    }
}