/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.customtags;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author billy
 */
public class WelcomeMessage extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();

            int year = Calendar.getInstance().get(Calendar.YEAR);
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();

            out.println("<h3>Welcome to the call center app! The current date is " + today + "</h3>");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
