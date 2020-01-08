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


@Autonomous(name = "AutoRedSide", group = "AutoOp")

public class AutoRedSide extends LinearOpMode {

    // Drive motors
    DcMotor left_forward;
    DcMotor right_backward;
    DcMotor left_backward;
    DcMotor right_forward;

    Servo F1;
    Servo F2;

    double F = 0.5;
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



            // Show text "Waiting" when you press init
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

            //Robot strafing right
            drive(0.25,-0.25,-0.25,0.25);

            sleep(500);
            // Stops for a few seconds to not have delay on the right wheel
            brake();

            sleep(1000);

            //drive backwards towards foundation
            drive(-0.15,-0.15,-0.15,-0.15);

            sleep(600);
            brake();
            //Drop fingers
            F1.setPosition(0);
            F2.setPosition(0);

            sleep(900);

            // Rotate the foundation right
            sleep(1600);

            drive(0.25,0.25,-0.25,-0.25);

            sleep(1600);
            brake();

            //lifts fingers
            F1.setPosition(0.5);
            F2.setPosition(0.5);

            // move foundation to the wall
            drive(-0.25,-0.25,-0.25,-0.25);

            sleep(50);
            brake();

            //Robot strafing right
            drive(-0.25,0.25,-0.25,0.25);

            sleep(100);
            brake();


            //Moves back to park under bridge
            drive(-0.2,-0.2,-0.2,-0.2);

            sleep(300);
            brake();

            telemetry.addData("Mode", "Pluto has walked");




// --++ for crab left


            //Pluto's plan


          //Crab left

           // strafe(-1,-1,1,1);
            //sleep(1000);
            //strafe(-1,-1,1,1);
            //sleep(1000);
            //strafe(-.5,-.5,.5,.5);
//            //sleep(1000);
//            while (OpModeIsActive) {
//                F2.setPosition(F);
//                F1.setPosition(F);
//            }
//            //Drive Forward to Sled
//
//            //strafe(0,0,0,0);
//            //sleep(1000);
            //strafe(-1,1,-1,1);
            //sleep(1000);
            //strafe(0,0,0,0);

           // sleep(500);

            //left_forward.setDirection(DcMotorSimple.Direction.REVERSE);
            //right_forward.setDirection(DcMotorSimple.Direction.FORWARD);
            //left_backward.setDirection(DcMotorSimple.Direction.REVERSE);
            //right_backward.setDirection(DcMotorSimple.Direction.FORWARD);

           // left_forward.setPower(1);
            //right_forward.setPower(1);
            //left_backward.setPower(1);
           // right_backward.setPower(1);

            sleep(1000);
           // F = 0;

           // if (OpModeIsActive == true) {
              //  F1.setPosition(F);
               // F2.setPosition(F);
            //}
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

