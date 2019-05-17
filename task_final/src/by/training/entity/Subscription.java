package by.training.entity;

public class Subscription extends EntityWithoutID {
    private User subscriber;
    private User user;

    public Subscription() {}

    public Subscription(User user, final User subscriber) {
        this.user = user;
        this.subscriber = subscriber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscription(User subscriber) {
        this.subscriber = subscriber;
    }
}
