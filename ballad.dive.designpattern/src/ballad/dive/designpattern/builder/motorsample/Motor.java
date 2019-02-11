package ballad.dive.designpattern.builder.motorsample;

public abstract class Motor {

	private String motorType;

	protected Motor(String motorType) {
		this.motorType = motorType;
	}

	public String getMotorType() {
		return motorType;
	}
}
