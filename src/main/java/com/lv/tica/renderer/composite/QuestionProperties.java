package com.lv.tica.renderer.composite;

public class QuestionProperties implements QuestionComposite{

	private String label;
	private String model;
	private String questionType;

	public QuestionProperties(String label, String model, String questionType) {
		this.label = label;
		this.model = model;
		this.questionType = questionType;
	}

	public String getLabel() {
		return label;
	}

	public String getQuestionType() {
		return questionType;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String render() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s<input type=\"%s\" name=\"%s\"/>", label, questionType, model));
		return sb.toString();
	}
}
