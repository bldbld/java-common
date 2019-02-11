package ballad.dive.designpattern.builder.motorsample;

public class CarMotor extends Motor {

	private MotorPart wheel;
	private MotorPart engine;
	private MotorPart body;

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
