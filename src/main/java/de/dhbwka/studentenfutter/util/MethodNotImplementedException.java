package de.dhbwka.studentenfutter.util;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

public class MethodNotImplementedException extends RuntimeException {
    private static final String msg = "Servlet with route ''{0}'' has no ''{1}'' implementation";

    public MethodNotImplementedException(HttpServletRequest req) {
        super(MessageFormat.format(msg, req.getServletPath(), req.getMethod()));
    }
}
