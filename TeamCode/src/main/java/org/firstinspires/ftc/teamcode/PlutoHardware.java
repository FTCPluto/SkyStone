/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode;

//import android.util.Range;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Arrays;



@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Pluto Teleop", group = "TeleOp")
public class PlutoHardware extends OpMode{

    //Declare DC Motors
    private static DcMotor leftFrontWheel;
    private static DcMotor leftBackWheel;
    private static DcMotor rightFrontWheel;
    private static DcMotor rightBackWheel;
    //private static DcMotor crane;

    //Declare Servo

    //private static Servo arm;
    //private static Servo elbow;
    //private static Servo hand;

    //Declare Anything else


    //Configuration settings

    //double servoPosition;
    //double servoDelta = 0.5;

    //double elbowPosition;
   // double elbowDelta = 0.01;

    //double armUp;
    //double armDown;

    //double handPosition;
    //double handDelta = 0.5;


    // Code to run once "INIT" is pressed on the Driver Station Phone
    @Override
    public void init() {

        // Add to the hardware map the motor and the "Name" of the device
        leftFrontWheel = hardwareMap.dcMotor.get("left_forward");
        leftBackWheel = hardwareMap.dcMotor.get("left_backward");
        rightFrontWheel = hardwareMap.dcMotor.get("right_forward");
        rightBackWheel = hardwareMap.dcMotor.get("right_backward");

        //crane = hardwareMap.dcMotor.get("crane");


        // The two motors will be set in the reverse positions
        leftFrontWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackWheel.setDirection(DcMotorSimple.Direction.REVERSE);

        //arm = hardwareMap.servo.get("arm");
        //servoPosition = 0.5;

        //hand = hardwareMap.servo.get("hand");
        //handPosition = 0.5;

        //elbow = hardwareMap.servo.get("elbow");
        //elbowPosition = 0.5;




    }

    @Override
    public void loop() {

        //Code to run once Play is initiated in Teleop

        //Inputs from the control pad to control driving. These are then put into the driving function below
        double inputFB = -gamepad1.left_stick_y;
        double inputRL = -gamepad1.left_stick_x;
        double inputTurn = gamepad1.right_stick_x;

        //double craneMove = (-gamepad2.left_stick_y);



        //the negative signs in front of the gamepad inputs may need to be removed.
       // if ( gamepad2.a){
         //   servoPosition -= servoDelta;
           // arm.setPosition(servoPosition);
            //arm.
        //}
        //if (gamepad2.b){
          //  servoPosition += servoDelta;
            //arm.setPosition(servoPosition);
        //}
       //if ( gamepad2.x){
         //   handPosition += handDelta;
          // hand.setPosition((handPosition));
        //}

        //if ( gamepad2.y){
          //  handPosition -= handDelta;
            //hand.setPosition((handPosition));
        //}

        //crane.setPower(.5*craneMove);

        //if ( gamepad1.x){
            //elbowPosition -= handDelta;
          //  elbow.setPosition((elbowPosition));
        //}

        //if ( gamepad1.y){
           // elbowPosition -= handDelta;
           // elbow.setPosition((elbowPosition));
        //}

       // double armUp = gamepad2.left_trigger;
       // double armDown = gamepad2.right_trigger;


        //Function that drives the robot

        driveMecanum(inputFB, inputRL, inputTurn); // Function for driving around
        //moveArm(armUp, armDown); // Function for moving crane up and down
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


    //public static void moveArm(double armUp, double armDown) {
       // double max;

         //Normalize the values so neither exceed +/- 1.0

       // max = Math.max(Math.abs(armUp), Math.abs(armDown));
       // if (max > 1.0)
        //{
          //  armUp /= max;
           // armDown /= max;
        //}

         //Output the safe vales to the motor drives.

        //crane.setPower(armUp);
        //crane.setPower(armDown);

    }


