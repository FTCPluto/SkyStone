/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode;

//import android.util.Range;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "Blocks 1 ", group = "AutoOp")

public class Blocks_1 extends LinearOpMode {

    // Drive motors
    DcMotor left_forward;
    DcMotor right_backward;
    DcMotor left_backward;
    DcMotor right_forward;

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
            left_backward = hardwareMap.dcMotor.get("left_backward");
            right_backward = hardwareMap.dcMotor.get("right_backward");
            left_forward = hardwareMap.dcMotor.get("left_forward");
            right_forward = hardwareMap.dcMotor.get("right_forward");
            //making motors run without encoders
            left_forward.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            left_backward.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            right_backward.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            right_forward.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            //setting left motors to reverse so when we go forward and backward, we can use all +/-
            left_backward.setDirection(DcMotor.Direction.REVERSE);
            left_forward.setDirection(DcMotor.Direction.REVERSE);
            //setting the variable F(Finger) to 0.6
            F1.setPosition(0.5);
            F2.setPosition(0.5);
            //setting our two fingers to the variable finger
            F1.setPosition(F);
            F2.setPosition(F);

            //left_forward.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//Sam was here
//
//
//            OpModeIsActive = true;

            //F = 0.6;
            //Motors


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


            //Strafes right
            drive(0.25,-0.25,-0.25,0.25);

            sleep(100);
            brake();

            //moves backwards to line up with the 1st block
            drive(-0.1,-0.1, -0.1,-0.1);

            sleep(50);
            brake();

            //Strafes right into the block
            drive(0.25,-0.25,-0.25,0.25);

            sleep(50);
            brake();

            //Moves the block into the robot
            drive(0.175,0.175,0.175,0.175);

            sleep(50);
            brake();

            //strafes left
            drive(-0.2,0.2,0.2,-0.2);

            sleep(50);
            brake();

            //Moves the block over bridge
            drive(0.275,0.275,0.275,0.275);

            sleep(150);
            brake();

            //moves back under bridge
            drive(-0.15,-0.15,-0.15,-0.15);

            sleep(50);
            brake();

            //lifts fingers
            F1.setPosition(0.5);
            F2.setPosition(0.5);

            sleep(1500);


//
            sleep(1000);

        }

        public void drive(double powerLF, double powerLB, double powerRF, double powerRB) {

            left_forward.setPower(powerLF);
            left_backward.setPower(powerLB);
            right_forward.setPower(powerRF);
            right_backward.setPower(powerRB);
            sleep(1000);
        }

        public void brake() {
            left_forward.setPower(0);
            left_backward.setPower(0);
            right_forward.setPower(0);
            right_backward.setPower(0);
            sleep(1000);
        }
    }

