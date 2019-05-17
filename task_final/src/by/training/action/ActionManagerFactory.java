package by.training.action;

public class ActionManagerFactory {
    public static ActionManager getManager(ServiceFactory factory) {
        return new ActionManagerImpl(factory);
    }
}
