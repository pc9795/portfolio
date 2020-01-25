FROM openjdk:8
RUN mkdir -p service/
COPY target/ service/
CMD ["/usr/local/openjdk-8/bin/java", "-jar", "/service/portfolio-1.0.jar"]