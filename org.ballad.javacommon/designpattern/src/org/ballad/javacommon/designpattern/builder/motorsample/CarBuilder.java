package org.ballad.javacommon.designpattern.builder.motorsample;

public class CarBuilder implements MotorBuilder {

	private MotorPart body;
	private MotorPart wheel;
	private MotorPart engine;

	@Override
	public void buildBody() {
		body = new MotorPart();
	}

	@Override
	public void buildEngine() {
		engine = new MotorPart();
	}

	@Override
	public void buildWheel() {
		wheel = new MotorPart();
	}

	public Motor getResult() {
		return new CarMotor(wheel, engine, body);
	}

}
