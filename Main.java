import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PeminjamanServiceImpl peminjamanService = new PeminjamanServiceImpl();
            Admin admin = new Admin("admin", "admin123");
            // Autentikasi admin
            Login login = new Login("admin", "admin123");
            if (!login.authenticate(scanner)) {
                System.out.println("Login gagal. Program dihentikan.");
                scanner.close();
                return;
            }   boolean running = true;
            while (running) {
                System.out.println("Menu Admin:");
                System.out.println("1. Tambah Game");
                System.out.println("2. Hapus Game");
                System.out.println("3. Cek Ketersediaan Game");
                System.out.println("4. Pinjam Game");
                System.out.println("5. Kembalikan Game");
                System.out.println("6. Keluar");
                System.out.print("Pilih opsi: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline
                
                switch (pilihan) {
                    case 1 -> {
                        // Metode menambahkan Game
                        System.out.print("Masukkan nama game: ");
                        String namaGame = scanner.nextLine();
                        System.out.print("Masukkan genre game: ");
                        String genreGame = scanner.nextLine();
                        System.out.print("Masukkan stok game: ");
                        int stokGame = scanner.nextInt();
                        System.out.print("Masukkan rating game: ");
                        double ratingGame = scanner.nextDouble();
                        System.out.print("Masukkan versi game: ");
                        String versiGame = scanner.next();
                        System.out.print("Masukkan durasi game: ");
                        int durasiGame = scanner.nextInt();
                        Game gameBaru = new Game(namaGame, genreGame, stokGame, ratingGame, versiGame, durasiGame);
                        admin.tambahGame(peminjamanService, gameBaru);
                    }
                    case 2 -> {
                        //Metode menghapus Game
                        System.out.print("Masukkan nama game yang ingin dihapus: ");
                        String namaGameHapus = scanner.nextLine();
                        admin.hapusGame(peminjamanService, namaGameHapus);
                    }
                    case 3 -> {
                        // Menampilkan daftar game
                        System.out.println("Daftar Semua Game:");
                        for (Game game : peminjamanService.getDaftarGame().values()) {
                            System.out.println("Nama: " + game.getNama() +
                                    ", Genre: " + game.getGenre() +
                                    ", Stok: " + game.getStok() +
                                    ", Rating: " + game.getRating() +
                                    ", Versi: " + game.getVersi() +
                                    ", Durasi Peminjaman: " + game.getDurasiPeminjaman() + " hari");
                        }
                    }
                    case 4 -> {
                        System.out.print("Masukkan nama game yang ingin dipinjam: ");
                        String namaGamePinjam = scanner.nextLine();
                        System.out.print("Masukkan nama peminjam: ");
                        String namaPeminjam = scanner.nextLine();
                        peminjamanService.pinjamGame(namaGamePinjam, namaPeminjam);
                    }
                    case 5 -> {
                        System.out.print("Masukkan nama game yang ingin dikembalikan: ");
                        String namaGameKembali = scanner.nextLine();
                        peminjamanService.kembalikanGame(namaGameKembali);
                    }
                    case 6 -> {
                        running = false;
                        System.out.println("Program dihentikan.");
                    }
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
            
        }
    }
}