/**
 * @author Sandra Paulina Argote Romo
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carrera;

public class crearCarrera_controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Carrera carrera = new Carrera();

        String idCarrera = request.getParameter("idCarrera").toUpperCase();
        String nombreCarrera = request.getParameter("nombreCarrera").toUpperCase();
        String jefe = request.getParameter("jefe");

        carrera.setIdCarrera(idCarrera);
        carrera.setNombreCarrera(nombreCarrera);
        carrera.setJefe(jefe);

        int status = carrera.registrar(carrera);
        if (status > 0) {
            //inicioAdmin.jsp
            response.sendRedirect("inicioAdmin.jsp");
        } else {
            out.println("No se realizo el registro");
        }
    }
}