/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;


import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class DriveTeleop extends CommandBase {
  private final DriveTrain driveTrain;
  private final DoubleSupplier speed;
  private final DoubleSupplier rot;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveTeleop(DriveTrain _driveTrain, DoubleSupplier y, DoubleSupplier x) {
    driveTrain = _driveTrain;
    speed = y;
    rot = x;
    // if (speed >= 0.6){
    //   isItGo = 1;
    //   }else{isItGo = 0;}
      
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_driveTrain);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.drive( speed.getAsDouble(), rot.getAsDouble()); 

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
