public class CaesarCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"-!? ";
    private final int key;

    public CaesarCipher(int key) {
        this.key = key;
    }

    public String encrypt(String text) {
        return shift(text, key);
    }

    public String decrypt(String text) {
        return shift(text, -key);
    }

    private String shift(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char i : text.toCharArray()) {
            int index = ALPHABET.indexOf(i);
            if (index != -1) {
                int newIndex = (index + shift + ALPHABET.length()) % ALPHABET.length();
                result.append(ALPHABET.charAt(newIndex));
            }
        }
        return result.toString();
    }
}