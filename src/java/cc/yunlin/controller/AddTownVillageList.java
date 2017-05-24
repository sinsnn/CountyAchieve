/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.yunlin.controller;

import cc.yunlin.model.TownVillageList;
import cc.yunlin.model.TownVillageService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinsnn
 */
@WebServlet(
        name = "AddTownVillageList", 
        urlPatterns = {"/addTownVillageList.do"},
        initParams = {
            @WebInitParam(name = "SUCCESS_VIEW", value = "message.do")
            ,
            @WebInitParam(name = "ERROR_VIEW", value = "message.do")
        })
public class AddTownVillageList extends HttpServlet {

    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");

    }

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
        String townName = request.getParameter("townname");
        String villageName = request.getParameter("villagename");
        TownVillageService townVillageService;
        townVillageService = (TownVillageService) getServletContext().getAttribute("townVillageService");
        
        List<String> errors = new ArrayList<>();
        if(isInvalidTownVillageName(townName)){
            errors.add("鄉鎮市名稱不能為空白");
        }
        if(isInvalidTownVillageName(villageName)){
            errors.add("村里名稱不能為空白");
        }
        
        String resultPage = ERROR_VIEW;
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
        } else {
            resultPage = SUCCESS_VIEW;
            TownVillageList townVillageList = new TownVillageList(townName, villageName);
            townVillageService.add(townVillageList);
        }
         
        request.getRequestDispatcher(resultPage).forward(request, response);
        
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

    private boolean isInvalidTownVillageName(String name) {
        return name == null;
    }
}
