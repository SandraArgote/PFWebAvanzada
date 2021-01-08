/**
 * @author Sandra Paulina Argote Romo
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrera;
import modelo.Maestro;

public class jefe_controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        Maestro maestro = new Maestro();
        Carrera carreras = new Carrera();
        String usuario = "";

        if (sesion != null) {
            if (sesion.getAttribute("usuario") != null && sesion.getAttribute("tipo") != null) {
                usuario = (String) sesion.getAttribute("usuario");
                String tipo = (String) sesion.getAttribute("tipo");

                String name = maestro.getMaestro(usuario);
                request.setAttribute("usuario", name);
                maestro.setNombreMaestro(name);
                ArrayList<Carrera> misCarreras = new ArrayList<Carrera>();

                misCarreras = carreras.misCarreras(usuario);//recibo
                request.setAttribute("misCarreras", misCarreras);//envio a vista

            } else {
                response.sendRedirect("index.jsp");
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("inicioj.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(jefe_controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(jefe_controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}