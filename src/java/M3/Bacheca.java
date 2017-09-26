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
 * @author Gabriele Concas
 */
public class Bacheca extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) { 

            Integer loggedUserID = (Integer) session.getAttribute("userID");  
            User utente = UserFactory.getInstance().getUserById(loggedUserID);  
            
            if (utente != null) {   
                
                request.setAttribute("utente", utente); 
                request.setAttribute("bachecaPersonale", utente);
                ArrayList < Post > posts = new ArrayList < > ();    

                if (request.getParameter("bachecaid") == null) { 
                    posts = PostFactory.getInstance().getPostList(utente);  
                } else { 
                    User bachecaPersonale = new User(); 
                    bachecaPersonale = UserFactory.getInstance().getUserById(Integer.parseInt(request.getParameter("bachecaid")));  
                    posts = PostFactory.getInstance().getPostList(bachecaPersonale); 
                    request.setAttribute("bachecaPersonale", bachecaPersonale);   
                   
                }
                
                request.setAttribute("posts", posts);  
                ArrayList < User > friends = UserFactory.getInstance().getFriendsByUser(utente);    
                request.setAttribute("friends", friends);
                ArrayList < Group > groups = GroupFactory.getInstance().getGroupList(utente);   
                request.setAttribute("groups", groups);

                if (request.getParameter("revision") != null) { 
                    request.setAttribute("revision", true);
                    Post post = new Post(); 
                    post.setCreatorUser(utente);
                    post.setId(posts.size());
                    post.setImage(request.getParameter("img"));
                    post.setText(request.getParameter("text"));
                    request.setAttribute("post_r", post);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    return;
                }

                if (request.getParameter("confirm") != null) { 
                    request.setAttribute("confirm", true);  
                    Post post = (Post) request.getAttribute("post_r");
                    PostFactory.getInstance().insertPost(post); 
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response); 
                    return;
                }

                request.getRequestDispatcher("bacheca.jsp").forward(request, response); 
                return;
            }
        }
       
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