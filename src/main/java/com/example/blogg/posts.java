package com.example.blogg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


    @Entity
    public class posts {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int userID;
        private String headline;
        private String storytext;


        public posts() {

        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getHeadline() {
            return headline;
        }

        public void setHeadline(String headline) {
            this.headline = headline;
        }


        public String getStorytext() {
            return storytext;
        }

        public void setStorytext(String storytext) {
            this.storytext = storytext;
        }
    }

