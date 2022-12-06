package org.ballad.javacommon.designpattern.builder.motorsample;

/**
 * This is a Sample for Builder Design Pattern.<br>
 * The Builder is used for constructing complex object. Decoupling of the parts
 * and process is the key.<br>
 * When the system resource is not enough, we can use the codes like:
 * <code>MotorDirector.getMotorBuilder(motorBuildType)
 * </code>to get a Builder. Well, this is my perspective.
 * 
 * @author Ballad
 * @date 2011-11-30
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Build a CarMotor.
		MotorBuilder motorBuilder = new CarBuilder();
		MotorDirector motorDirector = new MotorDirector(motorBuilder);
		motorDirector.constructMotor();
		Motor motor = motorBuilder.getResult();

		// The output is "Car Motor".
		System.out.println(motor.getMotorType());
	}
}
