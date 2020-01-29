package pt.upacademy.coreFinalProject.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import pt.upacademy.coreFinalProject.models.Questionnaire;
import pt.upacademy.coreFinalProject.models.DTOS.QuestionnairePreviewDTO;

@RequestScoped
public class QuestionnaireRepository extends EntityRepository<Questionnaire>{

	@Override
	protected Class<Questionnaire> getEntityClass() {
		return Questionnaire.class;
	}

	@Override
	protected String getAllEntities() {
		return Questionnaire.GET_ALL_QUESTIONNAIRES;
	}

	public List<QuestionnairePreviewDTO> getEmptyQuestionnairesByAccountId(long id) {
		return entityManager.createNamedQuery(Questionnaire.GET_ALL_QUESTIONNAIRES_NOT_ANSWERED, QuestionnairePreviewDTO.class).setParameter("id", id).getResultList();
	}
	
	public List<Questionnaire> getAnsweredQuestionnairesByAccountId(long id) {
		List<Questionnaire> questList = entityManager.createNamedQuery(Questionnaire.GET_ALL_ANSWERED_QUESTIONNAIRES, Questionnaire.class).setParameter("id", id).getResultList();
		questList.stream().forEach(quest -> quest.setViewPrivacy(getEntity(quest.getId()).getViewPrivacy()));
		return questList;
	
	}
	
}
