package by.training.action;

import by.training.service.servicefactory.CreatorService;

public class ActionManagerFactory {
    public static ActionManager getManager(CreatorService creator) {
        return new ActionManagerImpl(creator);
    }
}
