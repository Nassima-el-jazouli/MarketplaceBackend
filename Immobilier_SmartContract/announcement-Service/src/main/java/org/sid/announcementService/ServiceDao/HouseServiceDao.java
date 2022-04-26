package org.sid.announcementService.ServiceDao;

import org.sid.announcementService.entities.House;

import java.util.List;
import java.util.Optional;

public interface HouseServiceDao {
    public House AddHouse(House house);
    public List<House> getAllHouses();
    public Optional<House> findById(String id);


    void delete(House house);



    public List<House> getNotValidateAnnounces();

    public List<House> getTrueValidateAnnounces();

    Optional<House> findByHouseTitle(String houseTitle);

    public List<House> getTrueValidateAnnouncesToPublish();

    public List<House> getTrueValidateAnnouncesPublished();

    public List<House> getAnnouncesNotPublishedYet();

}

