package com.csa.domain;

import com.csa.dao.AccountDao;

import java.util.List;

/**
 * @author yufeng1900
 * @create 2021-03-27 13:24
 */
public class AccountService {
    private AccountDao account;

    public AccountService(AccountDao account) {
        this.account = account;
    }

    // 1查询所有记录
    public List<Account> findAll() { return account.findAll(); }
    // 2通过id删除记录
    public void deleteByPrimaryKey(String id) {account.deleteByPrimaryKey(id);}
    // 3插入记录
    public void insert(Account record) {account.insert(record);}
    // 4通过id查找对象
    public Account selectByPrimaryKey(String id) {return account.selectByPrimaryKey(id);}
    // 5更新Account
    public void updateByPrimaryKey(Account record) {account.updateByPrimaryKey(record);}
    // 6转账功能 输入转出人id，转入人id，转账金额 实现转账
    public void transfer(String remitterId,String remitteeId,int money) {
        Account remitterAccount = account.selectByPrimaryKey(remitterId);
        Account remitteeAccount = account.selectByPrimaryKey(remitteeId);

        remitterAccount.setMoney(remitterAccount.getMoney()-money);
        remitteeAccount.setMoney(remitteeAccount.getMoney()+money);

        account.updateByPrimaryKey(remitterAccount);
        account.updateByPrimaryKey(remitteeAccount);
    }
}
