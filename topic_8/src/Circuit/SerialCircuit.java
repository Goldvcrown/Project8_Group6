package Circuit;

import ElectricalElement.*;
import VoltageSource.*;
import org.apache.commons.math3.complex.Complex;

public class SerialCircuit extends Circuit {

    public SerialCircuit() {
        super();
    }

    
    public void trigger() {
        if (this.getVoltageSource() == null) {
            System.out.println("Voltage source is not set.");
            return;
        }

        if (this.getVoltageSource() instanceof AC) {
            Complex voltage = new Complex(this.getVoltageSource().getSIVoltage(), 0);

            Complex totalResistance = this.getEquivalentResistance();
            if (totalResistance.abs() == 0) {
                System.out.println("Total resistance is zero. Invalid circuit.");
                return;
            }

            Complex current = voltage.divide(totalResistance);

            for (ElectricalElement element : this.getElements()) {
                if (element == null) {
                    System.out.println("Found null element in the circuit.");
                    continue;
                }

                Complex resistance = element.computeResistace(this.getVoltageSource());
                element.setResistance(resistance);

                element.setCurrentIntensity(current);
                element.setVoltage(current.multiply(resistance));
            }
        } else {
            double invEquivalentCapacitance = 0;

            for (ElectricalElement element : this.getElements()) {
                if (element == null) {
                    System.out.println("Found null element in the circuit.");
                    continue;
                }

                if (element instanceof Capacitor) {
                    double capacitance = ((Capacitor) element).getSICapacitance();
                    invEquivalentCapacitance += 1 / capacitance;
                }
            }

            if (invEquivalentCapacitance == 0) {
                System.out.println("No capacitors in the circuit.");
                return;
            }

            double equivalentCapacitance = 1 / invEquivalentCapacitance;
            double charge = this.getVoltageSource().getVoltage() * equivalentCapacitance;

            for (ElectricalElement element : this.getElements()) {
                if (element instanceof Capacitor) {
                    double capacitance = ((Capacitor) element).getSICapacitance();
                    element.setVoltage(new Complex(charge / capacitance, 0));
                }
            }
        }
    }

    @Override
    public Complex getEquivalentResistance() {
        Complex totalResistance = Complex.ZERO;

        for (ElectricalElement element : this.getElements()) {
            if (element == null || element.getResistance() == null) {
                continue;
            }
            totalResistance = totalResistance.add(element.getResistance());
        }

        return totalResistance;
    }

    @Override
    public void print() {
        System.out.println("*********************** Serial Circuit ***********************");
        System.out.println("Electrical Elements:");
        for (ElectricalElement element : this.getElements()) {
            System.out.println(element != null ? element.toString() : "Null element");
        }
        System.out.println("*************************************************************");
    }
}
