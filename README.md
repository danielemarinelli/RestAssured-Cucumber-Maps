From the project folder run: mvn test verify   
To run only tests with tags -->  mvn test verify -Dcucumber.options="--tags @AddPlace"

Reports will be stored under /target/cucumber-html-reports
