package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.admin.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminDAO extends IServiceDAO<Admin> {
    Admin findUpdatorByMovieId(int movieId);
    Admin findCreatorByMovieId(int movieId);
    Admin findUpdatorByCategoryId(int categoryId);
    Admin findCreatorByCategoryId(int categoryId);
    Admin findUpdatorByEpisodeId(int episodeId);
    Admin findCreatorByEpisodeId(int episodeId);
    Admin findUpdatorByNationalId(int nationalId);
    Admin findCreatorByNationalId(int nationalId);
    Admin findUpdatorByLinkId(int linkId);
    Admin findCreatorByLinkId(int linkId);
    Admin findUpdatorByActorId(int actorId);
    Admin findCreatorByActorId(int actorId);
    Admin findOne(int userId);
    Admin findOne(String username);
}
