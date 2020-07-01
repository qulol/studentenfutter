package de.dhbwka.studentenfutter;

import de.dhbwka.studentenfutter.bean.UserBean;
import de.dhbwka.studentenfutter.database.DatabaseAccess;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        var session = se.getSession();
        session.setAttribute("user", new UserBean());
        session.setMaxInactiveInterval(3600); //logout after 60min
    }
}
