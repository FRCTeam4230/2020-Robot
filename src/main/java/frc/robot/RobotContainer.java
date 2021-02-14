/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmUp;
import frc.robot.commands.Auto;
//import frc.robot.commands.AutoLong;
import frc.robot.commands.ClimbDown;
import frc.robot.commands.ClimbUp;
//import frc.robot.commands.DriveFast;
import frc.robot.commands.DriveTeleop;
import frc.robot.commands.InRoller;
import frc.robot.commands.OutRoller;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  final DriveTrain driveTrain = new DriveTrain();
  final Intake intake = new Intake();
  final Arm arm = new Arm();
  final Climber climber = new Climber();

  private final Auto m_autoCommand = new Auto(driveTrain);
  //private final AutoLong m_autoLongCommand = new AutoLong(driveTrain);


  XboxController driver = new XboxController(0);
  XboxController operator = new XboxController(1);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {


       //driveTrain.setDefaultCommand(new DriveTeleop(driveTrain, driver.getRawAxis(1), driver.getRawAxis(4)));
       driveTrain.setDefaultCommand(
        new DriveTeleop(
          driveTrain,
          () -> driver.getY(GenericHID.Hand.kLeft),
          () -> driver.getX(GenericHID.Hand.kRight)));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(operator, 5).whenHeld(new ArmUp(arm));
    new JoystickButton(operator, 6).whenHeld(new ArmDown(arm));
    new JoystickButton(driver, 1).whenHeld(new ArmUp(arm));
    new JoystickButton(driver, 2).whenHeld(new ArmDown(arm));
    new JoystickButton(operator, 3).whenHeld(new ClimbUp(climber));
    new JoystickButton(operator, 4).whenHeld(new ClimbDown(climber));

    // Button shoot = new XboxTrigger(3, driver);

    //shoot.whenHeld(new OutShooter);

    new XboxTrigger(3, driver).whenHeld(new OutRoller(intake));
   // new XboxTrigger(4, driver).whenHeld(new DriveFast(driveTrain));
    new JoystickButton(driver, Button.kBumperRight.value).whenHeld(new InRoller(intake));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public class XboxTrigger extends JoystickButton{
    private int axis;
    private XboxController controller;

    public XboxTrigger(int _axis, XboxController _controller){

      super(_controller, 0);
      controller = _controller;
      axis = _axis;
    }

    @Override
    public boolean get(){
      return controller.getRawAxis(axis) > 0.7;
    }

   }


   }
//fgytrtrfdfredfrfdrffrrryytf

  



