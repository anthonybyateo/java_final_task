package by.training.action.actionenum;

import by.training.action.*;
import by.training.action.user.ChangePasswordAction;
import by.training.action.user.ChangePhotoAction;
import by.training.action.user.EditUserAction;

public enum ActionEnum {
    EDIT("/edit", new EditUserAction()),
    CHANGE_PASSWORD("/changePassword", new ChangePasswordAction()),
    CHANGE_PHOTO("/changePhoto", new ChangePhotoAction()),
    SHOW_SUBSCRIPRIONS( "/subscriptions", new LogoutAction()),
    SHOW_SUBSCRIBERS( "/subscribers", new SignupAction()),
    LOGOUT( "/logout", new LogoutAction()),
    //also unauth user
    PROFILE("/profile", new ProfileAction()),
    POPULAR_PEOPLE( "/popular_people", new PopularPeopleAction()),
    SIGNUP("/signup", new SignupAction()),
    FIND_USER("/findUser", new FindUserAction()),
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
        for (int i = 5; i < enums.length; i++) {
            if (enums[i].getActionName().equals(actionName)) {
                return true;
            }
        }
        return false;
    }
}
