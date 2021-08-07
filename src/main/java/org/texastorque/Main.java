package org.texastorque;

import java.util.List;
import java.util.Map;

import org.texastorque.data.type.*;
import org.texastorque.widget.*;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

/**
 * Hewo! Thanks for checking out PowerShuffle. Some parts of this plugin are
 * rather complicated, so if you have any questions feel free to ask me (Jack)
 * ≧◡≦.
 * 
 * Also, a brief rant. The version number must be #.#.#. This is not explicitly
 * stated. I used 1.0, and spent 30 minutes debugging why my plugin would
 * silently fail to launch. Bah
 */
@Description(group = "org.texastorque", name = "PowerShuffle", version = "1.0.0", summary = "PowerShuffle! yay ;3")
public final class Main extends Plugin {
    @Override
    public List<DataType> getDataTypes() {
        return List.of(Point2DType.INSTANCE, PIDManagerType.INSTANCE);
    }

    @Override
    public List<ComponentType> getComponents() {
        return List.of(WidgetType.forAnnotatedWidget(Point2DWidget.class),
                WidgetType.forAnnotatedWidget(PIDManagerWidget.class));
    }

    @Override
    public Map<DataType, ComponentType> getDefaultComponents() {
        return Map.of(Point2DType.INSTANCE, WidgetType.forAnnotatedWidget(Point2DWidget.class), PIDManagerType.INSTANCE,
                WidgetType.forAnnotatedWidget(PIDManagerWidget.class));
    }
}