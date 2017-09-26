/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3;

import M3_Classi.Group;
import M3_Classi.GroupFactory;
import M3_Classi.User;
import M3_Classi.UserFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriele Concas
 */
public class Profilo extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) 
        { /*Se sono loggato*/
            Integer userID = (Integer) session.getAttribute("userID");    /*Salvo in userID l'ID della persona loggata*/
            User utente = UserFactory.getInstance().getUserById(userID);    /*E in User utente i dati della persona loggata*/
            
            if (utente != null) /*Se ho trovato una corrispondenza, e quindi sono effettivamente loggato*/
                request.setAttribute("utente", utente); /*Setto l'attributo nella request "utente" con utente*/

            ArrayList < User > friends = UserFactory.getInstance().getFriendsByUser(utente);    /*Prendo la lista degli amici*/
            request.setAttribute("friends", friends);
            ArrayList < Group > groups = GroupFactory.getInstance().getGroupList(utente);   /*e quella dei gruppi dell'utente loggato*/
            request.setAttribute("groups", groups);

            if (request.getParameter("update") != null) 
            {   /*Se esiste un parametro update e quindi ho modificato nel form i dati e ho inviato*/
                String aux = request.getParameter("nome");  /*Prendo tutti i parametri e li setto a utente, che è l'oggetto che uso per mostrare i dati nell'applicazione*/
                utente.setNome(aux);
                aux = request.getParameter("cognome");
                utente.setCognome(aux);
                aux = request.getParameter("url");
                utente.setURLimmagine(aux);
                aux = request.getParameter("frase");
                utente.setFrase(aux);
                aux = request.getParameter("data");
                utente.setData(aux);
                aux = request.getParameter("pswd");
                utente.setPassword(aux);
                aux = request.getParameter("conpswd");
                request.setAttribute("update", true);
            }

        }

        request.getRequestDispatcher("profilo.jsp").forward(request, response); /*Reindirizzo infine a profilo.jsp*/
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
    throws ServletException, IOException
    {
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
        } // </editor-fold>
}
