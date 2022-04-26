package org.sid.announcementService.Repository;

import org.sid.announcementService.entities.House;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends MongoRepository<House, String> {

    List<House> findAllById(String id);

    @Query("{ 'IsValidate' : false }")
    List<House> findNotValidateAnnounces();

    @Query("{ 'validation' : true }")
    List<House> findTrueValidateAnnounces();

    @Query("{ 'title' : ?0 }")
    Optional<House> findByHouseTitle(String houseTitle);

    @Query("{ 'validation' : true,'toPublish':false }")
    List<House> findTrueValidateAnnouncesToPublish();

    @Query("{ 'validation' : true,'toPublish':true }")
    List<House> findTrueValidateAnnouncesPublished();

    @Query("{ 'toPublish':false }")
    List<House> findAnnouncesNotPublishedYet();
}


