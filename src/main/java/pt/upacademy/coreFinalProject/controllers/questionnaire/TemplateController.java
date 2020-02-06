package pt.upacademy.coreFinalProject.controllers.questionnaire;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.upacademy.coreFinalProject.controllers.core.EntityControllerDTO;
import pt.upacademy.coreFinalProject.models.questionnaire.Questionnaire;
import pt.upacademy.coreFinalProject.models.questionnaire.DTOs.QuestionnaireDTO;
import pt.upacademy.coreFinalProject.models.questionnaire.DTOs.QuestionnairePreviewDTO;
import pt.upacademy.coreFinalProject.models.questionnaire.converters.QuestionnaireConverter;
import pt.upacademy.coreFinalProject.repositories.questionnaire.QuestionnaireRepository;
import pt.upacademy.coreFinalProject.services.questionnaire.QuestionnaireService;




@Path("questionnaire/template")
@RequestScoped
public class TemplateController extends EntityControllerDTO<QuestionnaireService, QuestionnaireRepository, QuestionnaireConverter, Questionnaire, QuestionnaireDTO>{

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<QuestionnairePreviewDTO> getAllTemplates() {
		return converter.questListToPreviewDTO(service.getAllTemplates());					
    }
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public QuestionnaireDTO getTemplateById(@PathParam("id") long id) {
		return converter.toDTO(service.getTemplateById(id));
    }
	
	@GET
	@Path("/{id}/quizzes")
	@Produces(MediaType.APPLICATION_JSON)
    public List<QuestionnairePreviewDTO> getAllQuizzesByTemplateById(@PathParam("id") long id) {
		return converter.questListToPreviewDTO(service.getAllQuizzesByTemplateId(id));
    }
	
	@GET
	@Path("/{id}/evaluations")
	@Produces(MediaType.APPLICATION_JSON)
    public List<QuestionnaireDTO> getAllEvaluationsByTemplateId(@PathParam("id") long id) {
		return converter.listToDTO(service.getAllEvaluationsByTemplateId(id));
    }
	
	
}
