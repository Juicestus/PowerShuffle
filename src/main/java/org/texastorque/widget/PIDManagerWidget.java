package org.texastorque.widget;

import org.texastorque.data.PID;

import edu.wpi.first.shuffleboard.api.components.NumberField;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

@Description(name = "PIDManager", dataTypes = PID.class, summary = "A widget that provides PID control :)")
@ParametrizedController("PIDManagerWidget.fxml")
public final class PIDManagerWidget extends SimpleAnnotatedWidget<PID> {
    @FXML
    private Pane root;

    @FXML
    private Label name;

    @FXML
    private NumberField pNumber;

    @FXML
    private NumberField iNumber;

    @FXML
    private NumberField dNumber;

    @FXML
    private NumberField fNumber;

    @FXML
    private NumberField setpoint;

    @FXML
    private void initialize() {
        root.setStyle("-fx-font-size: 10pt;");
        name.textProperty().bind(dataOrDefault.map(pid -> pid.getName()));
        dataProperty().addListener((__, old, newData) -> {
            pNumber.setNumber(newData.getP());
            iNumber.setNumber(newData.getI());
            dNumber.setNumber(newData.getD());
            fNumber.setNumber(newData.getF());
            setpoint.setNumber(newData.getSetpoint());
        });
    }

    @FXML
    private void setP() {
        setData(getData().withP(pNumber.getNumber()));
    }

    @FXML
    private void setI() {
        setData(getData().withI(iNumber.getNumber()));
    }

    @FXML
    private void setD() {
        setData(getData().withD(dNumber.getNumber()));
    }

    @FXML
    private void setF() {
        setData(getData().withF(fNumber.getNumber()));
    }

    @FXML
    private void setSetpoint() {
        setData(getData().withSetpoint(setpoint.getNumber()));
    }

    @Override
    public Pane getView() {
        return root;
    }
}
