package de.dhbwka.studentenfutter;

import de.dhbwka.studentenfutter.model.bean.UserBean;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("user", new UserBean());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //session gets automatically cleaned up
        //store shopping card to db if logged in for instance.
        //se.getSession().removeAttribute("user");
    }
}
