FROM tomcat
MAINTAINER "Satyam"
# It is just kind of documentation which tell image user that application internally runs on port 8080. It does not mean that it publishes the port
EXPOSE 8080  
# delete all application inside webapp of tomcat 
RUN rm -rf /usr/local/tomcat/webapps/webTest.war
COPY ./target/webTest.war    /usr/local/tomcat/webapps/ROOT.war 
CMD ["catalina.sh", "run"]