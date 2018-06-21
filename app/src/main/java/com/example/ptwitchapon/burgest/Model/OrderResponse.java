package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 26/4/2561.
 */

public class OrderResponse {

    /**
     * checklogin : {"status":"success","code":"800","description":"Your order has been send!","orderlist":[{"id_member":"2","order":[{"id_product":"12","price":"63","qty":"2","total":"126","id_promotion":"1","comment":"no paper","sauce":"tomato","veg":"onion"},{"id_product":"2","price":"47","qty":"3","total":"141","id_promotion":"1","comment":"more paper","sauce":"paper","veg":"tomato"},{"id_product":"5","price":"65","qty":"10","total":"650","id_promotion":"1","comment":"more paper yer yer","sauce":"tomato","veg":"onion"}]}]}
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
         * code : 800
         * description : Your order has been send!
         * orderlist : [{"id_member":"2","order":[{"id_product":"12","price":"63","qty":"2","total":"126","id_promotion":"1","comment":"no paper","sauce":"tomato","veg":"onion"},{"id_product":"2","price":"47","qty":"3","total":"141","id_promotion":"1","comment":"more paper","sauce":"paper","veg":"tomato"},{"id_product":"5","price":"65","qty":"10","total":"650","id_promotion":"1","comment":"more paper yer yer","sauce":"tomato","veg":"onion"}]}]
         */

        private String status;
        private String code;
        private String description;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<OrderlistBean> getOrderlist() {
            return orderlist;
        }

        public void setOrderlist(List<OrderlistBean> orderlist) {
            this.orderlist = orderlist;
        }

        public static class OrderlistBean {
            /**
             * id_member : 2
             * order : [{"id_product":"12","price":"63","qty":"2","total":"126","id_promotion":"1","comment":"no paper","sauce":"tomato","veg":"onion"},{"id_product":"2","price":"47","qty":"3","total":"141","id_promotion":"1","comment":"more paper","sauce":"paper","veg":"tomato"},{"id_product":"5","price":"65","qty":"10","total":"650","id_promotion":"1","comment":"more paper yer yer","sauce":"tomato","veg":"onion"}]
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
                 * id_product : 12
                 * price : 63
                 * qty : 2
                 * total : 126
                 * id_promotion : 1
                 * comment : no paper
                 * sauce : tomato
                 * veg : onion
                 */

                private String id_product;
                private String price;
                private String qty;
                private String total;
                private String id_promotion;
                private String comment;
                private String sauce;
                private String veg;

                public String getId_product() {
                    return id_product;
                }

                public void setId_product(String id_product) {
                    this.id_product = id_product;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getQty() {
                    return qty;
                }

                public void setQty(String qty) {
                    this.qty = qty;
                }

                public String getTotal() {
                    return total;
                }

                public void setTotal(String total) {
                    this.total = total;
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

                public String getVeg() {
                    return veg;
                }

                public void setVeg(String veg) {
                    this.veg = veg;
                }
            }
        }
    }
}
