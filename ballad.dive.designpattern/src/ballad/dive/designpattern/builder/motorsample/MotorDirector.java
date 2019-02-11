package ballad.dive.designpattern.builder.motorsample;

public class MotorDirector {

	private MotorBuilder motorBuilder;

	public MotorDirector(MotorBuilder motorBuilder) {
		this.motorBuilder = motorBuilder;
	}

	public void constructMotor() {
		motorBuilder.buildBody();
		motorBuilder.buildEngine();
		motorBuilder.buildWheel();
	}
}
