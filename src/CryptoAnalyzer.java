import java.io.IOException;

public class CryptoAnalyzer {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"-!? ";

    public static void bruteForceDecrypt(String filePath) {
        try {
            String content = FileUtils.readFile(filePath);
            for (int i = 1; i <= ALPHABET.length(); i++) {
                CaesarCipher cipher = new CaesarCipher(i);
                String decryptedContent = cipher.decrypt(content);
                if (isValidDecryptedText(decryptedContent)) {
                    FileUtils.writeFile("brute_force_decrypted_" + i + ".txt", decryptedContent);
                    System.out.println("Успешное расшифрование с ключом " + i + ". Файл сохранен как: brute_force_decrypted_" + i + ".txt");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static boolean isValidDecryptedText(String text) {
        return text.contains(" ") && text.length() > 20;
    }
}