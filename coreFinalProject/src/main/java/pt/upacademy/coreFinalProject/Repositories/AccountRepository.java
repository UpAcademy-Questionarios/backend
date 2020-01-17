package pt.upacademy.coreFinalProject.Repositories;

import javax.enterprise.context.RequestScoped;

import pt.upacademy.coreFinalProject.models.Account;

@RequestScoped
public class AccountRepository extends EntityRepository<Account>{

	@Override
	protected Class<Account> getEntityClass() {
		return Account.class;
	}

	@Override
	protected String getAllEntities() {
		return Account.GET_ALL_ACCOUNTS;
	}

}
