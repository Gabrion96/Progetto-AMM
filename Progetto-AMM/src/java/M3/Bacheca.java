package M3;

import M3_Classi.Group;
import M3_Classi.GroupFactory;
import M3_Classi.Post;
import M3_Classi.PostFactory;
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
 * @author Marco
 */
public class Bacheca extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) { /*Se sono loggato*/

            Integer loggedUserID = (Integer) session.getAttribute("userID");  /*Salvo in loggedUserID l'ID dell'utente loggato*/
            User utente = UserFactory.getInstance().getUserById(loggedUserID);  /*e in utente i dati dell'utente loggato*/
            
            if (utente != null) {   /*Se ho trovato corrispondenza nella factory e quindi sono effettivamente loggato*/
                
                request.setAttribute("utente", utente); /*Setto gli attributi "utente" e "bachecaPersonale" entrambi con utente*/
                request.setAttribute("bachecaPersonale", utente);
                ArrayList < Post > posts = new ArrayList < > ();    /*Inizializzo un ArrayList di Post*/

                if (request.getParameter("bachecaid") == null) { /*Se non esiste un parametro bachecaid (e quindi sono nella mia bacheca)*/
                    posts = PostFactory.getInstance().getPostList(utente);  /*Prendo la lista dei post dell'utente loggato*/
                } else {    /*Altrimenti, se esiste*/
                    User bachecaPersonale = new User();  /*Creo un User bachecaPersonale*/
                    bachecaPersonale = UserFactory.getInstance().getUserById(Integer.parseInt(request.getParameter("bachecaid")));   /*Ci metto i dati del titolare della bacheca*/
                    posts = PostFactory.getInstance().getPostList(bachecaPersonale); /*Prendo la lista dei post del titolare della bacheca*/
                    request.setAttribute("bachecaPersonale", bachecaPersonale);   /*Setto un attributo con i suoi dati*/
                    /*Potrei essere anche nella mia bacheca, in quanto quando posto un nuovo post nella mia bacheca, bachecaid prende il valore dell'ID dell'utente loggato*/
                }
                
                request.setAttribute("posts", posts);   /*Setto gli attributi posts con i post da far apparire in bacheca (propri o di un amico)*/
                ArrayList < User > friends = UserFactory.getInstance().getFriendsByUser(utente);    /*friends con gli amici dell'utente loggato*/
                request.setAttribute("friends", friends);
                ArrayList < Group > groups = GroupFactory.getInstance().getGroupList(utente);   /*groups con la lista dei gruppi a cui è iscritto l'utente*/
                request.setAttribute("groups", groups);

                if (request.getParameter("revision") != null) { /*Se revision non è null, e quindi sto provando ad inserire un post*/
                    request.setAttribute("revision", true); /*Setto un attributo "revision" a true*/
                    Post post = new Post(); /*Creo un nuovo post e ci metto dentro tutto ciò inserito dall'utente loggato*/
                    post.setCreatorUser(utente);
                    post.setId(posts.size());
                    post.setImage(request.getParameter("img"));
                    post.setText(request.getParameter("text"));
                    request.setAttribute("post_r", post); /*Sfrutto la sessione per il passaggio del parametro (post_r) (revisione del post)*/
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response); /*Reindirizzo a bacheca.jsp*/
                    return;
                }

                if (request.getParameter("confirm") != null) { /*Se confirm non è null, e quindi sto confermando il post da inserire*/
                    request.setAttribute("confirm", true);  /*Setto un attributo "confirm" a true*/
                    Post post = (Post) request.getAttribute("post_r");
                    PostFactory.getInstance().insertPost(post); /*Aggiungo il post alla lista (da errore nella visualizzazione del post nelle bacheche altrui)*/
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response); /*Reindirizzo a bacheca.jsp*/
                    return;
                }

                request.getRequestDispatcher("bacheca.jsp").forward(request, response); /*Nel caso normale in cui non ci fossero inserimenti di post reindirizzo*/
                return;
            }
        }
        /*Se non sono loggato reindirizzo comunque a bacheca.jsp*/
        request.getRequestDispatcher("bacheca.jsp").forward(request, response);
        return;


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
        } // </editor-fold>

}