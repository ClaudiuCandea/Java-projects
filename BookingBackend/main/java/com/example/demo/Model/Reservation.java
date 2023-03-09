package com.example.demo.Model;

import jakarta.persistence.*;


@Table
@Entity
public class Reservation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private long userID;
        private long  hotelID;
        private String hotelName;
        private double totalPrice;
        private int noNight;

        public Reservation() {
        }

        public Reservation(long id, long userID, long hotelID,String hotelName,double totalPrice, int noNight) {
                this.id = id;
                this.userID = userID;
                this.hotelID = hotelID;
                this.noNight = noNight;
                this.hotelName = hotelName;
                this.totalPrice = totalPrice;
        }

        public Reservation(long userID, long hotelID,String hotelName,double totalPrice, int noNight) {
                this.userID = userID;
                this.hotelID = hotelID;
                this.noNight = noNight;
                this.hotelName = hotelName;
                this.totalPrice = totalPrice;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public int getNoNight() {
                return noNight;
        }

        public void setNoNight(int noNight) {
                this.noNight = noNight;
        }

        public long getUserID() {
                return userID;
        }

        public void setUserID(long userID) {
                this.userID = userID;
        }

        public long getHotelID() {
                return hotelID;
        }

        public void setHotelID(long hotelID) {
                this.hotelID = hotelID;
        }

        public String getHotelName() {
                return hotelName;
        }

        public void setHotelName(String hotelName) {
                this.hotelName = hotelName;
        }

        public double getTotalPrice() {
                return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
                this.totalPrice = totalPrice;
        }
}
