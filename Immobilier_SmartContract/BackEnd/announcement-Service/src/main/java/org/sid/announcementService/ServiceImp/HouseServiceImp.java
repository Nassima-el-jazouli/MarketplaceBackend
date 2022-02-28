package org.sid.announcementService.ServiceImp;
import org.sid.announcementService.Repository.HouseRepository;
import org.sid.announcementService.ServiceDao.HouseServiceDao;
import org.sid.announcementService.entities.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HouseServiceImp implements HouseServiceDao {

    @Autowired
    public HouseRepository houseRepository;

    @Override
    public House AddHouse(House house) {

        return  houseRepository.save(house);
    }

    public List<House> getAllHouses(){
        return  houseRepository.findAll();
    }

    public Optional<House> findById(String houseId) {

        return  houseRepository.findById(houseId);
    }

    @Override
    public void delete(House house) {
        houseRepository.delete(house);
    }


    @Override
    public List<House> getNotValidateAnnounces() {
        return houseRepository.findNotValidateAnnounces();
    }

    @Override
    public List<House> getTrueValidateAnnounces() {
        return houseRepository.findTrueValidateAnnounces();
    }

    @Override
    public Optional<House> findByHouseTitle(String houseTitle) {
        return houseRepository.findByHouseTitle(houseTitle);
    }

    @Override
    public List<House> getTrueValidateAnnouncesToPublish() {
        return houseRepository.findTrueValidateAnnouncesToPublish();
    }

    @Override
    public List<House> getTrueValidateAnnouncesPublished() {
        return houseRepository.findTrueValidateAnnouncesPublished();
    }

    @Override
    public List<House> getAnnouncesNotPublishedYet() {
        return  houseRepository.findAnnouncesNotPublishedYet();
    }

}
