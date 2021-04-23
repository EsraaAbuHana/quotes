# quotes
This is an application that will get a random quote from the [ron-swanson](http://ron-swanson-quotes.herokuapp.com/v2/quotes)quotes API saves it to the json file in the assets folder, and prints it to the console.

If it cannot establish a connection to the API for whatever reason, it reads in and parses the json file and prints out a random quote from there.


## Running and Testing
- To run the app use `./gradlew run` in the terminal.
-  To test  this app, run `./gradlew test` in the terminal .

## Dependencies
Add Gson to build.gradle file:
- resources :
   recentquotes.json
- dependencies :
 { implementation 'com.google.code.gson:gson:2.8.5' }
