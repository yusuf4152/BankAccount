FROM openjdk:11
WORKDIR /app
ADD target/BankAccount-0.0.1-SNAPSHOT.jar appp.jar
ENTRYPOINT ["java","-jar","appp.jar"]