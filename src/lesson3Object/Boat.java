package lesson3Object;

public class Boat extends Ship {
    private static int count;
    private int length;
    private int width;

    public Boat() {
        count++;
    }

    public Boat(int length, int width) {
        this.length = length;
        this.width = width;
        count++;
    }

    public Boat(int price, String name, int weight, String type, int humanSeats, int length, int width) {
        super(price, name, weight, type, humanSeats);
        this.length = length;
        this.width = width;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Boat.count = count;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Boat boat = (Boat) o;

        if (length != boat.length) return false;
        return width == boat.width;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + length;
        result = 31 * result + width;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " Boat{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
