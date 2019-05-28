package by.training.service;

import by.training.entity.Subscription;

import java.util.List;

public interface SubscriptionService extends Service {
    List<Integer> countSubscriptionsOrderByPopular();

    List<Integer> countSubscribersOrderByPopular();

    int countSubscriptions(long id);

    int countSubscribers(long id);

    long create(Subscription subscription);
}
