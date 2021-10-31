package com.streammovies.model.watcher;

import java.util.Date;
import java.util.List;
import java.util.Set;

public abstract class AbstractUser {
    private int id;
    private String username;
    private String password;
    private Date dateCreate;
    private Date updateDate;
    private Set<Role> listRole;

    public AbstractUser() {
    }

    public AbstractUser(int id, String username, String password, Date dateCreate, Date updateDate, Set<Role> listRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dateCreate = dateCreate;
        this.updateDate = updateDate;
        this.listRole = listRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<Role> getListRole() {
        return listRole;
    }

    public void setListRole(Set<Role> listRole) {
        this.listRole = listRole;
    }
}
