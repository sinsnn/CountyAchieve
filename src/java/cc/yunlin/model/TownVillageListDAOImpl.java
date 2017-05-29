/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.yunlin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class TownVillageListDAOImpl implements TownVillageListDAO {

    private final DataSource dataSource;

    public TownVillageListDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addTownVillageList(TownVillageList townVillageList) {
        //       Connection conn = null;
        //       PreparedStatement stmt = null;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO town_village_list(town_name, village_name) VALUES (?,?)")) {

            stmt.setString(1, townVillageList.getTownName().trim());
            stmt.setString(2, townVillageList.getVillageName().trim());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<TownVillageList> getTownVillageLists() {
        List<TownVillageList> lists = new ArrayList();
        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement()) {
            ResultSet result;
            result = stmt.executeQuery("SELECT * FROM town_village_list");
            while (result.next()) {
                TownVillageList townVillageList = toTownVillageList(result);
                lists.add(townVillageList);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return lists;

    }

    //封裝一筆鄉鎮村里清單
    private TownVillageList toTownVillageList(ResultSet result) throws SQLException {

        TownVillageList townVillageList = new TownVillageList();

        townVillageList.setNum(result.getInt(1));
        townVillageList.setTownName(result.getString(2));
        townVillageList.setVillageName(result.getString(3));

        return townVillageList;
    }

    @Override
    public void modifyTownVillageList(TownVillageList townVillageList) {
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE town_village_list SET town_name = ?, village_name = ?WHERE num = ?")) {

            stmt.setString(1, townVillageList.getTownName().trim());
            stmt.setString(2, townVillageList.getVillageName().trim());
            stmt.setInt(3, townVillageList.getNum());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void deleteTownVillageList(TownVillageList townVillageList) {
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM  town_village_list WHERE num = ?")) {

            stmt.setInt(1, townVillageList.getNum());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public TownVillageList getTownVillageList(int num) {
        TownVillageList townVillageList = null;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM town_village_list WHERE num=?")) {
            stmt.setInt(1, num);
            ResultSet result;
            result = stmt.executeQuery();
            while (result.next()) {
                townVillageList = toTownVillageList(result);            
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return townVillageList;        
    }

}
