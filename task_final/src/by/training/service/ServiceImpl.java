package by.training.service;

import by.training.dao.Transaction;

abstract public class ServiceImpl implements Service {
    protected Transaction transaction = null;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
