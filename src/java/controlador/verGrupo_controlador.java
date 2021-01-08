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
import modelo.Grupo;

public class verGrupo_controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String idCarrera= request.getParameter("idCarrera");
        Grupo grupo = new Grupo();
        ArrayList<Grupo> grupos = new ArrayList<Grupo>();
        grupos = grupo.getSabana(idCarrera);
        request.setAttribute("grupos", grupos);
        RequestDispatcher rd = request.getRequestDispatcher("verGrupos.jsp");
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