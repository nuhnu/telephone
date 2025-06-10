package com.telephone.entities;
import com.telephone.enums.Phone_Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
@AllArgsConstructor

@Entity
@Table(name = "SmartPhone")
public class SmartPhone {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "phone_number", nullable = false, unique = true)
        private String phoneNumber;
        @Enumerated(EnumType.STRING)
        @Column(name = "Phone_Type", nullable = false)
        private Phone_Type phoneType;
        @Column(nullable = false)
        private Integer capacity;
        @Column(name = "price", nullable = false, precision = 10)
        private Double price;
        public SmartPhone() {
        }
        public SmartPhone(String phoneNumber, Phone_Type phoneType, Integer
                capacity, Double price) {
            this.phoneNumber = phoneNumber;
            this.phoneType = phoneType;
            this.capacity = capacity;
            this.price = price;
        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;

        }
        public Phone_Type getPhoneType() {
            return phoneType;
        }
        public void setPhoneType(Phone_Type phoneType) {
            this.phoneType = phoneType;
        }
        public Integer getCapacity() {
            return capacity;
        }
        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }
        public Double getPrice() {
            return price;
        }
        public void setPrice(Double price) {
            this.price = price;
        }

}
