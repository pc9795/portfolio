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