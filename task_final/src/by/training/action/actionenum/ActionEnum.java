package by.training.action.actionenum;

import by.training.action.*;

public enum ActionEnum {
    MAIN("/", new ShowPopularPeopleAction()),
    INDEX("/index", new ShowPopularPeopleAction()),
    SHOW_SUBSCRIPRIONS( "/subscriptions", new LogoutAction()),
    SHOW_SUBSCRIBERS( "/subscribers", new SignupAction()),
    LOGOUT( "/logout", new LogoutAction()),
    //also unauth user
    SHOW_POPULAR_PEOPLE( "/popular_people", new ShowPopularPeopleAction()),
    SIGNUP("signup", new SignupAction()),
    LOGININ("/login", new LoginAction());


    private String actionName;
    private Action action;

    ActionEnum(String name, Action action) {
        actionName = name;
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public String getActionName() {
        return actionName;
    }

    public static Action findAction(String actionName) {
        ActionEnum[] enums = ActionEnum.values();
        for (ActionEnum actionEnum : enums) {
            if (actionEnum.getActionName().equals(actionName)) {
                return actionEnum.getAction();
            }
        }
        return null;
    }

    public static boolean IsActionUnauthUser(String actionName) {
        ActionEnum[] enums = ActionEnum.values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getActionName().equals(actionName)) {
                return true;
            }
        }
        return false;
    }
}
