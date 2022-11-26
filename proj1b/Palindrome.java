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
    private boolean recursiveHelper(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }
        if (d.removeFirst() != d.removeFirst()) {
            return false;
        }
        return recursiveHelper(d);
    }
    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return recursiveHelper(d);
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        while (d.size() >= 2) {
            if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
