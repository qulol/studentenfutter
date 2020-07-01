package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends AbstractServlet {
    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var user = ((UserBean)req.getSession().getAttribute("user"));
        var shoppingcart = user.getShoppingCard();

        //delete
        getDataAccess()
                .query("delete from shoppingcart where id_user=?")
                .withParam(user.getId())
                .run();

        //insert
        getDataAccess()
                .cachedQuery("sql/insert/insertShoppingcart.sql")
                .withParam(user.getId())
                .withBatchSupplier(index -> shoppingcart.get(index).getName())
                .withBatchSupplier(index -> shoppingcart.get(index).getUnit())
                .withBatchSupplier(index -> shoppingcart.get(index).getAmount())
                .runBatch(shoppingcart.size());

        req.getSession().setAttribute("user", new UserBean());
        res.sendRedirect("/jsp/index.jsp");
    }
}