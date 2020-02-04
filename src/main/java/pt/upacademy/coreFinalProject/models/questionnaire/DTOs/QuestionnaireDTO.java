package pt.upacademy.coreFinalProject.models.questionnaire.DTOs;

import java.util.Set;

import pt.upacademy.coreFinalProject.models.core.DTOS.EntityDTO;
import pt.upacademy.coreFinalProject.models.questionnaire.Qtype;

public class QuestionnaireDTO extends EntityDTO{

	private Set<QuestionDTO> questionList;
	private String name;
	private long accountId;
	private Qtype qType;
	private String[] editPrivacy;
	private String[] viewPrivacy;
	private Set<AnswerDTO> answerList;
	private int score;
	private long templateId;
	private boolean template;
	private long answerTime;

	public QuestionnaireDTO() {}

	public QuestionnaireDTO(long id, Set<QuestionDTO> questionList, String name, long accountId, Qtype qType,
			String[] editPrivacy, String[] viewPrivacy, Set<AnswerDTO> answerList, int score, long templateId, long createDate,
			long lastModifiedDate, boolean template, long answerTime) {
		setId(id);
		setCreateDate(createDate);
		setLastModifiedDate(lastModifiedDate);
		this.questionList = questionList;
		this.name = name;
		this.accountId = accountId;
		this.qType = qType;
		this.editPrivacy = editPrivacy;
		this.viewPrivacy = viewPrivacy;
		this.answerList = answerList;
		this.score = score;
		this.templateId = templateId;
		this.template = template;
		this.answerTime = answerTime;
	}

	public long getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(long answerTime) {
		this.answerTime = answerTime;
	}

	public Set<QuestionDTO> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Set<QuestionDTO> questionList) {
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

	public Qtype getqType() {
		return qType;
	}

	public void setqType(Qtype qType) {
		this.qType = qType;
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

	public Set<AnswerDTO> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(Set<AnswerDTO> answerList) {
		this.answerList = answerList;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public boolean isTemplate() {
		return template;
	}

	public void setTemplate(boolean template) {
		this.template = template;
	}
	
	
}
