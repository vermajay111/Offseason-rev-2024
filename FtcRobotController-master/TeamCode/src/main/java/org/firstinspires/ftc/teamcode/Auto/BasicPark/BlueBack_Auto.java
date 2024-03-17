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
        telemetry.addLine("Left Spike");
        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(new Pose2d())
                .splineToSplineHeading(new Pose2d(38, 45, Math.toRadians(180)), Math.toRadians(0))
                .strafeLeft(10)
                .lineToSplineHeading(new Pose2d(0, 0, Math.toRadians(90)))
                .turn(Math.toRadians(-90))
                .splineToSplineHeading(new Pose2d(38, -45, Math.toRadians(180)), Math.toRadians(0))
                .strafeRight(10)
                .lineToSplineHeading(new Pose2d(0, 0, Math.toRadians(0)))
                .lineToSplineHeading(new Pose2d(56, 0, Math.toRadians(180)))
                .lineToSplineHeading(new Pose2d(0, 0, 12.56))
                //.splineToSplineHeading(new Pose2d(65, 55), Math.toRadians(720))
                //.forward(-10)
                //.splineTo(new Vector2d(30, 30), 360)
                .build();

        drive.followTrajectorySequence(trajSeq);
        requestOpModeStop();

        if (isStopRequested()) return;

        drive.followTrajectorySequence(trajSeq);
        Pose2d poseEstimate = drive.getPoseEstimate();
        while (!isStopRequested() && opModeIsActive()) ;
    }
}
