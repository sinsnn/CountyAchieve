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
public interface TownVillageListDAO {
    void addTownVillageList(TownVillageList townVillageList); //新增一筆清單
    List<TownVillageList> getTownVillageLists();  //傳回全部的鄉鎮村里清單
    
}
