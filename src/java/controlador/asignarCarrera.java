/**
 * @author Sandra Paulina Argote Romo
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carrera;

public class asignarCarrera extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Carrera carrera = new Carrera();

        String idMaestro = request.getParameter("id");
        String idCarrera = request.getParameter("carrera");

        carrera.setIdMaestro(idMaestro);
        carrera.setIdCarrera(idCarrera);

        int status = carrera.asignarCarrera(carrera);

        if (status > 0) {
            response.sendRedirect("verMaestros_controlador");
        }
    }
}
