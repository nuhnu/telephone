package com.telephone.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Employer")
public class Employer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false, length = 50)
        private String Name;
        @Column(nullable = false, unique = true, length = 100)
        private String email;
        @Column(nullable = false, unique = true, length = 100)
        private long phoneNumber;
        // end added
        public Employer(String Name, Long PhoneNumber, String email) {
            this.Name = Name;
            this.email = email;
            this.phoneNumber = phoneNumber;

        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return Name;
        }
        public void setName(String Name) {
            this.Name = Name;
        }
        public Long getphoneNumber() {
            return phoneNumber;
        }
        public void setphoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
}
