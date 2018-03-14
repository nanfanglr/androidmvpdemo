package com.mvp.rui.androidmvpdemo.common.network.basemodel;

import java.io.Serializable;

/**
 * Created by linet on 16/1/25.
 */
public class BaseModel implements Serializable {

    public boolean loadedImage;


    public int getInt(Long value) {
        if (value == null) return 0;
        return value.intValue();
    }

    public float getFloat(Double value) {
        if (value == null) return 0;
        return value.floatValue();
    }

    public String getString(String value) {
        if (value == null)
            value = "";
        return value;
    }


}
