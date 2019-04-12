FROM java

EXPOSE 3333

COPY target/employee.jar /app/

WORKDIR /app/

CMD ["java", "-jar", "employee.jar"]