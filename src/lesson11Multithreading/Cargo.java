package lesson11Multithreading;

public class Cargo {
    private int id;
    private String name;
    private int count;
    private int berth;
    private String error = "no";

    public Cargo() {
    }

    public Cargo(String error) {
        this.error = error;
    }

    public Cargo(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public void setBerth(int berth) {
        this.berth = berth;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", berth=" + berth +
                ", error='" + error + '\'' +
                '}';
    }
}
