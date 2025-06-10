package com.telephone.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telephone.entities.SmartPhone;
@Repository
public interface SmartPhoneRepository extends JpaRepository<SmartPhone,Long> {

}
