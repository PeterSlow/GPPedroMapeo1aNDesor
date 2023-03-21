package es.albarregas.controllers;

import es.albarregas.beans.Autor;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.beans.Obra;
import es.albarregas.dao.IGenericoDAO;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Conclusion", urlPatterns = {"/conclusion"})
public class Conclusion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO pdao = daof.getGenericoDAO();

        Set<Obra> listaObra = new HashSet<>();
        Autor autor = new Autor();
        String url = null;
        switch (request.getParameter("op")) {

            case "update":
                 try {
                DateConverter converter = new DateConverter();
                converter.setPattern("yyyy-MM-dd");
                ConvertUtils.register(converter, Date.class);
                BeanUtils.populate(autor, request.getParameterMap());
            } catch (IllegalAccessException | InvocationTargetException ex) {
                ex.printStackTrace();
            }

            for (int i = 0; i <= 3; i++) {
                String nombre = request.getParameter("nombre" + i);
                String tecnica = request.getParameter("tecnica" + i);
                String dimensiones = request.getParameter("dimensiones" + i);
                String idObra = request.getParameter("idObra" + i); // Nuevo

                if (nombre != null && tecnica != null && dimensiones != null && nombre != "" && tecnica != "" && dimensiones != "") {

                    Obra obra = new Obra();
                    obra.setNombre(nombre);
                    obra.setTecnica(tecnica);
                    obra.setDimensiones(dimensiones);
                    obra.setIdObra(Integer.parseInt(idObra)); // Nuevo

                    System.out.println("0000000000000000");
                    System.out.println(nombre);
                    System.out.println(tecnica);
                    System.out.println(dimensiones);
                    System.out.println(idObra);
                    System.out.println("0000000000000000");

                    listaObra.add(obra);
                }
            }

            autor.setObraList(listaObra);
            pdao.update(autor);
            url = "index.jsp";
            break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
