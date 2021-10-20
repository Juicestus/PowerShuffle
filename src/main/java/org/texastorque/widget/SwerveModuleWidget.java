package org.texastorque.widget;

import edu.wpi.first.shuffleboard.api.components.LinearIndicator;
import org.texastorque.data.SwerveModule;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

@Description(
    name = "SwerveModule",
    dataTypes = SwerveModule.class,
    summary = "A module to display information about a swerve module")
@ParametrizedController("SwerveModuleWidget.fxml")
public final class SwerveModuleWidget extends SimpleAnnotatedWidget<SwerveModule> {
  @FXML private Pane root;

  @FXML private Label Rs;
  @FXML private LinearIndicator RsIndicator;

  @FXML private Label S;
  @FXML private LinearIndicator SIndicator;

  @FXML private Label Rt;
  @FXML private LinearIndicator RtIndicator;

  @FXML private Label T;
  @FXML private LinearIndicator TIndicator;

  @FXML
  private void initialize() {
    this.Rs.textProperty()
        .bind(this.dataOrDefault.map(sm -> sm.getRequestedSpeed()).map(this::doubleToFormat));
    this.RsIndicator.valueProperty().bind(this.dataOrDefault.map(SwerveModule::getRequestedSpeed));

    this.S
        .textProperty()
        .bind(this.dataOrDefault.map(sm -> sm.getSpeed()).map(this::doubleToFormat));
    this.SIndicator.valueProperty().bind(this.dataOrDefault.map(SwerveModule::getSpeed));

    this.Rt.textProperty()
        .bind(this.dataOrDefault.map(sm -> sm.getRequestedTurn()).map(this::doubleToFormat));
    this.RtIndicator.valueProperty().bind(this.dataOrDefault.map(SwerveModule::getRequestedTurn));

    this.T
        .textProperty()
        .bind(this.dataOrDefault.map(sm -> sm.getTurn()).map(this::doubleToFormat));
    this.TIndicator.valueProperty().bind(this.dataOrDefault.map(SwerveModule::getTurn));
  }

  private String doubleToFormat(double x) {
    return String.format("%.3f", x);
  }

  @Override
  public Pane getView() {
    return this.root;
  }
}
