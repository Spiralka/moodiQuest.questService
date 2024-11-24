FROM openjdk:22
WORKDIR /app
COPY build/libs/questService-0.0.1-SNAPSHOT.jar /app/questService.jar
ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080
CMD ["java", "-jar", "questService.jar"]