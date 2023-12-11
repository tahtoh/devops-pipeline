FROM maven:3.9.5-eclipse-temurin-17 as BUILD
WORKDIR /app
COPY . .
RUN mvn clean install


FROM eclipse-temurin:17.0.9_9-jdk
WORKDIR /app
COPY --from=BUILD /app/target/devops*.jar /apps/
EXPOSE 8080
CMD java -jar /apps/devops*.jar