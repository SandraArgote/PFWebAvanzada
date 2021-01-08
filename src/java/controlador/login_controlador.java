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
import javax.servlet.http.HttpSession;
import modelo.Login;

public class login_controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        Login login = new Login();
        RequestDispatcher rd;
        
        if (request.getParameter("ingresar") != null) {
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");

            login.setUsuario(usuario);
            login.setContraseña(pass);

            try {
                int tipo = login.iniciarSesion(usuario, pass);

                switch (tipo) {
                    case 1:
                        sesion.setAttribute("usuario", usuario);
                        sesion.setAttribute("tipo", "1");

                        rd = request.getRequestDispatcher("inicioAdmin.jsp");
                        rd.forward(request, response);
                        break;

                    case 2:
                        sesion.setAttribute("usuario", usuario);
                        sesion.setAttribute("tipo", "2");
                        request.setAttribute("usuario", usuario);

                        rd = request.getRequestDispatcher("jefe_controlador");
                        rd.forward(request, response);
                        break;

                    case 3:
                        sesion.setAttribute("usuario", usuario);
                        sesion.setAttribute("tipo", "3");
                        request.setAttribute("usuario", usuario);

                        rd = request.getRequestDispatcher("inicioMaestro.jsp");
                        rd.forward(request, response);
                        break;

                    default:
                        out.write("usuario y/o contraseñas incorrectas");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (request.getParameter("cerrar") != null) {
            sesion.invalidate();
            request.getSession().invalidate();
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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