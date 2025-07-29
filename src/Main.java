import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите режим: 1 - Шифрование, 2 - Расшифровка, 3 - Криптоанализ (Brute Force)");
        int mode = scanner.nextInt();
        scanner.nextLine();

        switch (mode) {
            case 1:
                System.out.print("Введите путь к файлу для шифрования: ");
                String encryptFilePath = scanner.nextLine();
                System.out.print("Введите ключ: ");
                int encryptKey = scanner.nextInt();
                encrypt(encryptFilePath, encryptKey);
                break;
            case 2:
                System.out.print("Введите путь к файлу для расшифровки: ");
                String decryptFilePath = scanner.nextLine();
                System.out.print("Введите ключ: ");
                int decryptKey = scanner.nextInt();
                decrypt(decryptFilePath, decryptKey);
                break;
            case 3:
                System.out.print("Введите путь к файлу для криптоанализа: ");
                String bruteForceFilePath = scanner.nextLine();
                CryptoAnalyzer.bruteForceDecrypt(bruteForceFilePath);
                break;
            default:
                System.out.println("Неверный режим");
        }
    }

    private static void encrypt(String filePath, int key) {
        try {
            String content = FileUtils.readFile(filePath);
            CaesarCipher cipher = new CaesarCipher(key);
            String encryptedContent = cipher.encrypt(content);
            FileUtils.writeFile("encrypted_" + new File(filePath).getName(), encryptedContent);
            System.out.println("Файл зашифрован и сохранен как: " + "encrypted_" + new File(filePath).getName());
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void decrypt(String filePath, int key) {
        try {
            String content = FileUtils.readFile(filePath);
            CaesarCipher cipher = new CaesarCipher(key);
            String decryptedContent = cipher.decrypt(content);
            FileUtils.writeFile("decrypted_" + new File(filePath).getName(), decryptedContent);
            System.out.println("Файл расшифрован и сохранен как: " + "decrypted_" + new File(filePath).getName());
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}