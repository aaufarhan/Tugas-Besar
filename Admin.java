public class Admin extends Person {
    // Konstruktor memanggil konstruktor superclass Person
    public Admin(String username, String password) {
        super(username, password); 
    }

    @Override
    public void work() {
        // Menampilkan pesan bahwa admin sedang bekerja
        System.out.println("Admin " + username + " sedang bekerja.");
    }

    // Menambah game melalui PeminjamanServiceImpl
    public void tambahGame(PeminjamanServiceImpl peminjamanService, Game game) {
        peminjamanService.tambahGame(game); 
        System.out.println("Game " + game.getNama() + " telah ditambahkan.");
    }

    // Menghapus game melalui PeminjamanServiceImpl
    public void hapusGame(PeminjamanServiceImpl peminjamanService, String namaGame) {
        peminjamanService.hapusGame(namaGame); 
        System.out.println("Game " + namaGame + " telah dihapus.");
    }
}
