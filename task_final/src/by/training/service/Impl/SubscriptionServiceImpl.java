package by.training.service.Impl;

import by.training.dao.DaoImplFactory.SubscriptonDaoImplFactory;
import by.training.dao.SubscriptionDao;
import by.training.entity.Subscription;
import by.training.service.SubscriptionService;

import java.util.List;

public class SubscriptionServiceImpl extends ServiceImpl implements
        SubscriptionService {
    @Override
    public List<Integer> countSubscriptionsOrderByPopular() {
        SubscriptionDao dao = creator.createDao(new SubscriptonDaoImplFactory());
        return dao.countSubscriptionsOrderByPopular();
    }

    @Override
    public List<Integer> countSubscribersOrderByPopular() {
        SubscriptionDao dao = creator.createDao(new SubscriptonDaoImplFactory());
        return dao.countSubscribersOrderByPopular();
    }

    @Override
    public int countSubscriptions(long id) {
        SubscriptionDao dao = creator.createDao(new SubscriptonDaoImplFactory());
        return dao.countSubscriptions(id);
    }

    @Override
    public int countSubscribers(long id) {
        SubscriptionDao dao = creator.createDao(new SubscriptonDaoImplFactory());
        return dao.countSubscribers(id);
    }

    @Override
    public long create(Subscription subscription) {
        SubscriptionDao dao = creator.createDao(new SubscriptonDaoImplFactory());
        return dao.create(subscription);
    }
}
