package org.texastorque.data.type;

import java.util.Map;
import java.util.function.Function;

import org.texastorque.data.PID;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import edu.wpi.first.shuffleboard.api.util.Maps;

public final class PIDManagerType extends ComplexDataType<PID> {
    private static final String TYPE_NAME = "PIDManager";
    public static final PIDManagerType INSTANCE = new PIDManagerType();

    private PIDManagerType() {
        super(TYPE_NAME, PID.class);
    }

    @Override
    public Function<Map<String, Object>, PID> fromMap() {
        return map -> new PID(Maps.getOrDefault(map, "name", "Unnamed"), Maps.getOrDefault(map, "p", 0),
                Maps.getOrDefault(map, "i", 0), Maps.getOrDefault(map, "d", 0), Maps.getOrDefault(map, "f", 0),
                Maps.getOrDefault(map, "setpoint", 0));
    }

    @Override
    public PID getDefaultValue() {
        return new PID("Unnamed", 0, 0, 0, 0, 0);
    }
}