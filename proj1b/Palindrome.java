public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> array = new ArrayDeque<>();
        int size = word.length();
        for (int i = 0; i < size; i++) {
            array.addLast(word.charAt(i));
        }
        array.printDeque();
        return array;
    }
    private boolean recursiveHelper(ArrayDeque<Character> arrayDeque1,
                                    ArrayDeque<Character> arrayDeque2) {
        if (arrayDeque1.size() == 0) {
            return true;
        }
        if (arrayDeque1.removeFirst() != arrayDeque2.removeFirst()) {
            return false;
        }
        return recursiveHelper(arrayDeque1, arrayDeque2);
    }
    public boolean isPalindrome(String word) {
        ArrayDeque<Character> arrayDeque1 = new ArrayDeque<>();
        ArrayDeque<Character> arrayDeque2 = new ArrayDeque<>();
        int size = word.length();
        for (int i = 0; i < size; i++) {
            arrayDeque1.addLast(word.charAt(i));
            arrayDeque2.addFirst(word.charAt(i));
        }
        /*
        use for loop
        for(int i = 0; i < size; i++) {
            if (arrayDeque1.get(i) != arrayDeque2.get(i)) {
                return false;
            }
        }
        return true;
        */
        return recursiveHelper(arrayDeque1, arrayDeque2);
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int size = word.length();
        for (int i = 0; i < size / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
