/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.yunlin.model;

import java.io.Serializable;

/**
 *
 * @author sinsnn
 */
public class TownVillageList implements Serializable {

    private int num; //編號
    private String townName;
    private String villageName;

    public TownVillageList() {
    }

    public TownVillageList(String townName, String villageName) {
        this.townName = townName;
        this.villageName = villageName;
    }
    
    public TownVillageList(int num,String townName, String villageName) {
        this.num = num;
        this.townName = townName;
        this.villageName = villageName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}
