package org.texastorque.data.type;

import java.util.Map;
import java.util.function.Function;

import org.texastorque.data.SwerveModule;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import edu.wpi.first.shuffleboard.api.util.Maps;

public final class SwerveModuleType extends ComplexDataType<SwerveModule> {
    private static final String TYPE_NAME = "SwerveModule";
    public static final SwerveModuleType INSTANCE = new SwerveModuleType();

    private SwerveModuleType() {
        super(TYPE_NAME, SwerveModule.class);
    }

    @Override
    public Function<Map<String, Object>, SwerveModule> fromMap() {
        return map -> new SwerveModule(Maps.getOrDefault(map, "requestedSpeed", 0), Maps.getOrDefault(map, "speed", 0),
                Maps.getOrDefault(map, "requestedTurn", 0), Maps.getOrDefault(map, "turn", 0));

    }

    @Override
    public SwerveModule getDefaultValue() {
        return new SwerveModule(0, 0, 0, 0);
    }

}
