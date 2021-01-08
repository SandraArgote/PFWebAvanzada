/**
 * @author Sandra Paulina Argote Romo
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Reporte;

public class reporte_controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String idMaestro= request.getParameter("idMaestro");
        String idCarrera =request.getParameter("idCarrera");
        
        Reporte reporte = new Reporte();
        ArrayList<Reporte> r = new ArrayList<Reporte>();
        r = reporte.getReporte(idMaestro);
        request.setAttribute("reporte", r);
        request.setAttribute("idCarrera", idCarrera);

        RequestDispatcher rd = request.getRequestDispatcher("reporte.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}