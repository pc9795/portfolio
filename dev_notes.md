```
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
```
These 4 are used on entities instead of `@Value` to work with JPA.

#

Make sure that your main class is in a root package above other classes.

When you run a Spring Boot Application, (i.e. a class annotated with `@SpringBootApplication`), Spring will only scan 
the classes below your main class package.

#

### Configure Postgres to Allow Remote Connections

* Open `var/lib/postgresql/data/pg_hba.conf` and Add
```cmd
host all all 0.0.0.0/0 md5
host all all ::/0 md5
```

* Open `var/lib/postgresql/data/postgresql.conf` and Update
```cmd
listen_addresses = '*'
```

#

if proxy_pass used without URI (i.e. without path after server:port) nginx will put URI from original request exactly as 
it was with all double slashes, ../ and so on.