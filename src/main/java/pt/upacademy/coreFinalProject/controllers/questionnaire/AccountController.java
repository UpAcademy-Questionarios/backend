package pt.upacademy.coreFinalProject.controllers.questionnaire;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.upacademy.coreFinalProject.controllers.core.EntityControllerDTO;
import pt.upacademy.coreFinalProject.models.core.DTOS.UserDTO;
import pt.upacademy.coreFinalProject.models.core.converters.UserConverter;
import pt.upacademy.coreFinalProject.models.questionnaire.AccountQuestionnaire;
import pt.upacademy.coreFinalProject.models.questionnaire.DTOs.AccountQuestionnaireDTO;
import pt.upacademy.coreFinalProject.models.questionnaire.converters.AccountQuestionnaireConverter;
import pt.upacademy.coreFinalProject.repositories.questionnaire.AccountQuestionnaireRepository;
import pt.upacademy.coreFinalProject.services.questionnaire.AccountQuestionnaireService;


@Path("questionnaire/account")
@RequestScoped
public class AccountController extends EntityControllerDTO<AccountQuestionnaireService, AccountQuestionnaireRepository, AccountQuestionnaireConverter, AccountQuestionnaire, AccountQuestionnaireDTO>{
	
//	public String getAccountQuestionnaires (){
//		return AccountQuestionnaire.GET_ALL_ACCOUNTS;
//	}
	
	@Inject
	UserConverter userConverter;
	
	@GET
    @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public AccountQuestionnaireDTO getAccountbyId(@PathParam("id") long id) {
		
		return converter.toDTO(service.get(id));
				//getEmptyQuestionnairesByAccountId
				
		//return converter.listToDTO(service.getEmptyQuestionnairesByAccountId(id));
    }
	
	@GET
    @Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public AccountQuestionnaireDTO getAccountByUserId(@PathParam("id") long userId) {
		return converter.toDTO(service.getAccountByUserId(userId));
    }
	
	
	@GET
    @Path("academies")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Long> getDistinctAcademies() {
		return service.getDistinctAcademies();
    }

	@GET
    @Path("academies/{academy}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getUserFromAcademy(@PathParam("academy") long academy) {
		return service.getUserFromAcademy(academy).stream().map(user -> userConverter.toDTO(user)).collect(Collectors.toList());
    }
//service.get().stream().map(E -> converter.toDTO(E)).collect(Collectors.toList());
	
}
