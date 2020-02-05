package pt.upacademy.coreFinalProject.models.questionnaire.converters;

import javax.inject.Inject;

import pt.upacademy.coreFinalProject.models.core.converters.EntityConverter;
import pt.upacademy.coreFinalProject.models.questionnaire.AccountQuestionnaire;
import pt.upacademy.coreFinalProject.models.questionnaire.DTOs.AccountQuestionnaireDTO;
import pt.upacademy.coreFinalProject.services.questionnaire.QuestionnaireService;

public class AccountQuestionnaireConverter extends EntityConverter<AccountQuestionnaire, AccountQuestionnaireDTO>{
	
	@Inject
	private QuestionnaireConverter questionnaireConverter;
	
	@Inject
	private QuestionnaireService questionnaireService;
	
	@Override
	public AccountQuestionnaire toEntity(AccountQuestionnaireDTO dto) {
//		Questionnaire questionnaire = new Questionnaire();
//		if (dto.getId() > 0) {
//			questionnaire.setId(dto.getId());
//		}
//		questionnaire.setQuestionList(
		AccountQuestionnaire account =  new AccountQuestionnaire();
			if (dto.getId() > 0) {
				account.setId(dto.getId());
			}
//			questionnaire.setAccountId(dto.getAccountId());
//			questionnaire.setqType(dto.getqType());
			
			account.setUserId(dto.getUserId());
			account.setUserAcademies(dto.getUserAcademies());
			account.setImageLink(dto.getImageLink());
//				account.setUserId(dto.getUserId());
//				if (dto.getPendingQuentionnaires() != null) {
//					account.setPendingQuentionnairesIds(dto.getPendingQuentionnaires().stream().mapToLong(pendingQuest -> pendingQuest.getId()).toArray());
//				}
//				account.setUserAcademies(userAcademies);
		return account;
	}
	
	@Override
	public AccountQuestionnaireDTO toDTO(AccountQuestionnaire entity) {
		AccountQuestionnaireDTO accountDTO =  new AccountQuestionnaireDTO();
		accountDTO.setId(entity.getId());
		accountDTO.setPendingQuestionnaires(questionnaireConverter.questListToPreviewDTO(questionnaireService.getEmptyQuestionnairesByAccountId(entity.getId())));
		accountDTO.setUserId(entity.getUserId());
		accountDTO.setUserAcademies(entity.getUserAcademies());
		accountDTO.setImageLink(entity.getImageLink());
		return accountDTO;
	}
	
}
