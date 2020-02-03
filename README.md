# hibernate_oto
One to one relationship in hibernate using XML config

## Build status
[![Build Status](https://img.shields.io/badge/build-passing-success)]()

## Tech/framework used
- Hibernate 5.4.5 Final

**Built with**
- Eclipse J2EE

## How to run?
- Add _required_ [hibernate .jar files](https://sourceforge.net/projects/hibernate/) into project's build path
- Add [mysql-connector-java-*.jar](https://dev.mysql.com/downloads/connector/j/) into `WebContent/lib/`
- Create database _hibernate_oto_ (name is optional):
  - Create table _address_:
  ```sql
  CREATE TABLE address(
    id INT PRIMARY KEY AUTO_INCREMENT,
    city VARCHAR(255) NOT NULL,
    zipcode INT NOT NULL
  );
  ```
  - Create table _user_:
  ```sql
  CREATE TABLE user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address INT NOT NULL,
    FOREIGN KEY(address) REFERENCES address(id)
  );
  ```
- Follow code structure in `src/`

## License
The MIT License

Copyright (c) [Phạm Trung Kiên]()

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
