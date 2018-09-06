package com.rui.mvp.network.networkconfig;

import android.content.res.AssetManager;

import com.rui.mvp.nullability.Preconditions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Nullable;

import timber.log.Timber;

/**
 * Class that provides easy access to properties files found in the project.
 */
public class PropertiesManager {

    private static final String PROPERTIES_FILENAME = "project.properties";

    private final Properties properties;

    public boolean isDebug() {
        return isDebug;
    }

    private boolean isDebug;


    public PropertiesManager(AssetManager assetManager, boolean isDebug) {
        properties = new Properties();
        this.isDebug = isDebug;
        InputStream inputStream;
        try {
            inputStream = assetManager.open(PROPERTIES_FILENAME);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            Timber.e(e, "Failed to close input stream");
        }
    }

    public String getDribleClientAccessToken() {
        @Nullable String authToken = properties.getProperty(Property.DRIBBLE_CLIENT_ACCESS_TOKEN.getPropertyKey());
        Preconditions.checkNotNull(authToken);
        return authToken;
    }

    public String getBaseUrl() {
        @Nullable String baseUrl = isDebug ? properties.getProperty(Property.BASE_URL_DEV.getPropertyKey())
                : properties.getProperty(Property.BASE_URL.getPropertyKey());
        Preconditions.checkNotNull(baseUrl);
        return baseUrl;
    }

    private enum Property {

        DRIBBLE_CLIENT_ACCESS_TOKEN("dribbleClientAccessToken"),
        BASE_URL("dribbleBaseUrl"),
        BASE_URL_DEV("dribbleBaseUrlDev");

        private final String propertyKey;

        Property(String authToken) {
            this.propertyKey = authToken;
        }

        public String getPropertyKey() {
            return propertyKey;
        }
    }

}
