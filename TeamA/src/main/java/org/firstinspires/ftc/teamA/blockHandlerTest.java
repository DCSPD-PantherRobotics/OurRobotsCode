package org.firstinspires.ftc.teamA;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import utils.Toggle;

public class blockHandlerTest extends LinearOpMode {

    private Servo stoneClamp, stoneYawRotator, stoneLPitchRotator, stoneRPitchRotator;

    @Override
    public void runOpMode() {
        stoneClamp = this.hardwareMap.get(Servo.class, "stoneClamp");
        stoneYawRotator = this.hardwareMap.get(Servo.class, "stoneYaw");
        stoneLPitchRotator = this.hardwareMap.get(Servo.class, "stoneLPitch");
        stoneRPitchRotator = this.hardwareMap.get(Servo.class, "stoneRPitch");

        stoneRPitchRotator.setDirection(Servo.Direction.REVERSE);

        Toggle clampToggle = new Toggle();
        Toggle yawToggle = new Toggle();
        Toggle pitchToggle = new Toggle();

        waitForStart();

        while(this.opModeIsActive()) {
            clampToggle.update(this.gamepad1.a);
            yawToggle.update(this.gamepad1.x);
            pitchToggle.update(this.gamepad1.y);

            if(clampToggle.getState()) {
                stoneClamp.setPosition(0.6);
            }
            else {
                stoneClamp.setPosition(1.0);
            }

            if(yawToggle.getState()) {
                stoneYawRotator.setPosition(1);
            }
            else {
                stoneYawRotator.setPosition(0);
            }

            if(pitchToggle.getState()) {
                stoneLPitchRotator.setPosition(1);
                stoneRPitchRotator.setPosition(1);
            }
            else {
                stoneLPitchRotator.setPosition(0);
                stoneRPitchRotator.setPosition(0);
            }
        }



    }

}
