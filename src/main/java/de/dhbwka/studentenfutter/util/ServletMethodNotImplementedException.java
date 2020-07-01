package de.dhbwka.studentenfutter.util;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

public class ServletMethodNotImplementedException extends RuntimeException {
    private static final String msg = "Servlet with route ''{0}'' has no ''{1}'' implementation";

    public ServletMethodNotImplementedException(HttpServletRequest req) {
        super(MessageFormat.format(msg, req.getServletPath(), req.getMethod()));
    }
}
