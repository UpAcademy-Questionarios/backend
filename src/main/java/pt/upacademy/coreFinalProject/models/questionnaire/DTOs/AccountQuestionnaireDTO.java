package pt.upacademy.coreFinalProject.models.questionnaire.DTOs;

import java.util.List;

import pt.upacademy.coreFinalProject.models.core.DTOS.EntityDTO;

public class AccountQuestionnaireDTO extends EntityDTO{
	private long userId;
	private List<QuestionnairePreviewDTO> pendingQuestionnaires;
	private long[] userAcademies;
		  	
	public AccountQuestionnaireDTO() {}
		  
	
	public AccountQuestionnaireDTO(long id, long userId, List<QuestionnairePreviewDTO> pendingQuentionnaires, long[] userAcademies) {
		 setId(id);
		 this.userId = userId;
		 this.pendingQuestionnaires = pendingQuentionnaires;
		 this.userAcademies = userAcademies;
	}
		  
	public long[] getUserAcademies() {
		return userAcademies;
	}

	public void setUserAcademies(long[] userAcademies) {
		this.userAcademies = userAcademies;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<QuestionnairePreviewDTO> getPendingQuestionnaires() {
		return pendingQuestionnaires;
	}

	public void setPendingQuestionnaires(List<QuestionnairePreviewDTO> pendingQuentionnaires) {
		this.pendingQuestionnaires = pendingQuentionnaires;
	}

}
