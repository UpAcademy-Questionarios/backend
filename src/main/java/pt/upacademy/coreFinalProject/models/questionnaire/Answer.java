package pt.upacademy.coreFinalProject.models.questionnaire;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import pt.upacademy.coreFinalProject.models.core.EntityRoot;

@Entity
@NamedQueries({ @NamedQuery(name = Answer.GET_ALL_ANSWERS, query = "SELECT a FROM Answer a")})
public class Answer extends EntityRoot{

	public static final String GET_ALL_ANSWERS = "getAllAnswers_";
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Questionnaire questionnaire;
	private String[] answer;
	private long questionId;
	private boolean rightAnswer;
	private int orderNumber;

	public Answer() {}

	public Answer(long id, Questionnaire questionnaire, String[] answer, long questionId, boolean rightAnswer, int orderNumber) {
		setId(id);
		this.questionnaire = questionnaire;
		this.answer = answer;
		this.questionId = questionId;
		this.rightAnswer = rightAnswer;
		this.orderNumber = orderNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Answer(Questionnaire questionnaire, String[] answer, long questionId, boolean rightAnswer) {
		this.questionnaire = questionnaire;
		this.answer = answer;
		this.questionId = questionId;
		this.rightAnswer = rightAnswer;
	}
	
	public boolean isRightAnswer() {
		return rightAnswer;
	}
	
	public void setRightAnswer(boolean rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
	public Questionnaire getQuestionaire() {
		return questionnaire;
	}

	public void setQuestionaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public void verifyAnswer(String[] rightAnswer) {
		setRightAnswer(Arrays.equals(getAnswer(), rightAnswer));
	}

}
