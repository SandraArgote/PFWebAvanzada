/**
 * @author Sandra Paulina Argote Romo
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Materia;

public class modificarMateria2_controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;

        String idMateria = request.getParameter("idMateria");
        String nombreMateria = request.getParameter("nombreMateria");
        String semestre = request.getParameter("semestre");
        String creditos = request.getParameter("creditos");
        String ht = request.getParameter("horasTeoria");
        String hp = request.getParameter("horasPractica");
        String idCarrera= request.getParameter("idCarrera");
        
        System.out.println(idMateria);
        System.out.println(nombreMateria);
        System.out.println(semestre);
        System.out.println(creditos);
        System.out.println(ht);
        System.out.println(hp);
        System.out.println(idCarrera);

        Materia m = new Materia();

        m.setIdMateria(idMateria);
        m.setNombreMateria(nombreMateria);
        m.setSemestre(semestre);
        m.setCreditos(creditos);
        m.setHt(ht);
        m.setHp(hp);
        m.setIdCarrera(idCarrera);

        int status = Materia.modificarMateria(m);
        if (status > 0) {
             request.setAttribute("idCarrera", idCarrera);
             rd = request.getRequestDispatcher("verMateria_controlador");
             rd.forward(request, response);
        } else {
            out.println("No se guardaron los cambios");
        }
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