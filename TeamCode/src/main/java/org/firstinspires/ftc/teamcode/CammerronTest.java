/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode;

//import android.util.Range;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "Autonomous 7247", group = "AutoOp")

public class CammerronTest extends LinearOpMode {

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
        Servo intakeL;
        Servo intakeR;

        //Color Sensor for future additions
//        ColorSensor pocahontas;

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

            //Servos
            Gripper = hardwareMap.servo.get("gripper");
            Wrist = hardwareMap.servo.get("wrist");
            //intakeL = hardwareMap.servo.get("intakeL");
          //  intakeR = hardwareMap.servo.get("intakeR");
//            pocahontas = hardwareMap.colorSensor.get("Color_Phone");

            //Motors
            left_front.setDirection(DcMotor.Direction.REVERSE);
            right_back.setDirection(DcMotor.Direction.REVERSE);

            left_intake.setDirection(DcMotor.Direction.REVERSE);

            // Show text "Waiting when you press init
            telemetry.addData("Mode", "Pluto Waiting");
            telemetry.update();

            // wait for start button.

            waitForStart();

            telemetry.addData("Mode", "Pluto walking");
            telemetry.update();



            //Pluto's plan


            // set motors to 100% power.
            left_front.setPower(.25);
            right_front.setPower(.25);
            left_back.setPower(.25);
            right_back.setPower(.25);
            //right_back.setPower(.5);

            sleep(2000);        // wait for 2 seconds.

            // set motor power to zero to stop motors.
            left_front.setPower(0);
            right_front.setPower(0);
            left_back.setPower(0);
            right_back.setPower(0);


        }

    }

