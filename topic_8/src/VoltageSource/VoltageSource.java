package VoltageSource;

public abstract class VoltageSource {
	private double voltage;
	protected double frequency;
	private String volunit;
	protected String frequnit;
	
	public VoltageSource(double voltage, String volunit) {
		this.voltage = voltage;
		this.volunit = volunit;
		this.frequnit = "Hz"; 
	}

	public double getVoltage() {
		return voltage;
	}

	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}
	
	public double getFrequency() {
		return this.frequency;
	}
	
	public String getVolunit() {
		return volunit;
	}

	public String getFrequnit() {
		return frequnit;
	}

    public double getSIVoltage() {
        String unit = this.getVolunit();
        if (unit == null) {
            throw new IllegalArgumentException("Voltage unit is not defined.");
        }
        
        switch (unit) {
            case "kV":
                return this.getVoltage() * 1e3;
            case "MV":
                return this.getVoltage() * 1e6;
            case "mV":
                return this.getVoltage() * 1e-3;
            case "µV":
                return this.getVoltage() * 1e-6;
            case "nV":
                return this.getVoltage() * 1e-9;
            default:
                return this.getVoltage();
        }
    }
	
    public double getSIFrequency() {
        if (frequnit == null) {
            throw new IllegalArgumentException("Frequency unit is not defined.");
        }

        switch (frequnit) {
            case "kHz":
                return this.getFrequency() * 1e3;
            case "MHz":
                return this.getFrequency() * 1e6;
            case "GHz":
                return this.getFrequency() * 1e9;
            case "THz":
                return this.getFrequency() * 1e12;
            default:
                return this.getFrequency();
        }
    }

	
	public abstract String toString();
}