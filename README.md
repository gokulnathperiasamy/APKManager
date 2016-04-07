# APKManager

> Provides option to get the APK details which is published in Google Play Store.

### API Documentation

###### Gradle Plugin

Library is available in jcenter repository. Add below line in your ```build.gradle``` file:

```
compile 'com.gokul.apkmanager:apkmanager:1.0'
```

###### Direct Usage

Make sure you import this Android library project into your IDE and set this library as a dependency.

##### To get the version of the APK published in Google Play Store:

```
// APPLICATION_ID: "com.domain.package"
// Returns String
APKManager.getPlayStoreVersion(BuildConfig.APPLICATION_ID);
```

##### To check if Google Play Store has updated version:
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
                    String version = APKManager.getPlayStoreVersion(BuildConfig.APPLICATION_ID);   // Returns the version available in Google Play Store.
                    return APKManager.isUpdateAvailable(BuildConfig.APPLICATION_ID, BuildConfig.APP_VERSION_NAME);  
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean flag) {
                if (flag) {
                    // Your logic if update is available ...
                    Toast.makeText(getApplicationContext(), "Update Available", Toast.LENGTH_LONG).show();
                }
            }
        }.execute();
    }
```

### Author

- Gokul Nath KP

### Contribution Guidelines

Contributions are always welcome! Please read below guideline before contributing.

Please ensure your pull request adheres to the following guidelines:

- Search previous suggestions before making a new one, as yours may be a duplicate.
- Make an individual pull request for each suggestion.
- Keep descriptions short and simple, but descriptive.

Thank you for your suggestions!

### License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
