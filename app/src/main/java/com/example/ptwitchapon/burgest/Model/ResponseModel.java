package com.example.ptwitchapon.burgest.Model;

/**
 * Created by Killy77 on 20/7/2561.
 */

public class ResponseModel {

    /**
     * status : success
     * code : 200
     * describtion : status updated
     */

    private String status;
    private String code;
    private String describtion;

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
}
