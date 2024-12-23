import java.util.Random;
import java.util.Scanner;

public class Login {
    private String validUsername;
    private String validPassword;

    // Konstruktor untuk inisialisasi username dan password
    public Login(String validUsername, String validPassword) {
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    // Fungsi autentikasi dengan verifikasi captcha
    public boolean authenticate(Scanner scanner) {
        int maxAttempts = 3;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            // Percabangan untuk memeriksa username dan password
            if (username.equals(validUsername) && password.equals(validPassword)) {
                String captcha = generateCaptcha(6); // Menghasilkan captcha
                System.out.println("Captcha: " + captcha);
                
                System.out.print("Masukkan Captcha: ");
                String userCaptcha = scanner.nextLine();

                if (userCaptcha.equals(captcha)) {
                    System.out.println("Login Berhasil!");
                    return true;
                } else {
                    System.out.println("Captcha Salah!");
                }
            } else {
                System.out.println("Username atau Password Salah!");
            }
        }

        System.out.println("Terlalu banyak percobaan login. Akses ditolak.");
        return false;
    }

    // Menghasilkan captcha secara acak
    private String generateCaptcha(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            captcha.append(chars.charAt(random.nextInt(chars.length()))); 
        }

        return captcha.toString(); // Poin 5: Manipulasi String
    }

    public String getValidUsername() {
        return validUsername;
    }

    public void setValidUsername(String validUsername) {
        this.validUsername = validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }
}