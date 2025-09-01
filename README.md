[![Java CI with Maven](https://github.com/nina-bornemann/PasswordValidator/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/nina-bornemann/PasswordValidator/actions/workflows/maven.yml)

## 💥 Description
This is a simple tool to check if a choosen password is valid, depending on the given criteria.
___
### 🔐 Password Criteria:
- min. 8 characters,
- min. one digit (0–9),
- Uppercase and lowercase letters
- not on the list of common/weak passwords

### ✨ Bonus Tasks:
- at least one special character
- Password Generator
- (Parameterized tests)
- Invalid Input message instead of boolean
- CLI tool to check your input password
---


## Usage


### Build
To build the PasswordValidator please use the following maven command.
> mvn -B clean verify

### Test

> mvn test


### Run

``` java
mvn package
java target/PasswordValidator-1.0-SNAPSHOT.jar
```
## Beispiel-Aufrufe

So kannst du die Klasse `PasswordValidator` verwenden:

```java
String pw = "mypassword";

boolean valid = PasswordValidator.hasMinimumLength(pw);

System.out.println(valid); // true, because "mypassword" >= 8 characters