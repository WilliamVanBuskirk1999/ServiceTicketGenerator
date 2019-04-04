/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc;

import com.nbcc.exception.ServiceTicketException;
import com.nbcc.serviceticket.business.ServiceTicket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author billy
 */
public class CreateServiceTicketServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateServiceTicketServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateServiceTicketServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
         String msg = "";
         String url = "create_service_ticket.jsp";
        try {
            if (request.getParameter("submit") != null) {
                //Gross tightly coupled dependency
                ServiceTicket newTicket = new ServiceTicket();

                newTicket.setActionTaken(request.getParameter("txtDiagnostic"));
                newTicket.setAssignedTo(request.getParameter("ddlEngineers"));
                newTicket.setCurrentState(request.getParameter("ddlState"));
                newTicket.setLongDescription(request.getParameter("txtLongDesc"));
                newTicket.setSeverity(request.getParameter("ddlSeverity"));
                newTicket.setShortDescription("txtShortDescription");

                //Working with the radio button parameters
                if ("open".equals(request.getParameter("status"))) {
                    newTicket.setIsOpen(true);
                } else {
                    newTicket.setIsOpen(false);
                }

                //Working with dropdowns to get the date of last action
                Calendar dateOfLast = Calendar.getInstance();
                dateOfLast.set(Calendar.MONTH, newTicket.getMonthNumber(request.getParameter("ddlMonthOfLast")));
                dateOfLast.set(Calendar.YEAR, Integer.parseInt(request.getParameter("ddlYearOfLast")));
                dateOfLast.set(Calendar.DAY_OF_MONTH, Integer.parseInt(request.getParameter("ddlDayOfLast")));
                newTicket.setDateLastActioned(dateOfLast.getTime());

                Calendar dateOfOpening = Calendar.getInstance();
                dateOfOpening.set(Calendar.MONTH, newTicket.getMonthNumber(request.getParameter("ddlMonthOpened")));
                dateOfOpening.set(Calendar.YEAR, Integer.parseInt(request.getParameter("ddlYearOpened")));
                dateOfOpening.set(Calendar.DAY_OF_MONTH, Integer.parseInt(request.getParameter("ddlDayOpened")));
                newTicket.setDateOpened(dateOfOpening.getTime());

                newTicket.createServiceTicket();

                HttpSession session = request.getSession();
                session.setAttribute("newTicket",newTicket);
                
                url = "ticketSummary.jsp";                
            }
        }catch (ServiceTicketException ex) {
            msg = ex.getMessage();
        }catch (Exception ex) {
           msg = ex.getMessage();
        } 
        
        request.getSession().setAttribute("message",msg);
        
        response.sendRedirect(url);

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
