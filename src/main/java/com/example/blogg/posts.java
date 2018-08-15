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
        private String headline;
        private String storytext;
        private String post;

        public posts() {

        }

        public posts (String post) {
            this.post = post;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
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

