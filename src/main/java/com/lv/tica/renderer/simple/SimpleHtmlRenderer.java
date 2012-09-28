package com.lv.tica.renderer.simple;

import java.util.List;
import java.util.Map;

import com.lv.tica.renderer.ContentRenderer;
import com.lv.tica.renderer.PageKey;

public class SimpleHtmlRenderer implements ContentRenderer {

	private Map<PageKey, List<QuestionProperties>> pageQuestionMetaMap;

	public SimpleHtmlRenderer(
			Map<PageKey, List<QuestionProperties>> pageQuestionMetaMap) {
		this.pageQuestionMetaMap = pageQuestionMetaMap;
	}

	public String renderPage(PageKey pageKey) {
		List<QuestionProperties> questions = pageQuestionMetaMap.get(pageKey);
		StringBuilder sb = new StringBuilder();
		sb.append("<div>");
		for (QuestionProperties question : questions) {
			sb.append(String.format("%s<input type=\"%s\" name=\"%s\"/>", question.getLabel(), question.getQuestionType(), question.getModel()));
		}
		sb.append("</div>");
		return sb.toString();
	}

}
