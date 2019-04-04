/**
 * Document   : Assigned To
    Created on : 31-Jan-2019
    Author     : billy
    Assignment 2
 */
package com.nbcc.customtags;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author billy
 */
public class AssignedToDropDownList extends TagSupport {

    private String controlName;
    private String valueField;
    private String textField;

    private String url = "";
    private String user = "";
    private String password = "";

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public int doStartTag() throws JspException {
        String sqlRetrieveTechnicians = "SELECT * FROM Technicians";
        StringBuilder dynamicSelect = new StringBuilder("<select name=\"" + getControlName() + "\">");

        JspWriter out = pageContext.getOut();

        try {
            getProperties();

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    try (ResultSet rs = stmt.executeQuery(sqlRetrieveTechnicians)) {
                        while (rs.next()) {
                            dynamicSelect.append("<option value=\"");
                            dynamicSelect.append(rs.getString(getValueField()));
                            dynamicSelect.append("\">");
                            dynamicSelect.append(rs.getString(getTextField()));
                            dynamicSelect.append("</option>");
                        }
                    } catch (Exception ex) {
                        System.out.println("");
                    }
                } catch (Exception ex) {
                    System.out.println("");
                }
            } catch (Exception ex) {
                System.out.println("");
            }
            //Close the select
            dynamicSelect.append("</select>");
            out.println(dynamicSelect.toString());

        } catch (Exception ex) {
            System.out.println("");
        }
        return 0;
    }
    
    
    public int doEndTage(){
        return EVAL_PAGE;
    }

    /**
     * Get the properties from the properties file
     * @return 
     */
    private Properties getProperties() {
        //Ensure the properties file has been created
        //Project Properties > Other > Other > Properties File > Name the file db
        Properties props = new Properties();

        try {
            //Get the path to my db.properties file
            String propertiesPath = pageContext.getServletContext().getRealPath("/WEB-INF/db.properties");
            FileInputStream in = new FileInputStream(propertiesPath);
            props.load(in);
            in.close();

            //Set the conn string props
            url = props.getProperty("mysql.url");
            user = props.getProperty("mysql.username");
            password = props.getProperty("mysql.password");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return props;
    }
}
