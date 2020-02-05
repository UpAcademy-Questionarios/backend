package pt.upacademy.coreFinalProject.services.questionnaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.commons.lang3.ArrayUtils;

import pt.upacademy.coreFinalProject.models.core.User;
import pt.upacademy.coreFinalProject.models.questionnaire.AccountQuestionnaire;
import pt.upacademy.coreFinalProject.repositories.questionnaire.AccountQuestionnaireRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;
import pt.upacademy.coreFinalProject.services.core.UserService;

@RequestScoped
public class AccountQuestionnaireService extends EntityService<AccountQuestionnaireRepository, AccountQuestionnaire>{
	
	
//	public void addPendingQuestionnaireToAccount(long questionnaireId, long[] accountIds) {
//		repository.addPendingQuestionnaireToAccount(questionnaireId, accountIds);
//	}
	
	@Inject
	UserService userService;
	
	public AccountQuestionnaire getAccountByUserId(long userId) {
		long[] userAcademies = new long[] {1, 2}; //Para apagar depois da integração dos projetos
		long accountId;
		AccountQuestionnaire account = repository.getEntityByUserId(userId);
		if (account == null) {
			accountId = repository.addEntity(new AccountQuestionnaire(0, userId, userAcademies));
			account = repository.getEntity(accountId);
		}
		return account;
	}
	
	public List<Long> getAccountIdListByUserList(List<Long> ids){
		return repository.getAccountIdListByUserList(ids);
	}
	
	public List<Long> getDistinctAcademies(){
		Collection<AccountQuestionnaire>  AllAccounts = get();
		List<Long> distinctAcademies = new ArrayList<Long>();
		
		//List<Long> lala = Arrays.asList(a);
		for (AccountQuestionnaire account : AllAccounts) {
			if (!distinctAcademies.contains(account.getUserAcademies()[0])) {
				distinctAcademies.add(account.getUserAcademies()[0]);
			}
			
		}
		return distinctAcademies;
	}
		
	public	List<User> getUserFromAcademy(long academy){
		Collection<AccountQuestionnaire>  AllAccounts = get();
		//Arrays.stream(AllAccounts).anyMatch(academy::equals);
		//List<Long>
		List<User> usersFromAcademy = new ArrayList<User>();
		for (AccountQuestionnaire account : AllAccounts) {
			long[] arr = account.getUserAcademies();
			Long[] arrObj = ArrayUtils.toObject(arr);
			List<Long> list = Arrays.asList(arrObj);
			if (list.contains(academy)) {
				usersFromAcademy.add(userService.get(account.getUserId()));
			}
			System.out.println(usersFromAcademy);
			
//			List<Long> num = Collections.addAll(distinctAcademies, arr);
//			List<Long> lala = Arrays.stream(arr).collect(Collectors.toList());
			//if (Arrays.stream(account.getUserAcademies()).anyMatch(academy::equals));
		}
		//if (AllAccounts.contains(academy))
		//Arrays.stream(arr).anyMatch(item::equals);
		return usersFromAcademy;
	
	}
}
