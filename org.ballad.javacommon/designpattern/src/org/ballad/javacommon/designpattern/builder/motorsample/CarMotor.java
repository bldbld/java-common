package org.ballad.javacommon.designpattern.builder.motorsample;

public class CarMotor extends Motor {

	private final MotorPart wheel;
	private final MotorPart engine;
	private final MotorPart body;

	public CarMotor(MotorPart wheel, MotorPart engine, MotorPart body) {
		super("Car Motor");
		this.wheel = wheel;
		this.engine = engine;
		this.body = body;
	}

	public MotorPart getWheel() {
		return wheel;
	}

	public MotorPart getEngine() {
		return engine;
	}

	public MotorPart getBody() {
		return body;
	}

}
