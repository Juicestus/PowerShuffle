package org.texastorque.data;

import java.util.Map;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

public final class PID extends ComplexData<PID> {
    private final String name;
    private final double p;
    private final double i;
    private final double d;
    private final double f;
    private final double setpoint;

    public PID(String name, double p, double i, double d, double f, double setpoint) {
        this.name = name;
        this.p = p;
        this.i = i;
        this.d = d;
        this.f = f;
        this.setpoint = setpoint;
    }

    public String getName() {
        return name;
    }

    public double getP() {
        return p;
    }

    public double getI() {
        return i;
    }

    public double getD() {
        return d;
    }

    public double getF() {
        return f;
    }

    public double getSetpoint() {
        return setpoint;
    }

    @Override
    public String toHumanReadableString() {
        return String.format("P: %f, I: %f, D: %f, F: %f, SP: %f", p, i, d, f, setpoint);
    }

    @Override
    public Map<String, Object> asMap() {
        return Map.of("p", p, "i", i, "d", d, "f", f);
    }

    public PID withP(double p) {
        return new PID(name, p, i, d, f, setpoint);
    }

    public PID withI(double i) {
        return new PID(name, p, i, d, f, setpoint);
    }

    public PID withD(double d) {
        return new PID(name, p, i, d, f, setpoint);
    }

    public PID withF(double f) {
        return new PID(name, p, i, d, f, setpoint);
    }

    public PID withSetpoint(double setpoint) {
        return new PID(name, p, i, d, f, setpoint);
    }
}
