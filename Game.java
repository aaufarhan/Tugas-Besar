public class Game {
    private String nama;
    private String genre;
    private int stok;
    private double rating;
    private String versi;
    private int durasiPeminjaman; // durasi dalam hari

    // Konstruktor untuk menginisialisasi objek Game
    public Game(String nama, String genre, int stok, double rating, String versi, int durasiPeminjaman) {
        this.nama = nama;
        this.genre = genre;
        this.stok = stok;
        this.rating = rating;
        this.versi = versi;
        this.durasiPeminjaman = durasiPeminjaman;
    }

    // Getter dan setter untuk memanipulasi data game
    public String getNama() {
        return nama;
    }

    public String getGenre() {
        return genre;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getRating() {
        return rating;
    }

    public String getVersi() {
        return versi;
    }

    public int getDurasiPeminjaman() {
        return durasiPeminjaman;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setVersi(String versi) {
        this.versi = versi;
    }

    public void setDurasiPeminjaman(int durasiPeminjaman) {
        this.durasiPeminjaman = durasiPeminjaman;
    }
}
