package com.spartajet.iotdemoserver.user;

import java.util.HashMap;

/**
 * The type Rest result.
 *
 * @description
 * @create 2018 -05-15 下午11:29
 * @email spartajet.guo @gmail.com
 */
public class RestResult {
    /**
     * The Code.
     */
    private int code;
    /**
     * The Data.
     */
    private HashMap<String,Object> data;

    /**
     * Instantiates a new Rest result.
     */
    public RestResult() {
        this.code=20000;
        this.data = new HashMap<>();
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public HashMap<String, Object> getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}
