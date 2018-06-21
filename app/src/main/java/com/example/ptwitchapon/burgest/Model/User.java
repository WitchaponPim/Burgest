package com.example.ptwitchapon.burgest.Model;

/**
 * Created by Killy77 on 14/4/2561.
 */

public class User {


    /**
     * checklogin : {"status":"success","code":"200","description":"Login is successfuly ","id_member":"2","firstname":"Poon","lastname":"Pim","cash":"0","tel":"0820665945","email":"a@m.com","latitude":"97845632","longitude":"0"}
     */

    private CheckloginBean checklogin;

    public CheckloginBean getChecklogin() {
        return checklogin;
    }

    public void setChecklogin(CheckloginBean checklogin) {
        this.checklogin = checklogin;
    }

    public static class CheckloginBean {
        /**
         * status : success
         * code : 200
         * description : Login is successfuly
         * id_member : 2
         * firstname : Poon
         * lastname : Pim
         * cash : 0
         * tel : 0820665945
         * email : a@m.com
         * latitude : 97845632
         * longitude : 0
         */

        private String status;
        private String code;
        private String description;
        private String id_member;
        private String firstname;
        private String lastname;
        private String cash;
        private String tel;
        private String email;
        private String latitude;
        private String longitude;

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

        public String getId_member() {
            return id_member;
        }

        public void setId_member(String id_member) {
            this.id_member = id_member;
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

        public String getCash() {
            return cash;
        }

        public void setCash(String cash) {
            this.cash = cash;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }
}
