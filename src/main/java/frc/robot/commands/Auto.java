/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import com.revrobotics.EncoderType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class Auto extends CommandBase {
  private final DriveTrain driveTrain;
  private final double autoSpeed = 0.5;
  private final double autoRot = 0.0;

  double startTime;
  double encoder;
  boolean runOnce = true;


  /**
   * Creates a new ExampleCommand.
   *
   * @param _driveTrain The subsystem used by this command.
   */
  public Auto(DriveTrain _driveTrain) {
    driveTrain = _driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    encoder = driveTrain.retSparkMax().getEncoder(EncoderType.kQuadrature, 1).getPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(runOnce){
      startTime = Timer.getFPGATimestamp();
      runOnce = false;
    }

    driveTrain.drive(autoSpeed, autoRot);
    SmartDashboard.putNumber("EncoderVelocity", encoder);
    SmartDashboard.putNumber("EncoderVelocity", driveTrain.retSparkMax().getEncoder(EncoderType.kQuadrature, 1).getPosition());
    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Timer.getFPGATimestamp() > 1.0 + startTime) {
    //if(encoder + 2000 > driveTrain.retSparkMax().getEncoder().getPosition()){
      return true;
  }else{
    return false;
  }
}

}