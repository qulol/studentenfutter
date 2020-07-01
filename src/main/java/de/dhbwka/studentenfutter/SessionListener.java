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

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        var session = se.getSession();
        var user = ((UserBean)session.getAttribute("user"));

        if(!user.isLoggedIn()) {
            return;
        }

        //update shopping cart in database
        var databaseAccess = (DatabaseAccess)session.getServletContext().getAttribute(DatabaseAccess.ATTRIBUTE_KEY);
        var shoppingcart = user.getShoppingCard();
        try {
            databaseAccess
                    .query("delete from shoppingcart where id_user=?")
                    .withParam(user.getId())
                    .run();
            databaseAccess
                    .cachedQuery("sql/insert/insertShoppingcart.sql")
                    .withParam(user.getId())
                    .withBatchSupplier(index -> shoppingcart.get(index).getName())
                    .withBatchSupplier(index -> shoppingcart.get(index).getUnit())
                    .withBatchSupplier(index -> shoppingcart.get(index).getAmount())
                    .run();
        } catch (Exception e) {
            //log error message and print to user on next login or sth.
        }
    }
}
