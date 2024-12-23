import java.util.HashMap;

public class PeminjamanServiceImpl implements PeminjamanService {
    private HashMap<String, Game> daftarGame = new HashMap<>();

    // Inisialisasi daftar game pada konstruktor
    public PeminjamanServiceImpl() {
        // Inisialisasi daftar game
        daftarGame.put("Game A", new Game("Game A", "Action", 5, 4.5, "1.0", 7));
        daftarGame.put("Game B", new Game("Game B", "Adventure", 3, 4.0, "1.0", 5));
    }

    @Override
    public void pinjamGame(String namaGame, String namaPeminjam) {
        // Cek ketersediaan game, lalu pinjam jika tersedia
        Game game = daftarGame.get(namaGame);
        if (game != null && game.getStok() > 0) {
            game.setStok(game.getStok() - 1);
            System.out.println(namaPeminjam + " telah meminjam " + namaGame);
        } else {
            System.out.println("Game tidak tersedia.");
        }
    }

    @Override
    public void kembalikanGame(String namaGame) {
        // Mengembalikan Game yang dipinjam
        Game game = daftarGame.get(namaGame);
        if (game != null) {
            game.setStok(game.getStok() + 1);
            System.out.println(namaGame + " telah dikembalikan.");
        }
    }

    @Override
    public boolean cekKetersediaanGame(String namaGame) {
        // Memeriksa apakah game tersedia dalam daftar
        Game game = daftarGame.get(namaGame);
        return game != null && game.getStok() > 0;
    }

    // Metode untuk menambah game baru
    public void tambahGame(Game game) {
        daftarGame.put(game.getNama(), game);
        System.out.println("Game " + game.getNama() + " telah ditambahkan.");
    }

    // Metode untuk menghapus game
    public void hapusGame(String namaGame) {
        if (daftarGame.remove(namaGame) != null) {
            System.out.println("Game " + namaGame + " telah dihapus.");
        } else {
            System.out.println("Game tidak ditemukan.");
        }
    }

    public HashMap<String, Game> getDaftarGame() {
        return daftarGame;
    }

    public void setDaftarGame(HashMap<String, Game> daftarGame) {
        this.daftarGame = daftarGame;
    }
}