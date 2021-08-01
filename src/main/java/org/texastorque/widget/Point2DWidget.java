package org.texastorque.widget;

import org.texastorque.data.Point2D;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

@Description(name = "Point2DWidget", dataTypes = Point2D.class, summary = "A very simple widget that displays X&Y coordinates")
@ParametrizedController("Point2DWidget.fxml")
public final class Point2DWidget extends SimpleAnnotatedWidget<Point2D> {
    @FXML
    private Pane root;

    @FXML
    private Label xCordView;

    @FXML
    private Label yCordView;

    @FXML
    private void initialize() {
        xCordView.textProperty().bind(dataOrDefault.map(point -> point.getX()).map(x -> "X: " + x));
        yCordView.textProperty().bind(dataOrDefault.map(point -> point.getY()).map(y -> "Y: " + y));
    }

    @Override
    public Pane getView() {
        return root;
    }
}