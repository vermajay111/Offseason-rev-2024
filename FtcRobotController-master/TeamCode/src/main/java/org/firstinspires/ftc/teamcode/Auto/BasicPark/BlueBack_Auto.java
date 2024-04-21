package org.firstinspires.ftc.teamcode.Auto.BasicPark;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "TestAuto")
public class BlueBack_Auto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(-50, 38, Math.toRadians(0.00));
        drive.setPoseEstimate(startPose);
        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(startPose)
                .strafeTo(new Vector2d(-30, 0))
                .lineTo(new Vector2d(10, 0))
                .strafeTo(new Vector2d(50, 60))
                .strafeTo(new Vector2d(10, 0))
                .strafeTo(new Vector2d(50, -53))
                .lineTo(new Vector2d(-50, -53))
                .strafeTo(new Vector2d(-50, 38))
                .build();

        drive.followTrajectorySequence(trajSeq);
        requestOpModeStop();

        if (isStopRequested()) return;

        drive.followTrajectorySequence(trajSeq);
        Pose2d poseEstimate = drive.getPoseEstimate();
        telemetry.update();

        while (!isStopRequested() && opModeIsActive()) ;
    }
}
