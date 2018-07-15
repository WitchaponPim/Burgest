package com.example.ptwitchapon.burgest.Model;

public class DriverModel {

    /**
     * checkloginadmin : {"status":"success","code":"200","description":"Login is successfuly ","firstname":"Delivery","lastname":"fast","position":"Delivery","id_emp":"2"}
     */

    private CheckloginadminBean checkloginadmin;

    public CheckloginadminBean getCheckloginadmin() {
        return checkloginadmin;
    }

    public void setCheckloginadmin(CheckloginadminBean checkloginadmin) {
        this.checkloginadmin = checkloginadmin;
    }

    public static class CheckloginadminBean {
        /**
         * status : success
         * code : 200
         * description : Login is successfuly
         * firstname : Delivery
         * lastname : fast
         * position : Delivery
         * id_emp : 2
         */

        private String status;
        private String code;
        private String description;
        private String firstname;
        private String lastname;
        private String position;
        private String id_position;
        private String id_emp;


        public String getId_position() {
            return id_position;
        }

        public void setId_position(String id_position) {
            this.id_position = id_position;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getId_emp() {
            return id_emp;
        }

        public void setId_emp(String id_emp) {
            this.id_emp = id_emp;
        }
    }
}
