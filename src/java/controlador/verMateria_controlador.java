/**
 * @author Sandra Paulina Argote Romo
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import modelo.Materia;

public class verMateria_controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        String idC = request.getParameter("idCarrera");
        HttpSession sesion = request.getSession();

        Maestro maestro = new Maestro();
        Carrera carreras = new Carrera();
        Materia materia = new Materia();

        String usuario = "";
        List<Materia> Materias = new ArrayList<Materia>();

        if (sesion != null) {
            if (sesion.getAttribute("usuario") != null && sesion.getAttribute("tipo") != null) {
                usuario = (String) sesion.getAttribute("usuario");
                String tipo = (String) sesion.getAttribute("tipo");

                String name = maestro.getMaestro(usuario);
                request.setAttribute("usuario", name);
                maestro.setNombreMaestro(name);
                ArrayList<Carrera> misCarreras = new ArrayList<Carrera>();
                
                String jefe = request.getParameter("usuario");
                misCarreras = carreras.misCarreras(usuario);
                request.setAttribute("misCarreras", misCarreras);

                String idCarrera = (String) sesion.getAttribute(idC);
                Materias = materia.getAllMaterias(idC);
                request.setAttribute("listaMaterias", Materias);

                String id = request.getParameter("idMateria");

                if (id != null) {
                    request.setAttribute("idMateria", materia.modificarMateria(materia));
                }

            } else {
                response.sendRedirect("index.jsp");
            }

            request.setAttribute("idCarrera", idC);
            RequestDispatcher rd = request.getRequestDispatcher("verMateria.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(verMateria_controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(verMateria_controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}