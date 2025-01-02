package VoltageSource;

public class AC extends VoltageSource {

    private double frequency;
    private String frequnit;

    public AC(double voltage, String volunit, double frequency, String frequnit) {
        super(voltage, volunit);
        if (frequency <= 0) {
            throw new IllegalArgumentException("Frequency must be greater than 0.");
        }
        this.frequency = frequency;
        this.frequnit = frequnit;
    }

    public double getFrequency() {
        return frequency;
    }

    public String getFrequnit() {
        return frequnit;
    }

    public void setFrequency(double frequency) {
        if (frequency <= 0) {
            throw new IllegalArgumentException("Frequency must be greater than 0.");
        }
        this.frequency = frequency;
    }

    public double getFrequencyInHz() {
        switch (frequnit.toLowerCase()) {
            case "khz":
                return frequency * 1e3;
            case "mhz":
                return frequency * 1e6;
            case "ghz":
                return frequency * 1e9;
            default:
                return frequency;
        }
    }

    public void convertFrequencyUnit(String targetUnit) {
        double freqInHz = getFrequencyInHz();
        switch (targetUnit.toLowerCase()) {
            case "khz":
                this.frequency = freqInHz / 1e3;
                this.frequnit = "kHz";
                break;
            case "mhz":
                this.frequency = freqInHz / 1e6;
                this.frequnit = "MHz";
                break;
            case "ghz":
                this.frequency = freqInHz / 1e9;
                this.frequnit = "GHz";
                break;
            default:
                this.frequency = freqInHz;
                this.frequnit = "Hz";
        }
    }

    @Override
    public String toString() {
        return String.format("AC: %.2f %s, %.2f %s", getVoltage(), getVolunit(), frequency, frequnit);
    }
}
