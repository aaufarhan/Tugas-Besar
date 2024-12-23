public abstract class Person {
    protected String username;
    protected String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Metode abstrak yang harus diimplementasikan oleh subclass
    public abstract void work();
}