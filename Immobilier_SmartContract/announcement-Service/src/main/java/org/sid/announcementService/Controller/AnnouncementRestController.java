package org.sid.announcementService.Controller;

import org.sid.announcementService.Repository.HouseRepository;
import org.sid.announcementService.ServiceImp.HouseServiceImp;
import org.sid.announcementService.entities.House;
//import org.sid.announcementService.feign.userFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Announce")
public class AnnouncementRestController {

@Autowired
public HouseServiceImp houseServiceImp;

    @Autowired
    public HouseRepository houseRepository;

/*
@Autowired
public  userFeign userFeign;
*/


    @GetMapping(path="/hello")
    public String hello() throws Exception {
        return "salam";
    }


    @PostMapping(path = "/AddAnnounce")
    public  void AddAnnounce(@RequestBody House house
                            /*@RequestParam(value = "location") String location,
                             @RequestParam(value = "cost") Double cost,
                             @RequestParam(value = "image") String image,
                             @RequestParam(value = "description") String description,
                             @RequestParam(value = "ownerAddress") String ownerAddress*/){

        //House house = new House(null,location,cost,image,description,ownerAddress,false);
        System.out.println("$$$$$$$$your house title$$$$$$$$$$$$$$ : "+house.getHouseTitle());
        System.out.println("$$$$$$$$your house2 title$$$$$$$$$$$$$$ : "+house.getTitle());
        System.out.println(house.getCost());
        houseServiceImp.AddHouse(house);

    }

    @GetMapping("/Announce")
    public List<House> getAllAnnounces() {
        return (List<House>) houseServiceImp.getAllHouses();
    }

    @GetMapping("/AnnouncesTrueValidate")
    public List<House> getTrueValidateAnnounces() {
        return (List<House>) houseServiceImp.getTrueValidateAnnounces();
    }

    @GetMapping("/AnnouncesTrueValidateToPublish")
    public List<House> getTrueValidateAnnouncesToPublish() {
        return (List<House>) houseServiceImp.getTrueValidateAnnouncesToPublish();
    }

    @GetMapping("/AnnouncesTrueValidatePublished")
    public List<House> getTrueValidateAnnouncesPublished() {
        return (List<House>) houseServiceImp.getTrueValidateAnnouncesPublished();
    }

    @GetMapping("/AnnouncesNotPublishedYet")
    public List<House> getAnnouncesNotPublishedYet() {
        return (List<House>) houseServiceImp.getAnnouncesNotPublishedYet();
    }

    @GetMapping("/AnnouncesNotValidate")
    public List<House> getNotValidateAnnounces() {
        return (List<House>) houseServiceImp.getNotValidateAnnounces();
    }


    @GetMapping("/Announce/{id}")
    public ResponseEntity< House > getHouseById(@PathVariable(value = "id") String AnnounceId)
            throws ResourceNotFoundException {
        House house = houseServiceImp.findById(AnnounceId)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + AnnounceId));
        return ResponseEntity.ok().body(house);
    }

    @PutMapping("/Announce/{id}")
    public ResponseEntity < House > updateAnnounce(@PathVariable(value = "id") String AnnounceId,
                                                   @Valid @RequestBody House HouseDetails)
                                                    throws ResourceNotFoundException {
        House house = houseServiceImp.findById(AnnounceId)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + AnnounceId));

        house.setLocation(HouseDetails.getLocation());
        house.setCost(HouseDetails.getCost());
        house.setImage(HouseDetails.getImage());
        house.setOwnerAddress(HouseDetails.getOwnerAddress());
        final House updatedAnnounce = houseServiceImp.AddHouse(house);
        return ResponseEntity.ok(updatedAnnounce);

    }

    @DeleteMapping("/Announce/{id}")
    public Map< String, Boolean > deleteCategory(@PathVariable(value = "id") String categoryId)
            throws ResourceNotFoundException {
        House category = houseServiceImp.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

        houseServiceImp.delete(category);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

   @PutMapping("/validate/{title}")
    public ResponseEntity < House > validateAnnounce(@PathVariable(value = "title") String HouseTitle)
            throws ResourceNotFoundException {
       System.out.println("$$$$$$$$$$$$$$$$$$$"+HouseTitle);

       House house = houseServiceImp.findByHouseTitle(HouseTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + HouseTitle));

        house.setValidation(true);
        house.setIsValidate(true);

        final House validatedAnnounce = houseServiceImp.AddHouse(house);
        return ResponseEntity.ok(validatedAnnounce);

    }

    @PutMapping("/rejectAnnounce/{title}")
    public ResponseEntity < House > rejectAnnounce(@PathVariable(value = "title") String HouseTitle)
            throws ResourceNotFoundException {
        System.out.println("$$$$$$$$$$$$$$$$$$$"+HouseTitle);

        House house = houseServiceImp.findByHouseTitle(HouseTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + HouseTitle));

        house.setValidation(false);
        house.setIsValidate(true);
        house.setRejected(true);

        final House validatedAnnounce = houseServiceImp.AddHouse(house);
        return ResponseEntity.ok(validatedAnnounce);

    }

    @PutMapping("/AddToPublication/{title}")
    public ResponseEntity < House > AddToPublication(@PathVariable(value = "title") String HouseTitle)
            throws ResourceNotFoundException {
        System.out.println("$$$$$$$$$$$$$$$$$$$"+HouseTitle);

        House house = houseServiceImp.findByHouseTitle(HouseTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + HouseTitle));

        house.setToPublish(true);

        final House validatedAnnounce = houseServiceImp.AddHouse(house);
        return ResponseEntity.ok(validatedAnnounce);

    }

    @PutMapping("/RemoveFromPublication/{title}")
    public ResponseEntity < House > RemoveFromPublication(@PathVariable(value = "title") String HouseTitle)
            throws ResourceNotFoundException {
        System.out.println("$$$$$$$$$$$$$$$$$$$"+HouseTitle);

        House house = houseServiceImp.findByHouseTitle(HouseTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + HouseTitle));

        house.setToPublish(false);

        final House validatedAnnounce = houseServiceImp.AddHouse(house);
        return ResponseEntity.ok(validatedAnnounce);

    }


   /* @GetMapping("/GetUserById")
    public String GetUserById(HttpServletRequest request) {
        String id = userFeign.getUserId(request.getHeader("Authorization"));
        return  id;
    }

    @GetMapping("/consulterById")
    public List<House> showPropertyListByUserId(HttpServletRequest request) {
        String id = userFeign.getUserId(request.getHeader("Authorization"));
        return  houseRepository.findAllById(id); //must be changed to metier
    }*/
}

