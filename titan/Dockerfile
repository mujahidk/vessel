FROM tomcat:8.5.32-jre8-alpine

MAINTAINER Mujahid Khaleel <mail@mujahidk.com>

ENV JAVA_OPTS="-Duser.timezone=UTC"

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/titan-develop-SNAPSHOT.war /usr/local/tomcat/webapps/titan.war

