package Practical_6.service;

import Practical_6.model.Account;

@FunctionalInterface
public interface WithdrawRule {

    boolean allow(Account account, long amount);
}