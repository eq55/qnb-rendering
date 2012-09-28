package com.lv.tica.renderer.composite;

import java.util.List;
import java.util.Map;

import com.lv.tica.renderer.ContentRenderer;
import com.lv.tica.renderer.PageKey;

public class CompositeHtmlRenderer implements ContentRenderer {

	private Map<PageKey, List<QuestionComposite>> pageQuestionMetaMap;

	public CompositeHtmlRenderer(
			Map<PageKey, List<QuestionComposite>> pageQuestionMetaMap) {
		this.pageQuestionMetaMap = pageQuestionMetaMap;
	}

	public String renderPage(PageKey pageKey) {
		List<QuestionComposite> questions = pageQuestionMetaMap.get(pageKey);
		StringBuilder sb = new StringBuilder();
		sb.append("<div>");
		for (QuestionComposite questionComposite : questions) {
			sb.append(questionComposite.render());
		}
		sb.append("</div>");
		return sb.toString();
	}

}
