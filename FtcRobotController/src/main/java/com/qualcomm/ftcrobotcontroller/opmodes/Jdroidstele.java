/* Copyright (c) 2014 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
/**public class Jdroidstele extends OpMode {


	final static double ARM_MIN_RANGE  = 0.20;
	final static double ARM_MAX_RANGE  = 0.90;
	final static double CLAW_MIN_RANGE  = 0.20;
	final static double CLAW_MAX_RANGE  = 0.7;
	double armPosition;
	double armDelta = 0.1;
	double clawPosition;
	double clawDelta = 0.1;

	DcMotor motorRight;
	DcMotor motorLeft;
	Servo claw;
	Servo arm;


	 Constructor

	public Jdroidstele() {

	}


	@Override
	public void init() {



		motorRight = hardwareMap.dcMotor.get("motor_2");
		motorLeft = hardwareMap.dcMotor.get("motor_1");
		motorLeft.setDirection(DcMotor.Direction.REVERSE);
		
		arm = hardwareMap.servo.get("servo_1");
		claw = hardwareMap.servo.get("servo_6");


		armPosition = 0.2;
		clawPosition = 0.2;
	@Override
	public void loop() {
		float throttle = -gamepad1.left_stick_y;
		float direction = gamepad1.left_stick_x;
		float right = throttle - direction;
		float left = throttle + direction;
		right = Range.clip(right, -1, 1);
		left = Range.clip(left, -1, 1);
		right = (float)scaleInput(right);
		left =  (float)scaleInput(left);
		motorRight.setPower(right);
		motorLeft.setPower(left);
		if (gamepad1.a) {
			armPosition += armDelta;
		}

		if (gamepad1.y) {
			armPosition -= armDelta;
		}
		if (gamepad1.x) {
			clawPosition += clawDelta;
		}
		if (gamepad1.b) {
			clawPosition -= clawDelta;
		}
        armPosition = Range.clip(armPosition, ARM_MIN_RANGE, ARM_MAX_RANGE);
        clawPosition = Range.clip(clawPosition, CLAW_MIN_RANGE, CLAW_MAX_RANGE);
		arm.setPosition(armPosition);
		claw.setPosition(clawPosition);
        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("arm", "arm:  " + String.format("%.2f", armPosition));
        telemetry.addData("claw", "claw:  " + String.format("%.2f", clawPosition));
        telemetry.addData("left tgt pwr",  "left  pwr: " + String.format("%.2f", left));
        telemetry.addData("right tgt pwr", "right pwr: " + String.format("%.2f", right));
	@Override
	public void stop() {

	}

	double scaleInput(double dVal)  {
		double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
				0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };
		int index = (int) (dVal * 16.0);
		if (index < 0) {
			index = -index;
		}
		if (index > 16) {
			index = 16;
		}
		double dScale = 0.0;
		if (dVal < 0) {
			dScale = -scaleArray[index];
		} else {
			dScale = scaleArray[index];
		}
		return dScale;
	}

}
**/