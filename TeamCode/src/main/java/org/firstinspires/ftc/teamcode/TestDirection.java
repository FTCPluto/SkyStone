/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode;

//import android.util.Range;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "TestDirection", group = "AutoOp")

public class TestDirection extends LinearOpMode {

    // Drive motors
    DcMotor leftFrontWheel;
    DcMotor rightFrontWheel;
    DcMotor leftBackWheel;
    DcMotor rightBackWheel;

    Servo F1;
    Servo F2;

    double F = 0.6;
//    boolean OpModeIsActive;

        //Color Sensor for future additions
//        ColorSensor pocahontas;

        // called when init button is  pressed.
        @Override
        public void runOpMode() throws InterruptedException {
            // Servos
            F1 = hardwareMap.servo.get("F1");
            F2 = hardwareMap.servo.get("F2");
            //wheels
            leftBackWheel = hardwareMap.dcMotor.get("left_backward");
            leftFrontWheel = hardwareMap.dcMotor.get("left_forward");
            rightFrontWheel = hardwareMap.dcMotor.get("right_forward");
            rightBackWheel = hardwareMap.dcMotor.get("right_backward");



            //setting left motors to reverse so when we go forward and backward, we can use all +/-
            leftBackWheel.setDirection(DcMotorSimple.Direction.REVERSE);
            leftFrontWheel.setDirection(DcMotorSimple.Direction.REVERSE);



            //setting the variable F(Finger) to 0.6
            F1.setPosition(0.5);
            F2.setPosition(0.5);
            //setting our two fingers to the variable finger
            F1.setPosition(F);
            F2.setPosition(F);



            // Show text "Waiting when you press init
            telemetry.addData("Mode", "Pluto Waiting");
            telemetry.update();

            // wait for start button.

            waitForStart();
//            if (OpModeIsActive) {
//                F1.setPosition(F);
//                F2.setPosition(F);
//            }

           // sleep(5000);

            telemetry.addData("Mode", "Pluto walking");
            telemetry.update();


            //Runs to bridge
            //drive(0.25,0.25,0.25,0.25);
            drive(1,1,1,1);
            brake();
        }

        public void drive(double powerLF, double powerLB, double powerRF, double powerRB) {

            leftFrontWheel.setPower(powerLF);
            leftBackWheel.setPower(powerLB);
            rightFrontWheel.setPower(powerRF);
            rightBackWheel.setPower(powerRB);
            sleep(1000);
        }
        public void brake() {
            leftFrontWheel.setPower(0);
            leftBackWheel.setPower(0);
            rightFrontWheel.setPower(0);
            rightBackWheel.setPower(0);
            sleep(1000);


        }
    }

