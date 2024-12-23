public interface PeminjamanService {
    // CRUD operations: Pinjam game, kembalikan game, cek ketersediaan game
    void pinjamGame(String namaGame, String namaPeminjam);
    void kembalikanGame(String namaGame);
    boolean cekKetersediaanGame(String namaGame);
}