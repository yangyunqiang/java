package app02a.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Icontroller {
    void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
