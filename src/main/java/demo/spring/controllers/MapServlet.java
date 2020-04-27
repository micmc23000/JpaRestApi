package demo.spring.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

 

@WebServlet(name = "MapServlet", urlPatterns
        = {
            "/MapServlet"
        })
public class MapServlet extends HttpServlet {

 

    //
    //  methods
    //
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

 

    private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in servlet");

 

        HandleMapTest(request, response);
    }

 

    public void HandleMapTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String pageUrl = "/beermap.jsp";
        //testing brewery #5
        String name = "Abbaye de Leffe";
        float latitude = 50.2606f;
        float longitude = 4.9122f;
        String apiKey="=Insert YOUR_API_KEY to see results";

 

        //get or pass in those values in real life
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("latitude", latitude);
        session.setAttribute("longitude", longitude);
        session.setAttribute("apiKey", apiKey);
        gotoPage(pageUrl, request, response);
    }
}
 