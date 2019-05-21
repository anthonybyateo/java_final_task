package by.training.action.actionenum;

import by.training.action.Action;
import by.training.action.LoginAction;
import by.training.action.LogoutAction;

public enum ActionEnum {
    MAIN("/", new LoginAction()),
    INDEX("/index", new LoginAction()),
    LOGININ("/login", new LoginAction()),
    LOGOUT( "/logout", new LogoutAction());

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
}
