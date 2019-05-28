package by.training.service.servicefactory;

import by.training.service.Impl.SubscriptionServiceImpl;

public class SubscriptionServiceImplFactory extends
        ServiceImplFactory<SubscriptionServiceImpl> {
    @Override
    public SubscriptionServiceImpl createServiceImpl() {
        return new SubscriptionServiceImpl();
    }
}
