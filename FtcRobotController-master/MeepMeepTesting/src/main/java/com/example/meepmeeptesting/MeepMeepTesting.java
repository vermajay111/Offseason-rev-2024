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
                        drive.trajectorySequenceBuilder(new Pose2d(-50, 38, Math.toRadians(0.00)))
                                .strafeTo(new Vector2d(-30, 0))
                                .lineTo(new Vector2d(10, 0))
                                .strafeTo(new Vector2d(50, 60))
                                .strafeTo(new Vector2d(10, 0))
                                .strafeTo(new Vector2d(50, -53))
                                .lineTo(new Vector2d(-50, -53))
                                .strafeTo(new Vector2d(-50, 38))
                                .build()
                );
        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}