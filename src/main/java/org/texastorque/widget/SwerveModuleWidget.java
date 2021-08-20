package org.texastorque.widget;

import org.texastorque.data.SwerveModule;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

@Description(name = "SwerveModule", dataTypes = SwerveModule.class, summary = "A module to display information about a swerve module")
@ParametrizedController("SwerveModuleWidget.fxml")
public final class SwerveModuleWidget extends SimpleAnnotatedWidget<SwerveModule> {
    @FXML
    private Pane root;

    @FXML
    private Label Rs;

    @FXML
    private Label S;

    @FXML
    private Label Rt;

    @FXML
    private Label T;

    @FXML
    private void initialize() {
        System.out.println("initializing");
        Rs.textProperty()
                .bind(dataOrDefault.map(sm -> sm.getRequestedSpeed()).map(l -> "Requested Speed" + doubleToFormat(l)));
        S.textProperty().bind(dataOrDefault.map(sm -> sm.getSpeed()).map(l -> "Speed: " + doubleToFormat(l)));
        Rt.textProperty()
                .bind(dataOrDefault.map(sm -> sm.getRequestedTurn()).map(l -> "Requested Turn: " + doubleToFormat(l)));
        T.textProperty().bind(dataOrDefault.map(sm -> sm.getTurn()).map(l -> "Turn: " + doubleToFormat(l)));
    }

    private String doubleToFormat(double x) {
        System.out.println("in double to format!");
        // return String.format("%.3f", x);
        return "" + x;
    }

    @Override
    public Pane getView() {
        return root;
    }

}
