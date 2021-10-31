package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IAdminDAO;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.watcher.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDAO extends ServiceDAO<Admin> implements IAdminDAO {

    @Autowired
    private IMapper<Admin> mapper;

    @Override
    public Admin findUpdatorByMovieId(int movieId) {
        String sql = "SELECT ADM.*, U.* FROM administator AS ADM INNER JOIN movie AS M\n" +
                "ON M.author_id = ADM.user_id INNER JOIN USER AS U ON U.ID = ADM.USER_ID WHERE M.id = ?";
        List<Admin> result = query(sql, mapper, movieId);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public Admin findCreatorByMovieId(int movieId) {
        String sql = "SELECT ADM.*, U.* FROM administator AS ADM INNER JOIN movie AS M\n" +
                "ON M.update_by = ADM.user_id INNER JOIN USER AS U ON U.ID = ADM.USER_ID WHERE M.id = ?";
        List<Admin> result = query(sql, mapper, movieId);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public Admin findUpdatorByCategoryId(int categoryId) {
        return null;
    }

    @Override
    public Admin findCreatorByCategoryId(int categoryId) {
        return null;
    }

    @Override
    public Admin findUpdatorByEpisodeId(int episodeId) {
        return null;
    }

    @Override
    public Admin findCreatorByEpisodeId(int episodeId) {
        return null;
    }

    @Override
    public Admin findUpdatorByNationalId(int nationalId) {
        return null;
    }

    @Override
    public Admin findCreatorByNationalId(int nationalId) {
        return null;
    }

    @Override
    public Admin findUpdatorByLinkId(int linkId) {
        return null;
    }

    @Override
    public Admin findCreatorByLinkId(int linkId) {
        return null;
    }

    @Override
    public Admin findUpdatorByActorId(int actorId) {
        return null;
    }

    @Override
    public Admin findCreatorByActorId(int actorId) {
        return null;
    }

    @Override
    public Admin findOne(int userId) {
        return null;
    }

    @Override
    public Admin findOne(String username) {
        String sql = "SELECT * FROM administator AS A INNER JOIN USER AS U ON U.ID = A.USER_ID " +
                "WHERE U.U_USERNAME = ?";
        List<Admin> result = query(sql, mapper, username);
        return result.isEmpty()? null : result.get(0);
    }
}
