package pt.upacademy.coreFinalProject.models.questionnaire.DTOs;

import pt.upacademy.coreFinalProject.models.core.DTOS.EntityDTO;
import pt.upacademy.coreFinalProject.models.questionnaire.AnswerType;

public class QuestionDTO extends EntityDTO {

	private long questionnarieId;
	private String question;
	private AnswerType aType;
	private String[] options;
	private String[] rightAnswer;
	private int orderNumber;
	
	public QuestionDTO() {}


	public QuestionDTO(long id, long questionnarieId, String question, AnswerType aType, String[] options, String[] rightAnswer, int orderNumber) {
		setId(id);
		this.questionnarieId = questionnarieId;
		this.question = question;
		this.aType = aType;
		this.options = options;
		this.rightAnswer = rightAnswer;
		this.orderNumber = orderNumber;
	}

	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public AnswerType getaType() {
		return aType;
	}
	
	public void setaType(AnswerType aType) {
		this.aType = aType;
	}
	
	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String[] getRightAnswer() {
		return rightAnswer;
	}
	
	public void setRightAnswer(String[] rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
	public long getQuestionnarieId() {
		return questionnarieId;
	}
	
	public void setQuestionnarieId(long questionnarieId) {
		this.questionnarieId = questionnarieId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
