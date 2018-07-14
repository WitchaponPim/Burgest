package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 15/7/2561.
 */

public class DeliveryOrderModel {

    /**
     * status : success
     * code : 200
     * describtion : get producttype successfuly
     * orderlist : [{"id_order":"1","id_member":"1","id_emp":null,"date":"2018-07-14 18:41:30","totalPrice":"40","id_promotion":null,"id_status":"3","id_orderType":"2","latitude":"13.761519","longitude":"100.548816","Firstname":"Alongkotza","Lastname":"Sriweeragul","Email":"o@a.com","Password":"1234","Cash":"11794.25","Tel":"0123456789","Latitude":"","Longitude":"","token":"ccTU6AVnrq8:APA91bF5NfCnjw0XlW6Fzv7dvokzuzeTmcx88oWitdB2fBTmIMWucqmrmv2Y-w6rouZ1CnhZbYle_OV0ZVSSJ9wRCmy7VgbOZQd2RzjGkSOztlH29pYC8PSzF6eKtU0D23CDolVRQ9-FSxlR1O1WlZJ8y3D2uL9W0g"},{"id_order":"2","id_member":"1","id_emp":null,"date":"2018-07-14 22:18:20","totalPrice":"80","id_promotion":null,"id_status":"3","id_orderType":"2","latitude":"13.761519","longitude":"100.548816","Firstname":"Alongkotza","Lastname":"Sriweeragul","Email":"o@a.com","Password":"1234","Cash":"11794.25","Tel":"0123456789","Latitude":"","Longitude":"","token":"ccTU6AVnrq8:APA91bF5NfCnjw0XlW6Fzv7dvokzuzeTmcx88oWitdB2fBTmIMWucqmrmv2Y-w6rouZ1CnhZbYle_OV0ZVSSJ9wRCmy7VgbOZQd2RzjGkSOztlH29pYC8PSzF6eKtU0D23CDolVRQ9-FSxlR1O1WlZJ8y3D2uL9W0g"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<OrderlistBean> orderlist;

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

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public List<OrderlistBean> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<OrderlistBean> orderlist) {
        this.orderlist = orderlist;
    }

    public static class OrderlistBean {
        /**
         * id_order : 1
         * id_member : 1
         * id_emp : null
         * date : 2018-07-14 18:41:30
         * totalPrice : 40
         * id_promotion : null
         * id_status : 3
         * id_orderType : 2
         * latitude : 13.761519
         * longitude : 100.548816
         * Firstname : Alongkotza
         * Lastname : Sriweeragul
         * Email : o@a.com
         * Password : 1234
         * Cash : 11794.25
         * Tel : 0123456789
         * Latitude :
         * Longitude :
         * token : ccTU6AVnrq8:APA91bF5NfCnjw0XlW6Fzv7dvokzuzeTmcx88oWitdB2fBTmIMWucqmrmv2Y-w6rouZ1CnhZbYle_OV0ZVSSJ9wRCmy7VgbOZQd2RzjGkSOztlH29pYC8PSzF6eKtU0D23CDolVRQ9-FSxlR1O1WlZJ8y3D2uL9W0g
         */

        private String id_order;
        private String id_member;
        private String id_emp;
        private String date;
        private String totalPrice;
        private String id_promotion;
        private String id_status;
        private String id_orderType;
        private String latitude;
        private String longitude;
        private String Firstname;
        private String Lastname;
        private String Email;
        private String Password;
        private String Cash;
        private String Tel;
        private String Latitude;
        private String Longitude;
        private String token;

        public String getId_order() {
            return id_order;
        }

        public void setId_order(String id_order) {
            this.id_order = id_order;
        }

        public String getId_member() {
            return id_member;
        }

        public void setId_member(String id_member) {
            this.id_member = id_member;
        }

        public String getId_emp() {
            return id_emp;
        }

        public void setId_emp(String id_emp) {
            this.id_emp = id_emp;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getId_promotion() {
            return id_promotion;
        }

        public void setId_promotion(String id_promotion) {
            this.id_promotion = id_promotion;
        }

        public String getId_status() {
            return id_status;
        }

        public void setId_status(String id_status) {
            this.id_status = id_status;
        }

        public String getId_orderType() {
            return id_orderType;
        }

        public void setId_orderType(String id_orderType) {
            this.id_orderType = id_orderType;
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

        public String getFirstname() {
            return Firstname;
        }

        public void setFirstname(String Firstname) {
            this.Firstname = Firstname;
        }

        public String getLastname() {
            return Lastname;
        }

        public void setLastname(String Lastname) {
            this.Lastname = Lastname;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public String getCash() {
            return Cash;
        }

        public void setCash(String Cash) {
            this.Cash = Cash;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public String getLatitude_mem() {
            return Latitude;
        }

        public void setLatitude_mem(String Latitude) {
            this.Latitude = Latitude;
        }

        public String getLongitude_mem() {
            return Longitude;
        }

        public void setLongitude_mem(String Longitude) {
            this.Longitude = Longitude;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
