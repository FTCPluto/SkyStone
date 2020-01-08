/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode;

//import android.util.Range;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Arrays;

import static java.lang.Thread.sleep;




@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "austintest", group = "TeleOp")
public class drive_meccanum extends LinearOpMode {

    // Drive motors
    private static DcMotor left_back;
    private static DcMotor right_back;
    private static DcMotor left_front;
    private static DcMotor right_front;


    // called when init button is  pressed.
    @Override
    //
    // public void init() {
    public void runOpMode() throws InterruptedException {
        // Motors
        left_back = hardwareMap.dcMotor.get("left_back");
        right_back = hardwareMap.dcMotor.get("right_back");
        left_front = hardwareMap.dcMotor.get("right_front");
        right_front = hardwareMap.dcMotor.get("left_front");



        waitForStart();

        while (opModeIsActive()) {
            double inputFB = gamepad1.left_stick_y;
            double inputRL = gamepad1.left_stick_x;
            double inputTurn = gamepad1.right_stick_x;

            if (gamepad1.dpad_right) {
                driveMechanum(0,0.25,0);
            } else if (gamepad1.dpad_left) {
                driveMechanum(0,-0.25,0);

            } else if (gamepad1.dpad_up){
                driveMechanum(-0.25,0,0);

            } else if (gamepad1.dpad_down){
                driveMechanum(0.25,0,0);
            }else {
                driveMechanum(inputFB, inputRL, inputTurn);
            }




        }

    }
    public static void driveMechanum ( double forwards, double horizontal, double turning) {
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
