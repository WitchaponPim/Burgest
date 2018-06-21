package com.example.ptwitchapon.burgest.Model;

import java.util.List;

/**
 * Created by Killy77 on 15/4/2561.
 */

public class Product {

    /**
     * status : success
     * code : 200
     * describtion : get menu successfuly
     * product : [{"id":"1","name":"Chicken","burgur":[{"id_productType":"1","TypeName":"Chicken","id_product":"1","ProductName":"CHICKEN","Price":"40","QRCode":"","Path":"c40b.png"},{"id_productType":"1","TypeName":"Chicken","id_product":"2","ProductName":"CHICKEN EGG","Price":"47","QRCode":"","Path":"c47b.png"},{"id_productType":"1","TypeName":"Chicken","id_product":"3","ProductName":"CHICKEN CHEESE","Price":"49","QRCode":"","Path":"c49b.png"},{"id_productType":"1","TypeName":"Chicken","id_product":"4","ProductName":"CHICKEN CHEESE BACON","Price":"55","QRCode":"","Path":"c55b.png"},{"id_productType":"1","TypeName":"Chicken","id_product":"5","ProductName":"CHICKEN CHEESE BACON EGG","Price":"65","QRCode":"","Path":"c65b.png"}]},{"id":"2","name":"Fish","burgur":[{"id_productType":"2","TypeName":"Fish","id_product":"6","ProductName":"FISH","Price":"40","QRCode":"","Path":"f40b.png"},{"id_productType":"2","TypeName":"Fish","id_product":"7","ProductName":"FISH EGG","Price":"47","QRCode":"","Path":"f47b.png"},{"id_productType":"2","TypeName":"Fish","id_product":"8","ProductName":"FISH CHEESE","Price":"49","QRCode":"","Path":"f49b.png"},{"id_productType":"2","TypeName":"Fish","id_product":"9","ProductName":"FISH CHEESE EGG","Price":"55","QRCode":"","Path":"f55b.png"},{"id_productType":"2","TypeName":"Fish","id_product":"10","ProductName":"FISH CHEESE BACON","Price":"59","QRCode":"","Path":"f59b.png"}]},{"id":"3","name":"Beef Large","burgur":[{"id_productType":"3","TypeName":"Beef Large","id_product":"11","ProductName":"BEEF LARGE","Price":"55","QRCode":"","Path":"l55.png"},{"id_productType":"3","TypeName":"Beef Large","id_product":"12","ProductName":"BEEF LARGE CHEESE","Price":"63","QRCode":"","Path":"l63.png"},{"id_productType":"3","TypeName":"Beef Large","id_product":"13","ProductName":"BEEF LARGE BACON","Price":"65","QRCode":"","Path":"l65.png"},{"id_productType":"3","TypeName":"Beef Large","id_product":"14","ProductName":"BEEF LARGE DOUBLE CHEESE","Price":"69","QRCode":"","Path":"l69.png"},{"id_productType":"3","TypeName":"Beef Large","id_product":"15","ProductName":"BEEF LARGE CHEESE BACON","Price":"73","QRCode":"","Path":"l73.png"},{"id_productType":"3","TypeName":"Beef Large","id_product":"16","ProductName":"BEEF LARGE CHEESE BACON EGG","Price":"79","QRCode":"","Path":"l79.png"}]},{"id":"4","name":"Beef ","burgur":[{"id_productType":"4","TypeName":"Beef ","id_product":"17","ProductName":"DUBLE BEEF","Price":"85","QRCode":"","Path":"l85.png"},{"id_productType":"4","TypeName":"Beef ","id_product":"18","ProductName":"DUBLE BEEF DUBLE CHEESE","Price":"99","QRCode":"","Path":"l99.png"},{"id_productType":"4","TypeName":"Beef ","id_product":"19","ProductName":"DUBLE BEEF DUBLE CHEESE BACON","Price":"109","QRCode":"","Path":"l109.png"},{"id_productType":"4","TypeName":"Beef ","id_product":"20","ProductName":"BEEF","Price":"45","QRCode":"","Path":"m45.png"},{"id_productType":"4","TypeName":"Beef ","id_product":"21","ProductName":"BEEF CHEESE","Price":"53","QRCode":"","Path":"m53.png"},{"id_productType":"4","TypeName":"Beef ","id_product":"22","ProductName":"BEEF CHEESE BACON","Price":"63","QRCode":"","Path":"m63.png"}]},{"id":"5","name":"Pork ","burgur":[{"id_productType":"5","TypeName":"Pork ","id_product":"23","ProductName":"PORK","Price":"40","QRCode":"","Path":"p40b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"24","ProductName":"PORK EGG","Price":"47","QRCode":"","Path":"p47b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"25","ProductName":"PORK CHEESE","Price":"49","QRCode":"","Path":"p49b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"26","ProductName":"PORK BACON","Price":"50","QRCode":"","Path":"p50b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"27","ProductName":"PORK CHEESE EGG","Price":"55","QRCode":"","Path":"p55b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"28","ProductName":"PORK CHEESE BACON","Price":"59","QRCode":"","Path":"p59b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"29","ProductName":"DUBLE PORK","Price":"60","QRCode":"","Path":"p60b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"30","ProductName":"PORK CHEESE BACON EGG","Price":"65","QRCode":"","Path":"p65b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"31","ProductName":"DUBLE PORK DUBLE CHEESE","Price":"75","QRCode":"","Path":"p75b.png"},{"id_productType":"5","TypeName":"Pork ","id_product":"32","ProductName":"DUBLE PORK DUBLE CHEESE BACON","Price":"85","QRCode":"","Path":"p85b.png"}]},{"id":"6","name":"Chicken Spicy","burgur":[{"id_productType":"6","TypeName":"Chicken Spicy","id_product":"33","ProductName":"SPICY","Price":"40","QRCode":"","Path":"s40b.png"},{"id_productType":"6","TypeName":"Chicken Spicy","id_product":"34","ProductName":"SPICY CHEESE","Price":"49","QRCode":"","Path":"s49b.png"}]},{"id":"7","name":"Other","burgur":[{"id_productType":"7","TypeName":"Other","id_product":"35","ProductName":"FRENFRIED SMALL","Price":"20","QRCode":"","Path":"fren204060b.png"},{"id_productType":"7","TypeName":"Other","id_product":"36","ProductName":"FRENFRIED MEDIUM","Price":"40","QRCode":"","Path":"fren204060b.png"},{"id_productType":"7","TypeName":"Other","id_product":"37","ProductName":"FRENFRIED LARGE","Price":"60","QRCode":"","Path":"fren204060b.png"},{"id_productType":"7","TypeName":"Other","id_product":"38","ProductName":"KARA-AGE","Price":"29","QRCode":"","Path":"kara29b.png"},{"id_productType":"7","TypeName":"Other","id_product":"39","ProductName":"CHEESE BALL","Price":"39","QRCode":"","Path":"cheese39b.png"}]},{"id":"8","name":"Water","burgur":[{"id_productType":"8","TypeName":"Water","id_product":"40","ProductName":"COKE MEDIUM","Price":"32","QRCode":"","Path":"cm32.jpg"},{"id_productType":"8","TypeName":"Water","id_product":"41","ProductName":"COKE SMALL","Price":"17","QRCode":"","Path":"cm17.jpg"},{"id_productType":"8","TypeName":"Water","id_product":"42","ProductName":"SPRITE MEDIUM","Price":"32","QRCode":"","Path":"spritem32.jpg"},{"id_productType":"8","TypeName":"Water","id_product":"43","ProductName":"SPRITE SMALL","Price":"17","QRCode":"","Path":"sprites17.jpg"},{"id_productType":"8","TypeName":"Water","id_product":"44","ProductName":"WATER MEDIUM","Price":"20","QRCode":"","Path":"waterm20.jpg"},{"id_productType":"8","TypeName":"Water","id_product":"45","ProductName":"WATER SMALL","Price":"10","QRCode":"","Path":"waterm10.jpg"}]},{"id":"9","name":"Promotion","burgur":[{"id_productType":"9","TypeName":"Promotion","id_product":"46","ProductName":"SET A BEEF LARGE CHEESE + FRENFRIED SMALL + COKE SMALL","Price":"94","QRCode":"","Path":"seta.png"},{"id_productType":"9","TypeName":"Promotion","id_product":"47","ProductName":"SET B PORK CHEESE + FRENFRIED SMALL + COKE SMALL","Price":"79","QRCode":"","Path":"setb.png"},{"id_productType":"9","TypeName":"Promotion","id_product":"48","ProductName":"SET C CHICKEN CHEESE + FRENFRIED SMALL + COKE SMALL","Price":"79","QRCode":"","Path":"setc.png"},{"id_productType":"9","TypeName":"Promotion","id_product":"49","ProductName":"SET D SPICY CHEESE + FRENFRIED SMALL + COKE SMALL","Price":"79","QRCode":"","Path":"setd.png"},{"id_productType":"9","TypeName":"Promotion","id_product":"50","ProductName":"SET E FISH CHEESE + FRENFRIED SMALL + COKE SMALL","Price":"79","QRCode":"","Path":"sete.png"}]}]
     */

