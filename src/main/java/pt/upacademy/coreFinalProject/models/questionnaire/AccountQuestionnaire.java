package pt.upacademy.coreFinalProject.models.questionnaire;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import pt.upacademy.coreFinalProject.models.core.EntityRoot;


@Entity
@NamedQueries({ @NamedQuery(name = AccountQuestionnaire.GET_ALL_ACCOUNTS, query = "SELECT a FROM AccountQuestionnaire a"),
				@NamedQuery(name = AccountQuestionnaire.GET_ACCOUNT_BY_USERID, query = "SELECT a FROM AccountQuestionnaire a WHERE a.userId = :id"),
				@NamedQuery(name = AccountQuestionnaire.GET_ACCOUNT_ID_LIST_BY_USERID_LIST, query = "SELECT a.id FROM AccountQuestionnaire a WHERE a.userId IN (:ids)"),
})


public class AccountQuestionnaire extends EntityRoot {
	

	public static final String GET_ALL_ACCOUNTS = "getAllAccounts";
	public static final String GET_ACCOUNT_BY_USERID = "getAccountByUserId";
	public static final String GET_ACCOUNT_ID_LIST_BY_USERID_LIST = "getAccountListByUserList";
	public static final String GET_DIFFERENT_ACADEMIES = "getDifferentAcademies";
	private static final long serialVersionUID = 1L;

	private long userId;
	private long[] userAcademies;

	public AccountQuestionnaire() {}

	public AccountQuestionnaire(long id, long userId, long[] userAcademies) {
		setId(id);
		this.userId = userId;
		this.userAcademies = userAcademies;
	}

	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long[] getUserAcademies() {
		return userAcademies;
	}
	
	public void setUserAcademies(long[] userAcademies) {
		this.userAcademies = userAcademies;
	}
	
}
