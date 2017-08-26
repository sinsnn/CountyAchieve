/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.yunlin.model;

/**
 *
 * @author sinsnn
 */
public class AccountService {

//    private final String USERS = "/Users/sinsnn/desktop/users";
//    private final String USERS = "C:/Users/sinsnn/Documents/NetBeansProjects/CountyAchieve/users";
    private final AccountDAO accountDAO;

    /**
     *
     * @param accountDAO
     */
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public boolean isAccountExisted(Account account) {
        return accountDAO.isAccountExisted(account);
    }

    public void add(Account account) {
        accountDAO.addAccount(account);
    }

     public boolean checkLogin(Account account) {
        if (account.getName() != null && account.getPassword() != null) {
            Account storedAcct = accountDAO.getAccount(account); 
            return storedAcct != null && 
                   storedAcct.getPassword().equals(account.getPassword()); 
        }
        return false;
    }
    
}
