package by.training.service;

import by.training.entity.Subscription;

public interface SubscriptionService extends Service{
    int countSubscriptions(long id);

    int countSubscribers(long id);

    long create(Subscription subscription);
}
