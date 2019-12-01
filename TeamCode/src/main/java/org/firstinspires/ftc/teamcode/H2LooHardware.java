/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode;

//import android.util.Range;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.Arrays;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Mech Teleop", group = "TeleOp")
public class H2LooHardware extends LinearOpMode {

    // Drive motors
    private static DcMotor left_back;
    private static DcMotor right_back;
    private static DcMotor left_front;
    private static DcMotor right_front;

    //Arm motors
    private DcMotor left_intake;
    private DcMotor right_intake;
    private DcMotor arm;

    //Arm Servo
    private Servo Gripper;
    private Servo Wrist;
   // private Servo intakeL;
   // private Servo intakeR;

    double armPower;
    double armTemp;


    // called when init button is  pressed.
    @Override
    public void runOpMode() throws InterruptedException {
        // Motors
        left_back = hardwareMap.dcMotor.get("left_back");
        right_back = hardwareMap.dcMotor.get("right_back");
        left_front = hardwareMap.dcMotor.get("right_front");
        right_front = hardwareMap.dcMotor.get("left_front");
        left_intake = hardwareMap.dcMotor.get("left_intake");
        right_intake = hardwareMap.dcMotor.get("right_intake");
        arm = hardwareMap.dcMotor.get("arm");

        //Servos
        Gripper = hardwareMap.servo.get("gripper");
        Wrist = hardwareMap.servo.get("wrist");
      // intakeL = hardwareMap.get(Servo.class, "intakeL");
       // intakeR = hardwareMap.get(Servo.class, "intakeR");

        //Motors setting to reverse
        left_front.setDirection(DcMotor.Direction.REVERSE);
        left_back.setDirection(DcMotor.Direction.REVERSE);

       // left_intake.setDirection(DcMotor.Direction.REVERSE);
        //right_intake.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            double inputFB = gamepad1.left_stick_y;
            double inputRL = gamepad1.left_stick_x;
            double inputTurn = gamepad1.right_stick_x;

            driveMecanum(inputFB, inputRL, inputTurn);


            // Intake, Right trigger in, left trigger out
            if (gamepad1.right_trigger > 0.25) {
                left_intake.setPower(1);
                right_intake.setPower(-1);

            } else if (gamepad1.left_trigger > 0.25) {
                left_intake.setPower(-1);
                right_intake.setPower(1);
            } else {
                left_intake.setPower(0);
                right_intake.setPower(0);
            }

            // "A" Close gripper
            if (gamepad2.a) {
                Gripper.setPosition(-0.5);
            } else {
                Gripper.setPosition(1);
            }

            // "Y" rotate wrist in
            if (gamepad2.y) {
                Wrist.setPosition(1);
            } //else {
              // Wrist.setPosition(0);
           // }
           //"x"rotate wrist out
            if (gamepad2.x) {
                Wrist.setPosition(-1);
            }

            // Arm on controller 2 deadzone
            armTemp = gamepad2.left_stick_y;
            if (armTemp < 0.25 && armTemp > -0.25) {
                armPower = 0;
            } else {
                armPower = Math.signum(armTemp) * (Math.abs(armTemp) - 0.25);
            }

            arm.setPower(armPower);

            // Intake Servos
            //if (gamepad2.dpad_down) {
              //  intakeL.setPosition(1);
                //intakeR.setPosition(1);
            } //else if (gamepad2.dpad_up) {
                //intakeL.setPosition(0);
               // intakeR.setPosition(0);
            }




    public static void driveMecanum(double forwards, double horizontal, double turning) {
        double leftFront = forwards + horizontal + turning;
        double leftBack = forwards - horizontal + turning;
        double rightFront = forwards + horizontal - turning;
        double rightBack = forwards - horizontal - turning;


        double[] wheelPowers = {Math.abs(rightFront), Math.abs(leftFront), Math.abs(leftBack), Math.abs(rightBack)};
        Arrays.sort(wheelPowers);
        double biggestInput = wheelPowers[3];
        if (biggestInput > 1) {
            leftFront /= biggestInput;
            leftBack /= biggestInput;
            rightFront /= biggestInput;
            rightBack /= biggestInput;
        }

        left_front.setPower(leftFront);
        right_front.setPower(rightFront);
        left_back.setPower(leftBack);
        right_back.setPower(rightBack);
    }


}

