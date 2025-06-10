package com.telephone.controllers.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telephone.entities.SmartPhone;
import com.telephone.services.SmartPhoneService;

import java.util.List;

@RestController
@RequestMapping("/rest-smartPhone")
public class SmartPhoneRestController {
    @Autowired
    private SmartPhoneService smartPhoneService;
    @PostMapping(value = "")
// http://localhost:8089/rest-smartPhone
/*
{
"phoneNumber": "A-16",
"phoneType": "DOUBLE",
"capacity": 1,
"price": 50.35
}
*/
    public ResponseEntity<SmartPhone> create(@RequestBody SmartPhone smartPhone) {
        SmartPhone createdPhone = smartPhoneService.save( smartPhone);
        return new ResponseEntity<>(createdPhone, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")

// http://localhost:8089/rest-smartPhone/123
    public ResponseEntity<SmartPhone> getById(@PathVariable("id") Long id) {
        SmartPhone foundRoom = smartPhoneService.findById(id);
        return new ResponseEntity<>(foundRoom, HttpStatus.OK);
    }
    @GetMapping(value = "/all")
// http://localhost:8089/rest-smartPhone/all
    public ResponseEntity<List<SmartPhone>> getAll() {
        List<SmartPhone> foundRoom = smartPhoneService.findAll();
        return new ResponseEntity<>(foundRoom, HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
// http://localhost:808/room/123
/*
{
"roomNumber": "C-13",
"roomType": "TWIN",
"floor": 3,
"capacity": 3,
"pricePerNight": 70.45
}
*/
    public ResponseEntity<SmartPhone> update(@PathVariable("id") Long id,
                                       @RequestBody SmartPhone room) {
        SmartPhone updatedRoom = smartPhoneService.update(id, room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
// http://localhost:8089/rest-smartPhone/123
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        smartPhoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
