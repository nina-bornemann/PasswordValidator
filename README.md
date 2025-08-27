

## Description
This is a simple tool to check if a choosen password is valid, depending on the given criteria.
___
### Password Criteria:
- min. 8 characters,
- min. one digit (0–9),
- Uppercase and lowercase letters
- not on the list of common/weak passwords
- at least one special character
- maximum of 3 special characters
---


## Usage


### Build
To build the PasswordValidator please use the following maven command.
> mvn compile

### Test

> mvn test


### Run

``` java
mvn package
java target/PasswordValidator-1.0-SNAPSHOT.jar
```