package com.example.meepmeeptesting;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(80, 40, Math.toRadians(150), Math.toRadians(150), 10.456)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(0, 0, Math.toRadians(0)))
                                .splineToSplineHeading(new Pose2d(38, 45, Math.toRadians(180)), Math.toRadians(0))
                                .strafeLeft(10)
                                .lineToSplineHeading(new Pose2d(0, 0, Math.toRadians(90)))
                                .turn(Math.toRadians(-90))
                                .splineToSplineHeading(new Pose2d(38, -45, Math.toRadians(180)), Math.toRadians(0))
                                .strafeRight(10)
                                .lineToSplineHeading(new Pose2d(0, 0, Math.toRadians(0)))
                                .lineToSplineHeading(new Pose2d(56, 0, Math.toRadians(180)))
                                .lineToSplineHeading(new Pose2d(0, 0, 12.56))
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}