    private String status;
    private String code;
    private String describtion;
    private List<ProductBean> product;

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

    public List<ProductBean> getProduct() {
        return product;
    }

    public void setProduct(List<ProductBean> product) {
        this.product = product;
    }

    public static class ProductBean {
        /**
         * id : 1
         * name : Chicken
         * burgur : [{"id_productType":"1","TypeName":"Chicken","id_product":"1","ProductName":"CHICKEN","Price":"40","QRCode":"","Path":"c40b.png"},{"id_productType":"1","TypeName":"Chicken","id_product":"2","ProductName":"CHICKEN EGG","Price":"47","QRCode":"","Path":"c47b.png"},{"id_productType":"1","TypeName":"Chicken","id_product":"3","ProductName":"CHICKEN CHEESE","Price":"49","QRCode":"","Path":"c49b.png"},{"id_productType":"1","TypeName":"Chicken","id_product":"4","ProductName":"CHICKEN CHEESE BACON","Price":"55","QRCode":"","Path":"c55b.png"},{"id_productType":"1","TypeName":"Chicken","id_product":"5","ProductName":"CHICKEN CHEESE BACON EGG","Price":"65","QRCode":"","Path":"c65b.png"}]
         */

        private String id;
        private String name;
        private List<BurgurBean> burgur;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<BurgurBean> getBurgur() {
            return burgur;
        }

        public void setBurgur(List<BurgurBean> burgur) {
            this.burgur = burgur;
        }

        public static class BurgurBean {
            /**
             * id_productType : 1
             * TypeName : Chicken
             * id_product : 1
             * ProductName : CHICKEN
             * Price : 40
             * QRCode :
             * Path : c40b.png
             */

            private String id_productType;
            private String TypeName;
            private String id_product;
            private String ProductName;
            private String Price;
            private String QRCode;
            private String Path;

            public String getId_productType() {
                return id_productType;
            }

            public void setId_productType(String id_productType) {
                this.id_productType = id_productType;
            }

            public String getTypeName() {
                return TypeName;
            }

            public void setTypeName(String TypeName) {
                this.TypeName = TypeName;
            }

            public String getId_product() {
                return id_product;
            }

            public void setId_product(String id_product) {
                this.id_product = id_product;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public String getPrice() {
                return Price;
            }

            public void setPrice(String Price) {
                this.Price = Price;
            }

            public String getQRCode() {
                return QRCode;
            }

            public void setQRCode(String QRCode) {
                this.QRCode = QRCode;
            }

            public String getPath() {
                return Path;
            }

            public void setPath(String Path) {
                this.Path = Path;
            }
        }
    }
}
