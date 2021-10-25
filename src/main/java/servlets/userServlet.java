package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import services.userService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class userServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> userList = userService.getAllUsers();
        ObjectMapper map = new ObjectMapper();
        resp.getWriter().write(map.writeValueAsString(userList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        InputStream reqBody = req.getInputStream();
        Scanner sc = new Scanner(reqBody, StandardCharsets.UTF_8.name());
        String json = sc.useDelimiter("\\A").next();
        System.out.println("JSON Text: " + json);
        ObjectMapper map = new ObjectMapper();
        User user = map.readValue(json, User.class);
        userService.saveNewUser(user);
        resp.setStatus(202);
    }

}