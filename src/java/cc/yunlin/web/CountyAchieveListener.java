/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.yunlin.web;

import cc.yunlin.model.TownVillageListDAOImpl;
import cc.yunlin.model.TownVillageService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 *
 * @author sinsnn
 */
@WebListener
public class CountyAchieveListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/CountyAchieve");
            ServletContext context = sce.getServletContext();
//下面需新增 model 的一些服務類別
            context.setAttribute("townVillageService", new TownVillageService(
                    new TownVillageListDAOImpl(dataSource)));
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
