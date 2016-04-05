package com.gokul.apkmanager;

import org.jsoup.Jsoup;

/**
 * <b>The core public access point to the APKManager library.</b>
 * <br/><br/>
 * Features:<br/>
 *  - gets the play store version name, if the app is published in Google Play Store. <br/>
 *  - checks if newer version is published in Google Play Store. <br/>
 *
 * @author Gokul Nath KP
 **/
public abstract class APKManager {

    /**
     * Gets the app version name of the APK published in Google Play Store.
     *
     * @param appID
     * @return Returns the app version name of the APK published in Google Play Store.
     * @throws Exception
     */
    public static String getPlayStoreVersion(final String appID) throws Exception {
        if (validateInput(appID)) {
            return getAppVersionString(appID);
        }
        return null;
    }

    /**
     * Check if updated version of the app is available in Play Store.
     *
     * @param appID
     * @param currentVersion
     * @return Returns true, if update is available in Google Play Store.
     * @throws Exception
     */
    public static boolean isUpdateAvailable(final String appID, final String currentVersion) throws Exception {
        return validateInput(appID, currentVersion) && !isVersionsSame(currentVersion, getAppVersionString(appID));
    }

    /**
     * Gets the APK version name from Google Play Store.
     *
     * @param appID
     * @return String
     * @throws Exception
     */
    private static String getAppVersionString(final String appID) throws Exception {
        return Jsoup.connect(ApplicationConstants.PLAY_STORE_URL + appID)
                .timeout(ApplicationConstants.TIMEOUT)
                .userAgent(ApplicationConstants.USER_AGENT)
                .referrer(ApplicationConstants.REFERRER)
                .get()
                .select(ApplicationConstants.VERSION_STRING)
                .first()
                .ownText();
    }

    /**
     * Returns true if installed version and Google Play Store version are same.
     *
     * @param installedVersionString
     * @param playStoreVersionString
     * @return boolean
     */
    private static boolean isVersionsSame(final String installedVersionString, final String playStoreVersionString) {
        return installedVersionString.equals(playStoreVersionString);
    }

    /**
     * Validates the input before processing.
     *
     * @param values
     * @return boolean
     */
    private static boolean validateInput(String... values) {
        for (String string : values) {
            if (string == null || string.length() <= 0) {
                return false;
            }
        }
        return true;
    }
}