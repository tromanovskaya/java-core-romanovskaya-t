package lesson3Object;

public abstract class Transport {
    private boolean isMilitary;

    public abstract void run();

    public Transport() {
    }

    public Transport(boolean isMilitary) {
        this.isMilitary = isMilitary;
    }

    public boolean isIsMilitary() {
        return isMilitary;
    }

    public void setIsMilitary(boolean isMilitary) {
        this.isMilitary = isMilitary;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "isMilitary=" + isMilitary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        return isMilitary == transport.isMilitary;
    }

    @Override
    public int hashCode() {
        return (isMilitary ? 1 : 0);
    }
}
