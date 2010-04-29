Several things were done here.

Because maven is awesome, I only really needed the pom.xml file from a working project. 

In this case, I have created this project with the pom.xml from this maven-gae-plugin example:

http://maven-gae-plugin.googlecode.com/svn/example/jsp-persistence-app/pom.xml

To run the local development server, just do :

$ mvn gae:run

However, there were a few problems to overcome. 

1. The Checksum Failed on some of the dependencies:
This is apparently a known issue with maven. 

2. Run gae:unpack
This will extract the appropriate Google App Engine files into your local maven repository. Which helps. 

