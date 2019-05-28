package by.training.dao;

import by.training.entity.Subscription;

import java.util.List;

public interface SubscriptionDao extends Dao<Subscription>{
    int countSubscriptions(long id);

    int countSubscribers(long id);

    List<Integer> countSubscriptionsOrderByPopular();

    List<Integer> countSubscribersOrderByPopular();
}
