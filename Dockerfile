FROM adoptopenjdk/openjdk8:latest
COPY target/VechileTracking.jar VechileTracking.jar
CMD ["java", "-jar", "VechileTracking.jar"]
EXPOSE 8080
