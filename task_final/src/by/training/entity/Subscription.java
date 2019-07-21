package by.training.entity;

public class Subscription implements Entity {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return false; }
        if (obj == null || getClass() != obj.getClass()) { return false; }
        Subscription subscription = (Subscription) obj;
        if(this.hashCode() != subscription.hashCode()) { return false; }
        return (subscriber == subscription.getSubscriber()
                || (subscriber != null
                && subscriber.equals(subscription.getSubscriber())))
                && (user == subscription.getUser()
                || (user != null && user.equals(subscription.getUser())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (int)( prime  + ((user == null) ? 0 : user.hashCode())
                + ((subscriber == null) ? 0 : subscriber.hashCode()));
    }

    @Override
    public String toString() {
        return "Subscription{" + "subscriber='"
                + subscriber.toString() + ", user='" + user.toString() +  '}';
    }
}
