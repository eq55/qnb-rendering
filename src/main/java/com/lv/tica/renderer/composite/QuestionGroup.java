package com.lv.tica.renderer.composite;

import java.util.ArrayList;
import java.util.List;

public class QuestionGroup implements QuestionComposite {
	
	List<QuestionComposite> childrenNodes = new ArrayList<QuestionComposite>();
	private String groupIdentifier;
	
	public QuestionGroup(String groupIdentifier) {
		this.groupIdentifier = groupIdentifier;
	}

	@Override
	public String render() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"" + groupIdentifier + "\">");
		for (QuestionComposite child : childrenNodes) {
			sb.append(child.render());
		}
		sb.append("</div>");
		return sb.toString();
	}

	public void add(QuestionComposite questionComposite) {
		childrenNodes.add(questionComposite);
	}

}
