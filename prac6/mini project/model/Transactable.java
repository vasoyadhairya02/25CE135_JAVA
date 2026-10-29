package Practical_6.model;

public interface Transactable {

    void deposit(long amount);

    boolean withdraw(long amount);
}