package pt.upacademy.coreFinalProject.services.questionnaire;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import pt.upacademy.coreFinalProject.models.core.User;
import pt.upacademy.coreFinalProject.models.questionnaire.Qtype;
import pt.upacademy.coreFinalProject.models.questionnaire.Questionnaire;
import pt.upacademy.coreFinalProject.repositories.questionnaire.QuestionnaireRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;
import pt.upacademy.coreFinalProject.services.core.UserService;

@RequestScoped
public class QuestionnaireService extends EntityService<QuestionnaireRepository, Questionnaire> {

	@Inject
	private AccountQuestionnaireService accountQuestionnaireService;
	
	@Inject
	private UserService userService;
	

	public List<Questionnaire> getEmptyQuestionnairesByAccountId(long id) {
		return repository.getEmptyQuestionnairesByAccountId(id);
	}
    
	public List<Questionnaire> getAnsweredQuestionnairesByAccountId(long id) {
		return repository.getAnsweredQuestionnairesByAccountId(id);
	}
	
	public List<Questionnaire> getAnsweredQuestionnaires() {
		return repository.getAnsweredQuestionnaires();
	}
	
	
	
	public List<Questionnaire> getAllTemplates() {
		return repository.getAllTemplates();
	
	}
	
	public List<Questionnaire> getAllQuizzesByAccountId(long id) {
		return repository.getAllQuizzesByAccountId(id);
	}
	
	public List<Questionnaire> getAllQuizzesByTemplateId(long templateId) {
		return repository.getAllQuizzesByTemplateId(templateId);
	}
	
	public List<Questionnaire> getAllEvaluationsByTemplateId(long templateId) {
		return repository.getAllEvaluationsByTemplateId(templateId);
	}
	
	public Questionnaire getTemplateById(long id) {
		return repository.getEntity(id);
	}
	
	
	
	public void createWithAccountId(List<String> userIds, boolean template, Questionnaire quest) {
		
		System.out.println(template);
		System.out.println(template);
		if (template) {
			quest.setTemplate(true);
			long templateId = create(quest);
			System.out.println(templateId);
			quest.setTemplateId(templateId);
		}
		quest.setTemplate(false);
		
		
		List<Long> userIdsLong = userIds.stream().map(Long::valueOf).collect(Collectors.toList());
		List<Long> accountIds = accountQuestionnaireService.getAccountIdListByUserList(userIdsLong);
		accountIds.stream().forEach(id -> {
			quest.setAccountId(id);
			create(quest);
		
		userIdsLong.forEach(userId -> {
			try {
				sendQuestionnaireInvitation(userService.get(userId));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
			
			
		});		
	}
	
	@Override
	public void update(Questionnaire questionnaire) {
		if (questionnaire.getqType().equals(Qtype.QUIZ)) {
			questionnaire.calculateScore();
		}
		repository.editEntity(questionnaire);
	}

	public static void sendQuestionnaireInvitation(User user) throws IOException {
		System.out.println("EMAIL TIME");
		Mail mail = new Mail();
		Email fromEmail = new Email();
	    fromEmail.setName(System.getProperty("SGFromName"));
	    fromEmail.setEmail(System.getProperty("SGFromEmail"));
	    mail.setFrom(fromEmail);
	    mail.setTemplateId(System.getProperty("SGTemplateId"));

	    Personalization personalization = new Personalization();
	    personalization.addDynamicTemplateData("user", user);
	    personalization.addTo(new Email(user.getEmail()));
	    mail.addPersonalization(personalization);
		
		try {
			SendGrid sg = new SendGrid(System.getProperty("SGKey"));
			Request request = new Request();
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}
	
	
}
