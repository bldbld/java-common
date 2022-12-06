package org.ballad.javacommon.designpattern.builder.motorsample;

public interface MotorBuilder {

	void buildBody();

	void buildWheel();

	void buildEngine();

	Motor getResult();
}
