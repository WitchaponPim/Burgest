package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 16/7/2561.
 */

public class MyDeliverDriver {

    /**
     * status : success
     * code : 200
     * describtion : get order delivery successfuly
     * order : [{"id_order":"11","id_member":"1","id_emp":"2","date":"2018-07-15 23:33:20","totalPrice":"85","id_promotion":null,"id_status":"3","id_orderType":"2","latitude":"13.761519","longitude":"100.548816","Firstname":"Alongkotza","Lastname":"Sriweeragul","Email":"o@a.com","Password":"1234","Cash":"11654.25","Tel":"0123456789","Latitude":"13.00","Longitude":"100.00","token":"e9EkSgeIw-E:APA91bEwJNPhlhgVpconxQRR-ZiOQl6AnOUQhvK5Ozoxp2JyLXcxC5sMoL_YylkUJvxIlgAc6LBC7o-oy6esPu0oTaJ6wQfBKfQCbXMPWBEhrU4zAnjscLclke-hfQCivSEExNxP0MNjSXCKQKxr1bE03qhyzJH5qg"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<OrderBean> order;

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

    public List<OrderBean> getOrder() {
        return order;
    }

    public void setOrder(List<OrderBean> order) {
        this.order = order;
    }

    public static class OrderBean {
        /**
         * id_order : 11
         * id_member : 1
         * id_emp : 2
         * date : 2018-07-15 23:33:20
         * totalPrice : 85
         * id_promotion : null
         * id_status : 3
         * id_orderType : 2
         * latitude : 13.761519
         * longitude : 100.548816
         * Firstname : Alongkotza
         * Lastname : Sriweeragul
         * Email : o@a.com
         * Password : 1234
         * Cash : 11654.25
         * Tel : 0123456789
         * Latitude : 13.00
         * Longitude : 100.00
         * token : e9EkSgeIw-E:APA91bEwJNPhlhgVpconxQRR-ZiOQl6AnOUQhvK5Ozoxp2JyLXcxC5sMoL_YylkUJvxIlgAc6LBC7o-oy6esPu0oTaJ6wQfBKfQCbXMPWBEhrU4zAnjscLclke-hfQCivSEExNxP0MNjSXCKQKxr1bE03qhyzJH5qg
         */

        private String id_order;
        private String id_member;
        private String id_emp;
        private String date;
        private String totalPrice;
        private Object id_promotion;
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

        public Object getId_promotion() {
            return id_promotion;
        }

        public void setId_promotion(Object id_promotion) {
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
