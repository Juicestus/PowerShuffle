package org.texastorque.data;

import java.util.Map;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

public final class SwerveModule extends ComplexData<SwerveModule> {
  private final double requestedSpeed;
  private final double speed;

  private final double requestedTurn;
  private final double turn;

  public SwerveModule(double requestedSpeed, double speed, double requestedTurn, double turn) {
    this.requestedSpeed = requestedSpeed;
    this.speed = speed;
    this.requestedTurn = requestedTurn;
    this.turn = turn;
  }

  public double getRequestedSpeed() {
    return this.requestedSpeed;
  }

  public double getSpeed() {
    return this.speed;
  }

  public double getRequestedTurn() {
    return this.requestedTurn;
  }

  public double getTurn() {
    return this.turn;
  }

  @Override
  public Map<String, Object> asMap() {
    return Map.of(
        "requestedSpeed", this.requestedSpeed,
        "speed", this.speed,
        "requestedTurn", this.requestedTurn,
        "turn", this.turn);
  }
}
