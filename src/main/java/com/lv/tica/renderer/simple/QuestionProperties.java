package com.lv.tica.renderer.simple;

public class QuestionProperties {

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

}
