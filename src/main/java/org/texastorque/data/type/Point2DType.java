package org.texastorque.data.type;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import edu.wpi.first.shuffleboard.api.util.Maps;

import java.util.Map;
import java.util.function.Function;

import org.texastorque.data.Point2D;

public final class Point2DType extends ComplexDataType<Point2D> {
    // The sendable type name
    private static final String TYPE_NAME = "Point2D";
    public static final Point2DType INSTANCE = new Point2DType();

    private Point2DType() {
        super(TYPE_NAME, Point2D.class);
    }

    @Override
    public Function<Map<String, Object>, Point2D> fromMap() {
        return map -> new Point2D(Maps.getOrDefault(map, "x", 0), Maps.getOrDefault(map, "y", 0));
    }

    @Override
    public Point2D getDefaultValue() {
        return new Point2D(0, 0);
    }

}
