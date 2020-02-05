package pt.upacademy.coreFinalProject.repositories.questionnaire;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import pt.upacademy.coreFinalProject.models.questionnaire.Qtype;
import pt.upacademy.coreFinalProject.models.questionnaire.Questionnaire;
import pt.upacademy.coreFinalProject.repositories.core.EntityRepository;

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

	public List<Questionnaire> getEmptyQuestionnairesByAccountId(long id) {
		return entityManager.createNamedQuery(Questionnaire.GET_ALL_QUESTIONNAIRES_NOT_ANSWERED, Questionnaire.class).setParameter("id", id).getResultList();
	}
	
	
	public List<Questionnaire> getAnsweredQuestionnairesByAccountId(long id) {
		return entityManager.createNamedQuery(Questionnaire.GET_ALL_ANSWERED_QUESTIONNAIRES_BY_ACCOUNT_ID, Questionnaire.class).setParameter("id", id).getResultList();
	
	}
	
	public List<Questionnaire> getAnsweredQuestionnaires() {
		return entityManager.createNamedQuery(Questionnaire.GET_ALL_ANSWERED_QUESTIONNAIRES, Questionnaire.class).getResultList();
	
	}
	
	public List<Questionnaire> getAllTemplates() {
		return entityManager.createNamedQuery(Questionnaire.GET_ALL_TEMPLATES, Questionnaire.class).getResultList();
	
	}
	
	public List<Questionnaire> getAllQuizzesByAccountId(long id) {
		return entityManager.createNamedQuery(Questionnaire.GET_ALL_QUIZZES_BY_ACCOUNT_ID, Questionnaire.class).setParameter("type", Qtype.QUIZ).setParameter("id", id).getResultList();
	
	}
	
	public List<Questionnaire> getAllQuizzesByTemplateId(long templateId) {
		return entityManager.createNamedQuery(Questionnaire.GET_ALL_QUIZZES_BY_TEMPLATE_ID, Questionnaire.class).setParameter("type", Qtype.QUIZ).setParameter("templateId", templateId).getResultList();
	
	}
	
	public List<Questionnaire> getAllEvaluationsByTemplateId(long templateId) {
		return entityManager.createNamedQuery(Questionnaire.GET_ALL_EVALUATIONS_BY_TEMPLATE_ID, Questionnaire.class).setParameter("type", Qtype.EVALUATION).setParameter("templateId", templateId).getResultList();
	
	}
	
	public Questionnaire getTemplateById(long id) {
		List<Questionnaire> list = entityManager.createNamedQuery(Questionnaire.GET_ALL_TEMPLATES, Questionnaire.class).setParameter("id", id).getResultList();
		System.out.println(list);
		if (list.isEmpty()) {
			return null;
		} else {
		return list.get(0);
		}
	}
	
}
