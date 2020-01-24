FROM logstash:6.8.6
COPY logstash.conf /usr/share/logstash/logstash.conf
COPY postgresql-42.2.4.jar /usr/share/logstash/postgresql-42.2.4.jar
ADD log4j2.properties config/

ENTRYPOINT ["logstash","-f","/usr/share/logstash/logstash.conf"]
