package by.training.action;

import javax.servlet.http.HttpServletRequest;

public class Trimming {
    public static String TrimmUri(HttpServletRequest request, char lastCh){
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        int beginAction = contextPath.length();
        int endAction = uri.lastIndexOf(lastCh);
        String actionName;
        if(endAction >= 0) {
            actionName = uri.substring(beginAction, endAction);
        } else {
            actionName = uri.substring(beginAction);
        }
        return actionName;
    }

    public static String TrimmSign(String forward, char firstCh){
        int beginAction = forward.lastIndexOf(firstCh);
        return forward.substring(beginAction);
    }

}
