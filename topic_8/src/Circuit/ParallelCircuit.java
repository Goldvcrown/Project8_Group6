package Circuit;

import ElectricalElement.*;

import org.apache.commons.math3.complex.Complex;

public class ParallelCircuit extends Circuit {

    public ParallelCircuit() {
        super();
    }

    @Override
    public void trigger() {
        if (this.getVoltageSource() == null) {
            System.out.println("Voltage source is not set.");
            return;
        }

        Complex voltage = new Complex(this.getVoltageSource().getSIVoltage(), 0);

        for (ElectricalElement element : this.getElements()) {
            if (element == null) {
                System.out.println("Found null element in the circuit.");
                continue;
            }

            // Set voltage to the element
            element.setVoltage(voltage);

            // Compute resistance and current intensity
            Complex resistance = element.computeResistace(this.getVoltageSource());
            if (resistance == null || resistance.abs() == 0) {
                System.out.println("Invalid resistance for element: " + element.getName());
                continue;
            }
            element.setResistance(resistance);
            element.setCurrentIntensity(voltage.divide(resistance));
        }
    }

    @Override
    public Complex getEquivalentResistance() {
        Complex inverseResistance = Complex.ZERO;
        Complex one = Complex.ONE;

        for (ElectricalElement element : this.getElements()) {
            if (element == null || element.getResistance() == null || element.getResistance().abs() == 0) {
                continue;
            }
            inverseResistance = inverseResistance.add(one.divide(element.getResistance()));
        }

        if (inverseResistance.equals(Complex.ZERO)) {
            System.out.println("No valid elements in the circuit.");
            return Complex.INF;
        }

        return one.divide(inverseResistance);
    }

    @Override
    public void print() {
        System.out.println("*********************** Parallel Circuit ***********************");
        System.out.println("Electrical Elements:");
        for (ElectricalElement element : this.getElements()) {
            System.out.println(element != null ? element.toString() : "Null element");
        }
        System.out.println("***************************************************************");
    }
}
