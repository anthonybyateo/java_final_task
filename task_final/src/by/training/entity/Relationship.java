package by.training.entity;

public class Relationship extends EntityWithoutID {
    private User user;
    private int subscription;

    public Relationship() {}

    public Relationship(User user, final int subscription) {
        this.user = user;
        this.subscription = subscription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSubscription() {
        return subscription;
    }

    public void setSubscription(int subscription) {
        this.subscription = subscription;
    }
}
