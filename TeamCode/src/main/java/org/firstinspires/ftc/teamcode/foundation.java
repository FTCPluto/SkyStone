package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "foundation_red", group = "AutoOp")

public class foundation extends LinearOpMode{


    // public class CammerronTest extends LinearOpMode {

    // Drive motors
    DcMotor left_back;
    DcMotor right_back;
    DcMotor left_front;
    DcMotor right_front;


    //Arm motors
    DcMotor left_intake;
    DcMotor right_intake;
    DcMotor arm;

    //Arm Servo
    Servo Gripper;
    Servo Wrist;
    Servo foundationL;
    Servo founationR;


    //Color Sensor for future additions
//        ColorSensor pocahontas;

    // called when init button is  pressed.
    @Override
    public void runOpMode() {
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
        foundationL = hardwareMap.servo.get("foundationL");
        founationR = hardwareMap.servo.get("foundationR");
        //something Cammerron made
        // pocahontas = hardwareMap.colorSensor.get("Color_Phone");

        //Motors
        left_front.setDirection(DcMotor.Direction.REVERSE);
        right_back.setDirection(DcMotor.Direction.REVERSE);

        left_intake.setDirection(DcMotor.Direction.REVERSE);

        // Show text "Waiting when you press init
        telemetry.addData("Mode", "loo bots Waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "loo bots walking");
        telemetry.update();


        //start of auto

        sleep(0);
        // go forward
        left_front.setPower(.15);
        right_front.setPower(.15);
        left_back.setPower(-.15);
        right_back.setPower(-.15);

        sleep(1500);        // wait for 1 1/2 seconds.

        //  stop motors.
        left_front.setPower(0);
        right_front.setPower(0);
        left_back.setPower(0);
        right_back.setPower(0);

        sleep(100);


        // go sideways
        left_front.setPower(.25);
        right_front.setPower(.25);
        left_back.setPower(.25);
        right_back.setPower(.25);

        sleep(500);        // wait for  1/2 seconds.





        //go forward
        sleep(0);
        left_front.setPower(.15);
        right_front.setPower(.15);
        left_back.setPower(-.15);
        right_back.setPower(-.15);

        sleep(1000);        // wait for 1  seconds.


        // foundation servos down

        founationR.setPosition(-.25);
        foundationL.setPosition(.25);

        sleep(900);


        sleep(0);
        // .
        left_front.setPower(-.25);
        right_front.setPower(-.25);
        left_back.setPower(.25);
        right_back.setPower(.25);

        sleep(1500);        // wait for 1 1/2 seconds.


        //turn

        left_back.setPower(1);
        right_back.setPower(-1);
        left_front.setPower(-1);
        right_front.setPower(1);

        sleep(1200);


        //tells motors to stop

        left_front.setPower(0);
        right_front.setPower(0);
        left_back.setPower(0);
        right_back.setPower(0);

        sleep(100);


        //sideways a bit

        //left_front.setPower(.25);
        //right_front.setPower(.25);
        //left_back.setPower(.25);
        //right_back.setPower(.25);

        //sleep(1200);



        //forward a bit

        left_front.setPower(.25);
        right_front.setPower(.25);
        left_back.setPower(-.25);
        right_back.setPower(-.25);

        sleep(900);

        //tells motors to stop

        left_front.setPower(0);
        right_front.setPower(0);
        left_back.setPower(0);
        right_back.setPower(0);

        sleep(100);

        //lift servos up

        foundationL.setPosition(0);
        founationR.setPosition(1);

        sleep(2000);


        sleep(0);
        // set motors to 100% power.
        left_front.setPower(.15);
        right_front.setPower(.15);
        left_back.setPower(-.15);
        right_back.setPower(-.15);

        sleep(250);        // wait for 1 1/2 seconds.

        sleep(0);
        // set motors to 100% power.
        left_front.setPower(0);
        right_front.setPower(0);
        left_back.setPower(0);
        right_back.setPower(0);

        sleep(1000);        // wait for 1 1/2 seconds.

        //drive back

        left_front.setPower(-.75);
        right_front.setPower(-.75);
        left_back.setPower(.75);
        right_back.setPower(.75);

        sleep(1200);

        //tells robot to stop

        left_front.setPower(0);
        right_front.setPower(0);
        left_back.setPower(0);
        right_back.setPower(0);

        sleep(100);

    }
}

