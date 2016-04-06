# APKManager

> Provides option to get the APK details which is published in Google Play Store.

### API Usage

##### To get the version of the APK published in Google Play Store:

```
// APPLICATION_ID: "com.domain.package"
// Returns String
APKManager.getPlayStoreVersion(BuildConfig.APPLICATION_ID);
```

##### To check if the version available in device and Google Play Store are same:
```
// APPLICATION_ID: "com.domain.package"
// APP_VERSION_NAME: "1.0.1"
// Returns boolean
APKManager.isUpdateAvailable(BuildConfig.APPLICATION_ID, BuildConfig.APP_VERSION_NAME); 
```

### Sample Usage

```
private void checkForUpdate() {
        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    String version = APKManager.getPlayStoreVersion(BuildConfig.APPLICATION_ID);
                    return APKManager.isUpdateAvailable(BuildConfig.APPLICATION_ID, BuildConfig.APP_VERSION_NAME);  
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean flag) {
                if (flag) {
                    Toast.makeText(getApplicationContext(), "Update Available", Toast.LENGTH_LONG).show();
                }
            }
        }.execute();
    }
```


### Contribution Guidelines

Contributions are always welcome! Please read below guideline before contributing.

Please ensure your pull request adheres to the following guidelines:

- Search previous suggestions before making a new one, as yours may be a duplicate.
- Make an individual pull request for each suggestion.
- Keep descriptions short and simple, but descriptive.

Thank you for your suggestions!
