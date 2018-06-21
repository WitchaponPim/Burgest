package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 1/5/2561.
 */

public class Order {
    /**
     * order : [{"total":"400","veg":"onion tomato","price":"40","id_product":"23","qty":"10","id_promotion":"1","comment":"....","sauce":"mayonnaise sauce"},{"total":"180","veg":"onion tomato","price":"45","id_product":"20","qty":"4","id_promotion":"1","comment":"...","sauce":"mayonnaise sauce"},{"total":"20","qty":"1","id_promotion":"1","price":"20","id_product":"35","sauce":"tomato Sauce"},{"total":"32","qty":"1","id_promotion":"1","price":"32","id_product":"40"}]
     * id_member : 2
     */
    private String id_member;
    private List<OrderBean> order;

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
    }

    public List<OrderBean> getOrder() {
        return order;
    }

    public void setOrder(List<OrderBean> order) {
        this.order = order;
    }

    public static class OrderBean {
        /**
         * total : 400
         * veg : onion tomato
         * price : 40
         * id_product : 23
         * qty : 10
         * id_promotion : 1
         * comment : ....
         * sauce : mayonnaise sauce
         */

        private String total;
        private String veg;
        private String price;
        private String id_product;
        private String qty;
        private String id_promotion;
        private String comment;
        private String sauce;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getVeg() {
            return veg;
        }

        public void setVeg(String veg) {
            this.veg = veg;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getId_product() {
            return id_product;
        }

        public void setId_product(String id_product) {
            this.id_product = id_product;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getId_promotion() {
            return id_promotion;
        }

        public void setId_promotion(String id_promotion) {
            this.id_promotion = id_promotion;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getSauce() {
            return sauce;
        }

        public void setSauce(String sauce) {
            this.sauce = sauce;
        }
    }
}
