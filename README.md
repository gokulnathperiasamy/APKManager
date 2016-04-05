# APKManager

> Provides option to get the APK details which is published in Google Play Store.

## Usage

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


## Contribution Guidelines

Contributions are always welcome! Please read below guideline before contributing.

Please ensure your pull request adheres to the following guidelines:

- Search previous suggestions before making a new one, as yours may be a duplicate.
- Suggested READMEs should be beautiful or stand out in some way.
- Make an individual pull request for each suggestion.
- New categories, or improvements to the existing categorization are welcome.
- Keep descriptions short and simple, but descriptive.
- Start the description with a capital and end with a full stop/period.
- Check your spelling and grammar.
- Make sure your text editor is set to remove trailing whitespace.

Thank you for your suggestions!
