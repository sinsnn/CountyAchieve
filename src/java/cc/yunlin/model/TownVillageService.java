/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.yunlin.model;

import java.util.List;

/**
 *
 * @author sinsnn
 */
public class TownVillageService {

    private final TownVillageListDAO townVillageListDAO;

    public TownVillageService(TownVillageListDAO townVillageListDAO) {
        this.townVillageListDAO = townVillageListDAO;
    }

    public void add(TownVillageList townVillageList) {
        townVillageListDAO.addTownVillageList(townVillageList);
    }

    public List<TownVillageList> getTownVillageLists() {
        return townVillageListDAO.getTownVillageLists();
    }
    
    public void delete(TownVillageList townVillageList) {
        townVillageListDAO.deleteTownVillageList(townVillageList);
    }
}
