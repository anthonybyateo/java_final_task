package by.training.dao.DaoImplFactory;

import by.training.dao.impl.SubscriptionDaoImpl;

public class SubscriptonDaoImplFactory extends BaseDaoImplFactory<SubscriptionDaoImpl> {
    @Override
    public SubscriptionDaoImpl createDaoImpl() {
        return new SubscriptionDaoImpl();
    }
}
