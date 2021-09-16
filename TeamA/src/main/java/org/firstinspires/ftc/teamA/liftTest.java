package org.firstinspires.ftc.teamA;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import utils.PIDFmanager;

@TeleOp
public class liftTest extends LinearOpMode {

    private DcMotor lLift, rLift;
    @Override
    public void runOpMode() {
        lLift = this.hardwareMap.get(DcMotor.class, "lLift");
        rLift = this.hardwareMap.get(DcMotor.class, "rLift");

        rLift.setDirection(DcMotorSimple.Direction.REVERSE);

        PIDFmanager.setPIDF(lLift);
        PIDFmanager.setPIDF(rLift);

        lLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();

        while(this.opModeIsActive())
        {
            if(this.gamepad1.left_bumper)
            {
                lLift.setPower(0.3);
                rLift.setPower(0.3);
            }
            else if(this.gamepad1.right_bumper)
            {
                lLift.setPower(-0.3);
                rLift.setPower(-0.3);
            }
            else
            {
                lLift.setPower(0);
                rLift.setPower(0);
            }
        }

    }

}
