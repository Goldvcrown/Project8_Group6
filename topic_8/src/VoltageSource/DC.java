package VoltageSource;

public class DC extends VoltageSource {

    public DC(double voltage, String volunit) {
        super(voltage, volunit);
        if (voltage < 0) {
            throw new IllegalArgumentException("Voltage must be non-negative.");
        }
    }

    @Override
    public String toString() {
        return String.format("DC: %.2f %s", getVoltage(), getVolunit());
    }
}
