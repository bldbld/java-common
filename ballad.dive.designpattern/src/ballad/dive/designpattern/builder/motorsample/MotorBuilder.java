package ballad.dive.designpattern.builder.motorsample;

public interface MotorBuilder {

	public void buildBody();

	public void buildWheel();

	public void buildEngine();

	public Motor getResult();
}
