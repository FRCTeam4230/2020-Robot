/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class CANId {
        public final static int kDriveL1 = 1;
        public final static int kDriveL2 = 2;
        public final static int kDriveR1 = 3;
        public final static int kDriveR2 = 4;
        public final static int kIntake = 6;
        public final static int kClimber = 5;
        public final static int kArm = 7;
    }

    public static final class driveTrain {
        public final static double speedMult = 0.4;
        public final static double rotMult = 0.5;
        public final static double fastSpeed = 0.8;

        public final static double speedSpeed = 0.75;    }

    public static final class intake {
        public final static double kIntakeSpeed = -0.69;
        public final static double kOuttakeSpeed = 0.69;
    }

    public static final class climber {
        public final static double kUpClimb = -0.75;
        public final static double kDownClimb = 0.75;
    }

    public static final class arm {
        public final static double kArmUpSpeed = -0.269;
        public final static double kArmDownSpeed = 0.269;

    }




}


