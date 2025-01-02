package ElectricalElement;

import org.apache.commons.math3.complex.Complex;
import VoltageSource.VoltageSource;

public class Resistor extends ElectricalElement {
    Complex resistanceValueWithoutUnit;

    public Resistor() {
        // Khởi tạo tên cho resistor
        super();
        String rName = String.format("R%s", super.getId());
        super.setName(rName);
    }

    public Resistor(double resistance, String unit) {
        this();
        this.resistanceValueWithoutUnit = new Complex(resistance, 0.0);
        this.setUnit(unit);
        this.setResistance(getSIResistance());
    }

    public Complex getSIResistance() {
        if (this.getUnit() == null) {
            return this.resistanceValueWithoutUnit;  // Trả về giá trị mặc định nếu unit là null
        }

        switch (this.getUnit()) {
            case "kΩ":
                return new Complex(this.resistanceValueWithoutUnit.getReal() * 1e3, 0);
            case "MΩ":
                return new Complex(this.resistanceValueWithoutUnit.getReal() * 1e6, 0);
            case "GΩ":
                return new Complex(this.resistanceValueWithoutUnit.getReal() * 1e9, 0);
            case "mΩ":
                return new Complex(this.resistanceValueWithoutUnit.getReal() * 1e-3, 0);
            case "µΩ":
                return new Complex(this.resistanceValueWithoutUnit.getReal() * 1e-6, 0);
            default:
                return this.resistanceValueWithoutUnit;  // Trả về giá trị mặc định nếu đơn vị không hợp lệ
        }
    }

    @Override
    public String toString() {
        // Kiểm tra nếu các giá trị không phải null
        String resistanceStr = (super.getResistance() != null) ? super.getResistance().getReal() + " ohm" : "N/A";
        String voltageStr = (super.getVoltage() != null) ? super.getVoltage().getReal() + "+" + super.getVoltage().getImaginary() + "i V" : "N/A";
        String currentStr = (super.getCurrentIntensity() != null) ? super.getCurrentIntensity().getReal() + "+" + super.getCurrentIntensity().getImaginary() + "i A" : "N/A";
        return String.format("%s = %s, U = %s, I = %s", super.getName(), resistanceStr, voltageStr, currentStr);
    }

    public Complex getResistanceValueWithoutUnit() {
        return resistanceValueWithoutUnit;
    }

    @Override
    public Complex computeResistace(VoltageSource s) {
        // Chưa có logic gì thêm trong phương thức này
        return this.getResistance();
    }
}
