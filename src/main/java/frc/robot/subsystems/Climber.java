/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private final CANSparkMax climber;
  

  public Climber() {

    climber = new CANSparkMax(Constants.CANId.kClimber, MotorType.kBrushless);

  }

  public void climberUp() {
    climber.set(Constants.climber.kUpClimb);
  }

  public void climberDown() {
    climber.set(Constants.climber.kDownClimb);
  }


  public void stop() {
    climber.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run. why? idk
  }
}
