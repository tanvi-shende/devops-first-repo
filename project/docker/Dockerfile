FROM tomcat:11.0-jdk21-temurin
COPY project/app/target/webapp.war /usr/local/tomcat/webapps/webapp.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
