package pt.upacademy.coreFinalProject.models.questionnaire.DTOs;

import pt.upacademy.coreFinalProject.models.core.DTOS.EntityDTO;
import pt.upacademy.coreFinalProject.models.questionnaire.Qtype;


public class QuestionnairePreviewDTO extends EntityDTO{
	private String name;
	private Qtype qType;
	private String[] editPrivacy;
	private String[] viewPrivacy;
	private int score;
	private long accountId;
	private String userName;
	private long[] userAcademies;

	public QuestionnairePreviewDTO() {}

	public QuestionnairePreviewDTO(long id, String name, Qtype qType, String[] editPrivacy, String[] viewPrivacy,
			long createDate, long lastModifiedDate, int score, long accountId, String userName, long[] userAcademies) {
		setId(id);
		setCreateDate(createDate);
		setLastModifiedDate(lastModifiedDate);
		this.name = name;
		this.qType = qType;
		this.editPrivacy = editPrivacy;
		this.viewPrivacy = viewPrivacy;
		this.score = score;
		this.accountId = accountId;
		this.userName = userName;
		this.userAcademies = userAcademies;
	}

	public long[] getUserAcademies() {
		return userAcademies;
	}

	public void setUserAcademies(long[] userAcademies) {
		this.userAcademies = userAcademies;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
