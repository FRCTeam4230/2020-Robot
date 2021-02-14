/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
/**
   * Creates a new ExampleSubsystem.
   */
  private final DifferentialDrive driveSys;
  private double speedModifier = 0.7;
  private CANSparkMax m_frontLeft;

  public DriveTrain() {

    m_frontLeft = new CANSparkMax(Constants.CANId.kDriveL1, MotorType.kBrushless);
    CANSparkMax m_backLeft = new CANSparkMax(Constants.CANId.kDriveL2, MotorType.kBrushless);

    SpeedControllerGroup m_left = new SpeedControllerGroup(m_backLeft, m_frontLeft);

    CANSparkMax m_frontRight = new CANSparkMax(Constants.CANId.kDriveR1, MotorType.kBrushless);
    CANSparkMax m_backRight = new CANSparkMax(Constants.CANId.kDriveR2, MotorType.kBrushless);

    SpeedControllerGroup m_right = new SpeedControllerGroup(m_backRight, m_frontRight);

    driveSys = new DifferentialDrive(m_left, m_right);
  }

  public CANSparkMax retSparkMax() {
    return m_frontLeft;
  }

  public void slowDrive(){
    speedModifier = Constants.driveTrain.speedMult;
  }
  public void fastDrive(){
    speedModifier = Constants.driveTrain.fastSpeed;
  }

  public void drive(double speed, double rot) {
    driveSys.arcadeDrive(speed*speedModifier, rot*Constants.driveTrain.rotMult);
  }

  public void stop (){
    driveSys.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
