/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author parve
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/note"})
public class NoteServlet extends HttpServlet {

 

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
       
       //path of the file
 String path = getServletContext().getRealPath("/WEB-INF/note.txt");
// to read files
BufferedReader br = new BufferedReader(new FileReader(new File(path)));
// to write to a file
PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 

  getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
   return;

       
   
         //getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
     // return;
   
      
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          //path of the file
     String path = getServletContext().getRealPath("/WEB-INF/note.txt");
// to read files
BufferedReader br = new BufferedReader(new FileReader(new File(path)));
// to write to a file
PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 

        
      String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
            // Validation
        if( title == null || title.equals("") || contents == null || contents.equals("") ){
            // if validation fails:
            // Set attributes in the request object, to be forwarded to the JSP
            request.setAttribute("title",title);
            request.setAttribute("contents", contents);
            // use an attribute as a flag to indicate that an error has occured
            request.setAttribute("error",true);
        
          getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
       return;
       
      
      
    }
        else
        {
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
       return;
        }
    }
}

    

