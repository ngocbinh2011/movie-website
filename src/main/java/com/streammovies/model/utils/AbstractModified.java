package com.streammovies.model.utils;

import com.streammovies.model.admin.Admin;

import java.util.Date;

public abstract class AbstractModified {
    private Admin creator;
    private Date createDate;
    private Date updateDate;
    private Admin updator;

    public AbstractModified(Admin creator, Admin updator) {
        this.creator = creator;
        this.updator = updator;
    }

    public AbstractModified() {
    }

    public AbstractModified(Admin creator, Date createDate, Date updateDate, Admin updateBy) {
        this.creator = creator;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.updator = updateBy;
    }

    public Admin getCreator() {
        return creator;
    }

    public void setCreator(Admin creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Admin getUpdator() {
        return updator;
    }

    public void setUpdator(Admin updator) {
        this.updator = updator;
    }
}
