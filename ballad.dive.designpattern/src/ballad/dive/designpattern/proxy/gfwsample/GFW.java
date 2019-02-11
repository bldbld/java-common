package ballad.dive.designpattern.proxy.gfwsample;

public class GFW implements ShowPage {
	private int crossTheWall;
	private WebSite website;

	public GFW(int crossTheWall, WebSite website) {
		super();
		this.crossTheWall = crossTheWall;
		this.website = website;
	}

	@Override
	public void shwoPage(String url) {
		if (crossTheWall == 1) {
			website.shwoPage(url);
		} else {
			System.out.println("Œﬁ∑®∑√Œ ∫«∫«");
		}
	}
}
