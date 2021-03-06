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

/**
 * takes in http requests and generates appropriate response for /flight
 * @author James Brown & Advaith Ayer
 */
public class flightServlet extends HttpServlet {
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Flight> flightList = flightService.getAll();
        ObjectMapper map = new ObjectMapper();
        resp.getWriter().write(map.writeValueAsString(flightList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
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

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        InputStream reqBody = req.getInputStream();
        Scanner sc = new Scanner(reqBody, StandardCharsets.UTF_8.name());
        String jsonTxt = sc.useDelimiter("\\A").next();
        System.out.println("JSON Text: " + jsonTxt);
        ObjectMapper map = new ObjectMapper();
        Flight flight = map.readValue(jsonTxt, Flight.class);
        flightService.deleteFlight(flight.getFlight_number());
        resp.setStatus(200);
    }
}
