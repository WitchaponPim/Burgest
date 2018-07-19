package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 29/4/2561.
 */

public class Orderlist {
    /**
     * status : success
     * code : 200
     * describtion : get orderlist successfuly
     * items : [{"id_order":"19","id_member":"2","id_emp":null,"date":"2018-05-16 00:19:43","totalPrice":"917","id_promotion":null,"id_status":"5","id_orderType":"2","status":"รอการอนุมัติ","Firstname":"Poon","Lastname":"Pim","Email":"a@m.com","Password":"123456","Cash":"2000","Tel":"0820665945","Latitude":"97845632","Longitude":"0"},{"id_order":"22","id_member":"2","id_emp":null,"date":"2018-05-16 04:58:50","totalPrice":"92","id_promotion":null,"id_status":"5","id_orderType":"2","status":"รอการอนุมัติ","Firstname":"Poon","Lastname":"Pim","Email":"a@m.com","Password":"123456","Cash":"2000","Tel":"0820665945","Latitude":"97845632","Longitude":"0"},{"id_order":"23","id_member":"2","id_emp":null,"date":"2018-05-29 17:59:03","totalPrice":"92","id_promotion":null,"id_status":"5","id_orderType":"2","status":"รอการอนุมัติ","Firstname":"Poon","Lastname":"Pim","Email":"a@m.com","Password":"123456","Cash":"2000","Tel":"0820665945","Latitude":"97845632","Longitude":"0"}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<ItemsBean> items;

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

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id_order : 19
         * id_member : 2
         * id_emp : null
         * date : 2018-05-16 00:19:43
         * totalPrice : 917
         * id_promotion : null
         * id_status : 5
         * id_orderType : 2
         * status : รอการอนุมัติ
         * Firstname : Poon
         * Lastname : Pim
         * Email : a@m.com
         * Password : 123456
         * Cash : 2000
         * Tel : 0820665945
         * Latitude : 97845632
         * Longitude : 0
         */

        private String id_order;
        private String id_member;
        private Object id_emp;
        private String date;
        private String totalPrice;
        private Object id_promotion;
        private String id_status;
        private String id_orderType;
        private String status_type;
        private String status;
        private String Firstname;
        private String Lastname;
        private String Email;
        private String Password;
        private String Cash;
        private String Tel;
        private String Latitude;
        private String Longitude;

        public String getStatus_type() {
            return status_type;
        }

        public void setStatus_type(String status_type) {
            this.status_type = status_type;
        }

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

        public Object getId_emp() {
            return id_emp;
        }

        public void setId_emp(Object id_emp) {
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getLatitude() {
            return Latitude;
        }

        public void setLatitude(String Latitude) {
            this.Latitude = Latitude;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String Longitude) {
            this.Longitude = Longitude;
        }
    }
}
