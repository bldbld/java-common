package ballad.dive.designpattern.proxy.gfwsample;

public class WebSite implements ShowPage {

	@Override
	public void shwoPage(String url) {
		System.out.println("Hello " + url);
	}
}