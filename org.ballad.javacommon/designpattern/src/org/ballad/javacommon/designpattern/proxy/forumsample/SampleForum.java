package org.ballad.javacommon.designpattern.proxy.forumsample;

public class SampleForum implements Forum {

	private String forumName = "Sample Forum";

	@Override
	public void setForumName(String name) {
		this.forumName = name;
		// Then commit to database.
	}

	@Override
	public String getForumName() {
		return this.forumName;
	}
}
