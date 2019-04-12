FROM java

EXPOSE 3333

COPY target/employeee-0.0.1-SNAPSHOT.jar /app/

WORKDIR /app/

CMD ["java", "-jar", "employeee-0.0.1-SNAPSHOT.jar"]