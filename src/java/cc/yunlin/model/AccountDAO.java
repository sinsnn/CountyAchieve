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
public interface AccountDAO {
    boolean isAccountExisted(Account account);
    void addAccount(Account account);
    Account getAccount(Account account);     
}
