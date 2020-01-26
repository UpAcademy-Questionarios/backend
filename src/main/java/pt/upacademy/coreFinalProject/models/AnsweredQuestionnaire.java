package pt.upacademy.coreFinalProject.models;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name = AnsweredQuestionnaire.GET_ALL_ANSWEREDQUESTIONS, query = "SELECT a FROM AnsweredQuestionnaire a"),
		@NamedQuery(name = AnsweredQuestionnaire.GET_ALL_ANSWEREDQUESTIONS_ID, query = " SELECT a FROM AnsweredQuestionnaire a WHERE a.accountId =  :id") })
public class AnsweredQuestionnaire extends EntityRoot {

	public static final String GET_ALL_ANSWEREDQUESTIONS = "getAllAnsweredQuestions";
	public static final String GET_ALL_ANSWEREDQUESTIONS_ID = "getAllAnsweredQuestionsByID";
	private static final long serialVersionUID = 1L;

	// CascadeType.MERGE => Automatically updates Question after Questionnaire is
	// updated
	// CascadeType.PERSIST => Automatically creates Question after Questionnaire is
	// created with Questions
	// FetchType.EAGER => loads questionList when Questionnaire is loaded
	@OneToMany(cascade = { CascadeType.MERGE,
			CascadeType.PERSIST }, mappedBy = "answeredQuestionaire", fetch = FetchType.EAGER)
	private Set<Answer> answerList;
	private long questionnaireId;
	private long accountId;
	private Qtype qType;
	private LocalDate date;
	private int score;

	public AnsweredQuestionnaire() {
	}

	public AnsweredQuestionnaire(long id, Set<Answer> answerList, long questionnaireId, long accountId, Qtype qType,
			LocalDate date, int score) {
		setId(id);
		this.answerList = answerList;
		this.questionnaireId = questionnaireId;
		this.accountId = accountId;
		this.qType = qType;
		this.date = date;
		this.score = score;
	}

	public Set<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(Set<Answer> answerList) {
		this.answerList = answerList;
	}

	public long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Qtype getqType() {
		return qType;
	}

	public void setqType(Qtype qType) {
		this.qType = qType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
