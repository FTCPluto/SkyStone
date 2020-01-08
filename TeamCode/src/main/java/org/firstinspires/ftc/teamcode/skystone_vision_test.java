//package org.firstinspires.ftc.teamcode;
//
//
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
//
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaSkyStone;
//
//import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
//import org.firstinspires.ftc.robotcore.external.tfod.TfodSkyStone;
//
//import java.util.List;
//
//
//@Autonomous(name = "skystone_vision_test (Blocks to Java)", group = "")
//
//@Disabled
//
//public class skystone_vision_test extends LinearOpMode {
//
//
//
//  private VuforiaSkyStone vuforiaSkyStone;
//
//  private TfodSkyStone tfodSkyStone;
//
//
//
//  /**
//
//   * This function is executed when this Op Mode is selected from the Driver Station.
//
//   */
//
//  @Override
//
//  public void runOpMode() {
//
//    vuforiaSkyStone = new VuforiaSkyStone();
//
//    tfodSkyStone = new TfodSkyStone();
//
//
//
//    // Sample TFOD Op Mode
//
//    // Initialize Vuforia.
//
//    // This sample assumes phone is in landscape mode.
//
//    // Rotate phone -90 so back camera faces "forward" direction on robot.
//
//    vuforiaSkyStone.initialize(
//
//        "", // vuforiaLicenseKey
//
//        hardwareMap.get(WebcamName.class, "Webcam 1"), // cameraName
//
//        "", // webcamCalibrationFilename
//
//        true, // useExtendedTracking
//
//        true, // enableCameraMonitoring
//
//        VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES, // cameraMonitorFeedback
//
//        0, // dx
//
//        0, // dy
//
//        0, // dz
//
//        0, // xAngle
//
//        0, // yAngle
//
//        0, // zAngle
//
//        true); // useCompetitionFieldTargetLocations
//
//    // Set min confidence threshold to 0.7
//
//    tfodSkyStone.initialize(vuforiaSkyStone, 0.6F, false, true);
//
//    // Initialize TFOD before waitForStart.
//
//    // Init TFOD here so the object detection labels are visible
//
//    // in the Camera Stream preview window on the Driver Station.
//
//    tfodSkyStone.activate();
//
//    telemetry.addData(">", "Press Play to start");
//
//    telemetry.update();
//
//    // Wait for start command from Driver Station.
//
//    waitForStart();
//
//   if (opModeIsActive()) {
//
//      // Put run blocks here.
//
//      sleep(2000);
//
//      while (opModeIsActive()) {
//
//        // Put loop blocks here.
//
//        UNKNOWN_TYPE[] recognitions;
//        recognitions = tfodSkyStone.getRecognitions();
//
//        // If list is empty, inform the user. Otherwise, go
//
//        // through list and display info for each recognition.
//
//        if (recognitions.size() == 0) {
//
//          telemetry.addData("TFOD", "No items detected.");
//
//        } else {
//
//          index = 0;
//
//          // Iterate through list and call a function to
//
//          // display info for each recognized object.
//
//          // TODO: Enter the type for variable named recognition
//
//          for (UNKNOWN_TYPE recognition : recognitions) {
//
//            // Display info.
//
//            displayInfo(index);
//
//            // Increment index.
//
//            index = index + 1;
//
//          }
//
//        }
//
//        telemetry.update();
//
//        telemetry.addData("# Objects Recognized", recognitions.size());
//
//        if (recognitions.size() == 2) {
//
//          Skystone = -1;
//
//          Stone = -1;
//
//          Stone2 = -1;
//
//          // TODO: Enter the type for variable named recognition
//
//          for (UNKNOWN_TYPE recognition : recognitions) {
//
//            if (recognition.getLabel().equals("Skystone")) {
//
//             Skystone = recognition.getLeft();
//
//              telemetry.addData("Skystone position", Skystone);
//
//            } else if (Stone == -1) {
//
//              Stone = recognition.getLeft();
//
//              telemetry.addData("Stone Position", Stone);
//
//            } else {
//
//              Stone2 = recognition.getLeft();
//
//              telemetry.addData("Stone2 Position", Stone2);
//
//            }
//
//          }
//
//          // Make sure we found one gold mineral and two silver minerals.
//
//          if (Skystone != -1 && Stone != -1) {
//
//            if (Skystone > Stone) {
//
//              telemetry.addData("Skystone Position", "Right");
//
//            } else if (Skystone < Stone) {
//
//              telemetry.addData("Skystone Position", "Center");
//
//            }
//
//          } else if (Stone != -1 && Stone2 != -1) {
//
//            telemetry.addData("Skystone Position", "left");
//
//          }
//
//        } else {
//
//          telemetry.addData("Skystone Position", "no Stones detected");
//
//        }
//
//      }
//
//    }
//
//    // Deactivate TFOD.
//
//
//
//    vuforiaSkyStone.close();
//
//    tfodSkyStone.close();
//
//  }
//
//
//
//  /**
//
//   * Display info (using telemetry) for a recognized object.
//
//   */
//
//  private void displayInfo(
//
//      // TODO: Enter the type for argument named i
//
//      UNKNOWN_TYPE i) {
//
//    // Display label info.
//
//    // Display the label and index number for the recognition.
//
//    telemetry.addData("label " + i, recognition.getLabel());
//
//    // Display upper corner info.
//
//    // Display the location of the top left corner
//
//    // of the detection boundary for the recognition
//
//    telemetry.addData("Left, Top " + i, recognition.getLeft());
//
//    // Display lower corner info.
//
//    // Display the location of the bottom right corner
//
//    // of the detection boundary for the recognition
//
//    telemetry.addData("Right, Bottom " + i, recognition.getRight());
//
//  }
//
//}