package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "Pluto_Autonomous", group = "AutoOp")

public class Pluto_7248 extends LinearOpMode {

    // Drive motors
    DcMotor left_forward;
    DcMotor right_backward;
    DcMotor left_backward;
    DcMotor right_forward;


    //Arm motors
    //DcMotor (NAME);
    //DcMotor (NAME);
    //DcMotor (NAME);

    //Arm Servo
    //Servo (NAME);
    //Servo (NAME);
    //Servo (NAME);
    //Servo (NAME);

    //Color Sensor for future additions
        //ColorSensor pocahontas;

    // called when init button is  pressed.
    @Override
    public void runOpMode() throws InterruptedException {
        // Motors
        left_backward = hardwareMap.dcMotor.get("left_backward");
        right_backward = hardwareMap.dcMotor.get("right_backward");
        left_forward = hardwareMap.dcMotor.get("right_forward");
        right_forward = hardwareMap.dcMotor.get("left_forward");

        //Servos
        //(NAME) = hardwareMap.servo.get("NAME");
        //(NAME) = hardwareMap.servo.get("NAME");
        //(NAME) = hardwareMap.servo.get("NAME");
        //(NAME) = hardwareMap.servo.get("NAME");
        //pocahontas = hardwareMap.colorSensor.get("Color_Phone");

        //Motors
        left_forward.setDirection(DcMotor.Direction.REVERSE);
        right_forward.setDirection(DcMotor.Direction.REVERSE);


        // Show text "Waiting when you press init
        telemetry.addData("Mode", "Pluto Waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "Pluto walking");
        telemetry.update();


        //Pluto's plan

        // set motors to 100% power.
        left_forward.setPower(1);
        right_forward.setPower(-1);
        left_backward.setPower(1);
        right_backward.setPower(-1);
        sleep(2000);        // wait for 2 seconds.

        //stop
        left_forward.setPower(0);
        right_forward.setPower(0);
        left_backward.setPower(0);
        right_backward.setPower(0);
        sleep(1000);

        //turn right
       // left_forward.setPower(1);
        //right_forward.setPower(0);
        //left_backward.setPower(1);
        //right_backward.setPower(0);
        //sleep(2000);

        //stop
        //left_forward.setPower(0);
        //right_forward.setPower(0);
        //left_backward.setPower(0);
        //right_backward.setPower(0);
        //sleep(1000);

        // set motors to 100% power.
        //left_forward.setPower(.50);
        //right_forward.setPower(1);
        //left_backward.setPower(.50);
        //right_backward.setPower(1);
        //sleep(2000);        // wait for 2 seconds.

        //stop
        //left_forward.setPower(0);
        //right_forward.setPower(0);
        //left_backward.setPower(0);
        //right_backward.setPower(0);
        //sleep(1000);



    }

}


