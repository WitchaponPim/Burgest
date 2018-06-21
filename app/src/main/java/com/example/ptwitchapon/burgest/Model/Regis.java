package com.example.ptwitchapon.burgest.Model;

/**
 * Created by Killy77 on 15/4/2561.
 */

public class Regis {

    /**
     * checklogin : {"status":"success","code":"800","description":"your registeration is successfuly"}
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
         * description : your registeration is successfuly
         */

        private String status;
        private String code;
        private String description;

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
    }
}
