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
                .setConstraints(40, 20, Math.toRadians(150), Math.toRadians(30), 10.456)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37, 55, Math.toRadians(0.00)))
                                .splineToConstantHeading(new Vector2d(50, -55), Math.toRadians(0))
                                .strafeTo(new Vector2d(50, 40))
                                .splineToConstantHeading(new Vector2d(-34, -55), Math.toRadians(0))
                                .splineToConstantHeading(new Vector2d(-37, 55), Math.toRadians(0))
                                .build()
                );
        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}