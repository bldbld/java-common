package org.ballad.javacommon.designpattern.proxy.forumsample;

public class ForumProxy implements Forum {

	private final Forum forum;
	private final ForumPermission permission;

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
