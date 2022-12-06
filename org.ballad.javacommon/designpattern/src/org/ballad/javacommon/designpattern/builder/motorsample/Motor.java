package org.ballad.javacommon.designpattern.builder.motorsample;

public abstract class Motor {

	private final String motorType;

	protected Motor(String motorType) {
		this.motorType = motorType;
	}

	public String getMotorType() {
		return motorType;
	}
}
