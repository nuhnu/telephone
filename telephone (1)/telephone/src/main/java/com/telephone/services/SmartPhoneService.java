package com.telephone.services;

import com.telephone.entities.SmartPhone;
import com.telephone.repositories.SmartPhoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;
    public SmartPhone save(SmartPhone smartPhone){return smartPhoneRepository.save(smartPhone);}

    public SmartPhone findById(Long id) {
        return smartPhoneRepository.findById(id).orElseThrow(
                ()-> new IllegalThreadStateException("Unable to find smartphone with id"+id));
    }
    public List<SmartPhone> findAll(){ return smartPhoneRepository.findAll();}
    public SmartPhone update (Long id,SmartPhone smartPhoneUpdate){
        SmartPhone foundSmartPhone = findById(id);
        foundSmartPhone.setPhoneNumber(smartPhoneUpdate.getPhoneNumber());
        foundSmartPhone.setPhoneType(smartPhoneUpdate.getPhoneType());
        foundSmartPhone.setCapacity(smartPhoneUpdate.getCapacity());
        foundSmartPhone.setPrice(smartPhoneUpdate.getPrice());
        return save(foundSmartPhone);
    }
    public void delete (Long id ){
        smartPhoneRepository.deleteById(id);
    }
    public void deleteAll() { smartPhoneRepository.deleteAll();}
}
