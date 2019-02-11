package ballad.dive.designpattern.proxy.forumsample;

public class ForumProxy implements Forum {

	private Forum forum;
	private ForumPermission permission;

	public ForumProxy(Forum forum, ForumPermission permission) {
		super();
		this.forum = forum;
		this.permission = permission;
	}

	@Override
	public void setForumName(String name) {
		if (this.permission.isForumAdmin()) {
			forum.setForumName(name);
		} else {
			// Do some thing like:
			// Throw Exceptions or Output to logs.
		}
	}

	@Override
	public String getForumName() {
		return forum.getForumName();
	}
}
