package app02a.servlet;

import app02a.controller.Icontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoController implements Icontroller {

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
        String message = "Test web";

        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println(message);
    }
}
