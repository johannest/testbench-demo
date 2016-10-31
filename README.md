TestBench and scalability testing demo project
==============

Vaadin Bookstore example appilication modified for scalability testing and for demoing Vaadin TestBecnh with Page Object Pattern.

Project Structure
=================

The project consists of the following three modules:

- parent project: common metadata and configuration
- webinar-widgetset: widgetset, custom client side code and dependencies to widget add-ons
- webinar-ui: main application module, development time
- webinar-production: module that produces a production mode WAR for deployment

Example Gatling test script is located src/test/scala/loadtests. Request bodies and test data is in src/test/resources folder.

Example of TestBench with Page Object pattern is located is src/test/java/org.vaadin.test.webinar package.

Workflow
========

To compile the entire project, run "mvn install" in the parent project. Use "-DskipTests" to skip TestBench and Gatlig tests".
To run only Gatling tests, run "mvn gatling:execute" 

Other basic workflow steps:

- getting started
- compiling the whole project
  - run "mvn install" in parent project
- developing the application
  - edit code in the ui module
  - run "mvn jetty:run" in ui module
  - open http://localhost:8080/

