package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Flight;
import services.flightService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class flightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Flight> flightList = flightService.getAll();
        ObjectMapper map = new ObjectMapper();
        resp.getWriter().write(map.writeValueAsString(flightList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        InputStream reqBody = req.getInputStream();
        Scanner sc = new Scanner(reqBody, StandardCharsets.UTF_8.name());
        String jsonTxt = sc.useDelimiter("\\A").next();
        System.out.println("JSON Text: " + jsonTxt);
        ObjectMapper map = new ObjectMapper();
        Flight flight = map.readValue(jsonTxt, Flight.class);
        flightService.saveNewFlight(flight);
        resp.setStatus(202);
    }
}
