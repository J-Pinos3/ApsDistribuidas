FROM openjdk:latest

WORKDIR /src

COPY . .

RUN javac *.java

EXPOSE 5500

CMD ["java", "ServidorRMI"]