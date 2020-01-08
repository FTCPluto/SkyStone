/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode;

//import android.util.Range;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Arrays;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Pluto Teleop 2.0", group = "TeleOp")
public class Pluto2 extends OpMode {

    //Declare DC Motors
    private static AnalogInput pot;
    private static DcMotor leftFrontWheel;
    private static DcMotor leftBackWheel;
    private static DcMotor rightFrontWheel;
    private static DcMotor rightBackWheel;

    private static DcMotor lift;
    //private static DcMotor crane;

    private static Servo F1;
    private static Servo F2;
    private static Servo elbow;
    private static Servo wrist;

    // private static Servo grabber (shoulder?);
    //private static Servo wrist;e


    //Declare Servo
    private static CRServo shoulder;
    //private static CRServo shoulder;
    double F = 0.5;
    //F for finger


    // Code to run once "INIT" is pressed on the Driver Station Phone
    @Override
    public void init() {

        // Add to the hardware map the motor and the "Name" of the device
        leftBackWheel = hardwareMap.dcMotor.get("left_backward");
        leftFrontWheel = hardwareMap.dcMotor.get("left_forward");
        rightFrontWheel = hardwareMap.dcMotor.get("right_forward");
        rightBackWheel = hardwareMap.dcMotor.get("right_backward");

        lift = hardwareMap.dcMotor.get("lift");
        elbow = hardwareMap.servo.get("elbow");

        F1 = hardwareMap.servo.get("F1");
        F2 = hardwareMap.servo.get("F2");

        shoulder = hardwareMap.crservo.get("shoulder");
        //crane = hardwareMap.dcMotor.get("crane");
        wrist = hardwareMap.servo.get("wrist");

        pot = hardwareMap.analogInput.get("pot");

        // The two motors will be set in the reverse positions
        leftFrontWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackWheel.setDirection(DcMotorSimple.Direction.REVERSE);


        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        int triggerC;
//        triggerC = 0;
//        elbow.setPosition(triggerC);
        //elbow = hardwareMap.servo.get("elbow");
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

        leftFrontWheel.setPower(leftFront);
        rightFrontWheel.setPower(rightFront);
        leftBackWheel.setPower(leftBack);
        rightBackWheel.setPower(rightBack);
    }
    int triggerC;
    float right_trigger = 0;
    float left_trigger = 0;
    double targetPosition = 3.170001;

    @Override
    public void loop() {

        //Code to run once Play is initiated in Teleop

        //Inputs from the control pad to control driving. These are then put into the driving function below
        double inputFB = gamepad1.left_stick_y;
        double inputRL = gamepad1.left_stick_x;
        double inputTurn = gamepad1.right_stick_x;

        double liftPower;

        right_trigger = gamepad2.right_trigger;
        left_trigger = gamepad2.left_trigger;

        double voltReading = (float) pot.getVoltage();
//        convert voltage to distance in cm
        double percentTurned = voltReading; // /5 * 100;

       // telemetry.addData("PercentRot", "percent: " + (percentTurned));


        // Function for driving around
        driveMecanum(inputFB, inputRL, inputTurn);

        /******************************************************************************/
        if (right_trigger > 0) {
            triggerC = triggerC + 1;
        } else if (left_trigger > 0) {
            triggerC = triggerC - 1;
        } else {
            triggerC = triggerC;
        }
        //constraints for triggerC
        if (triggerC > 2) {
            triggerC = 2;
        }
        if (triggerC < 0) {
            triggerC = 0;
        }
        elbow.setPosition(triggerC * 0.5);

/***********************************************************************************/
        elbow.setPosition(1);
        if (gamepad2.dpad_right) {
            elbow.setPosition(0);
        }
        if (gamepad2.a) {
//TODO      press a to hold
            wrist.setPosition(0);
        } else if (gamepad2.b) {
//TODO      press b to release
            wrist.setPosition(1);
        }
        /********************************************************************/
        //double craneMove = (-gamepad2.left_stick_y);
        if (gamepad2.dpad_up) {
            liftPower = 1;
        } else if (gamepad2.dpad_down) {
            liftPower = -0.75;
        } else if (pot.getVoltage() < targetPosition) {
          liftPower = 0.25;
        } else if (pot.getVoltage() > targetPosition) {
            liftPower = -0.25;
        } else {
            liftPower = 0;
        }
         lift.setPower(liftPower);
        /***********************************************************************/
        //TODO     Foundation dragging Hooks

        if (gamepad1.dpad_down) {
            F = 0;

        } else if (gamepad1.dpad_up) {
            F = 0.5;
        }

        F1.setPosition(F);
        F2.setPosition(F);

        /***********************************************************************/

        //Code is for Continous Rotation Servo DIFFERENT CODE
//
        if (gamepad2.b == true) {
            shoulder.setDirection(CRServo.Direction.FORWARD);
            shoulder.setPower(.5);
        } else {
            shoulder.setPower(0);
        }
        if (gamepad2.x == true) {
            shoulder.setDirection(CRServo.Direction.REVERSE);
            shoulder.setPower(0.5);
        } else {
            shoulder.setPower(0);
        }
        /*************************************************************************/
        telemetry.addData("Voltage", voltReading);
        telemetry.addData("Right Trigger", right_trigger);
        telemetry.addData("Left Trigger", left_trigger);
        telemetry.addData("Trigger Count", triggerC);
        telemetry.update();
    }
}