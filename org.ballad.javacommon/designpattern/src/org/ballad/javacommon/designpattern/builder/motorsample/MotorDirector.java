package org.ballad.javacommon.designpattern.builder.motorsample;

public class MotorDirector {

	private final MotorBuilder motorBuilder;

	public MotorDirector(MotorBuilder motorBuilder) {
		this.motorBuilder = motorBuilder;
	}

	public void constructMotor() {
		motorBuilder.buildBody();
		motorBuilder.buildEngine();
		motorBuilder.buildWheel();
	}
}
