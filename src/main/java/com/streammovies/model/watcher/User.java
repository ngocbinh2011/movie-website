package com.streammovies.model.watcher;

import com.streammovies.model.movies.Comment;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class User extends AbstractUser {
    private int hoursView;
    private List<RecordWatch> listRecordWatch;
    private List<Comment> listComment;


    public User() {

    }


    public User(int id, String username, String password, Date dateCreate, Date updateDate, Set<Role> listRole, int hoursView,
                List<RecordWatch> listRecordWatch, List<Comment> listComment) {
        super(id, username, password, dateCreate, updateDate, listRole);
        this.hoursView = hoursView;
        this.listRecordWatch = listRecordWatch;
        this.listComment = listComment;
    }

    public int getHoursView() {
        return hoursView;
    }

    public void setHoursView(int hoursView) {
        this.hoursView = hoursView;
    }

    public List<RecordWatch> getListRecordWatch() {
        return listRecordWatch;
    }

    public void setListRecordWatch(List<RecordWatch> listRecordWatch) {
        this.listRecordWatch = listRecordWatch;
    }

    public List<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(List<Comment> listComment) {
        this.listComment = listComment;
    }
}
