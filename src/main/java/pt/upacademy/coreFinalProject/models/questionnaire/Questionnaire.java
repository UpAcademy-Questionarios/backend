package pt.upacademy.coreFinalProject.models.questionnaire;


import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import pt.upacademy.coreFinalProject.models.core.EntityRoot;


@Entity
@NamedQueries({ 
	@NamedQuery(name = Questionnaire.GET_ALL_QUESTIONNAIRES, query = "SELECT q FROM Questionnaire q"),
	@NamedQuery(name = Questionnaire.GET_ALL_QUESTIONNAIRES_NOT_ANSWERED, query = "SELECT q FROM Questionnaire q WHERE q.accountId = :id AND q.answerList IS EMPTY"),
	@NamedQuery(name = Questionnaire.GET_ALL_ANSWERED_QUESTIONNAIRES, query = "SELECT q FROM Questionnaire q WHERE q.accountId = :id AND q.answerList IS NOT EMPTY"),
	@NamedQuery(name = Questionnaire.GET_ALL_TEMPLATES, query = "SELECT q FROM Questionnaire q WHERE q.template = true"),
	@NamedQuery(name = Questionnaire.GET_TEMPLATE_BY_ID, query = "SELECT q FROM Questionnaire q WHERE q.template = true AND q.id = :id")
})
public class Questionnaire extends EntityRoot{

	public static final String GET_ALL_QUESTIONNAIRES = "getAllQuestionnaire";
	public static final String GET_ALL_QUESTIONNAIRES_NOT_ANSWERED = "getAllQuestionnaireNotAnswered";
	public static final String GET_ALL_ANSWERED_QUESTIONNAIRES = "getAllAnsweredQuestionnaires";
	public static final String GET_ALL_TEMPLATES = "getAllTemplates";
	public static final String GET_TEMPLATE_BY_ID = "getTemplateById";
	private static final long serialVersionUID = 1L;
		
	@OneToMany( cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "questionnaire", fetch = FetchType.EAGER)
	private Set<Question> questionList;
	private String name;
	private long accountId;
	@OneToMany( cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "questionnaire", fetch = FetchType.EAGER)
	private Set<Answer> answerList;
	private Qtype qType;
	private String[] editPrivacy;
	private String[] viewPrivacy;
	private int score;
	private long templateId;
	private boolean template;
	
	public Questionnaire() {}

	public Questionnaire(long id, Set<Question> questionList, String name, long accountId, Qtype qType, String[] editPrivacy,
			String[] viewPrivacy, long templateId, boolean template) {
		setId(id);
		this.questionList = questionList;
		this.name = name;
		this.accountId = accountId;
		this.qType = qType;
		this.editPrivacy = editPrivacy;
		this.viewPrivacy = viewPrivacy;
		this.templateId = templateId;
		this.template = template;
	}

	public Questionnaire(long id, String name, Qtype qType, String[] viewPrivacy) {
		setId(id);
		this.name = name;
		this.qType = qType;
		this.viewPrivacy = viewPrivacy;
	}
	
	public Set<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Set<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(Set<Answer> answerList) {
		this.answerList = answerList;
	}

	public Qtype getqType() {
		return qType;
	}

	public void setqType(Qtype qType) {
		this.qType = qType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String[] getEditPrivacy() {
		return editPrivacy;
	}

	public void setEditPrivacy(String[] editPrivacy) {
		this.editPrivacy = editPrivacy;
	}

	public String[] getViewPrivacy() {
		return viewPrivacy;
	}

	public void setViewPrivacy(String[] viewPrivacy) {
		this.viewPrivacy = viewPrivacy;
	}

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public boolean getTemplate() {
		return template;
	}

	public void setTemplate(boolean template) {
		this.template = template;
	}

	public void calculateScore() {
		double score = this.getAnswerList().stream().filter(answer -> {
			String[] rightAnswer = this.getQuestionList().stream().filter(question -> question.getId() == answer.getQuestionId())
					.findFirst().orElse(null).getRightAnswer();
			return Arrays.equals(answer.getAnswer(), rightAnswer);
		}).count() / (double)this.getAnswerList().size();
		setScore((int)(score * 100.0));
	}

	
}
