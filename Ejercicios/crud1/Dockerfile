FROM openjdk:17

EXPOSE 8081

COPY /target/*.jar /usr/local/libspring.jar

ENTRYPOINT ["java","-jar","/usr/local/libspring.jar"]