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

#

```
select * from pg_stat_activity where pid in (select pid from pg_locks);
```
Use of `HttpCookieOAuth2AuthorizationRequestRepository`:
The OAuth2 protocol recommends using a `state` parameter to prevent CSRF attacks. During authentication, the application 
sends this parameter in the authorization request, and the OAuth2 provider returns this parameter unchanged in the 
OAuth2 callback. The application compares the value of the `state` parameter returned from the OAuth2 provider with the 
value that it had sent initially. If they don’t match then it denies the authentication request. To achieve this flow, 
the application needs to store the `state` parameter somewhere so that it can later compare it with the `state` returned 
from the OAuth2 provider. We’ll be storing the state as well as the `redirect_uri` in a short-lived cookie.

#

Right now not able to test Google OAuth flow locally with docker because Google doesn't accepts IP addresses for redirect
URLs

# 

If `BindException` is thrown instead of `MethodArgumentNotValidException` then maybe you forget to add `@RequestBody` to
method argument as it is now handled as a form parameter.