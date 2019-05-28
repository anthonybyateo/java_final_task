package by.training.dao;

import by.training.entity.Subscription;

public interface SubscriptionDao extends Dao<Subscription>{
    int countSubscriptions(long id);

    int countSubscribers(long id);
}
