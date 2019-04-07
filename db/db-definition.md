## SQL
#### 1. Relations Definition

借阅者表
```
CREATE TABLE borrower(
id varchar(4) PRIMARY KEY,
name varchar(12),
PASSWORD varchar(25),
type varchar(8),
degree varchar(6)
);
```
图书管理员表
```
CREATE TABLE operator(
id varchar(4) PRIMARY KEY,
name varchar(12),
PASSWORD varchar(25)
);
```

系统管理员
```
CREATE TABLE admin(
id varchar(4) PRIMARY KEY,
name varchar(12),
PASSWORD varchar(25)
);
```

书目
```
CREATE TABLE book(
id varchar(6) PRIMARY KEY,
name varchar(20),
ISBN varchar(25),
type varchar(10),
description varchar(150)
);
```

借书记录
```
CREATE TABLE borrowRecord(
recodeID varchar(6) NOT NULL PRIMARY KEY,
borrowerID varchar(4) REFERENCES borrower(id),
bookID varchar(6) REFERENCES book(id),
borrowTime TIMESTAMP,
dueTime TIMESTAMP
);
```

#### 2. Load sample data from .txt file
admin
```
Load data local in file “BMS529/db/admin.txt” into table admin
Fields terminated by “,”
lines terminated by “\r\n”  
```
operator
```
Load data local in file “BMS529/db/operator.txt” into table operator
Fields terminated by “,”
lines terminated by “\r\n
```
borrower
```
Load data local in file “BMS529/db/borrower.txt” into table borrower
Fields terminated by “,”
lines terminated by “\r\n
```
borrower
```
Load data local in file “BMS529/db/borrower.txt” into table borrowRecord
Fields terminated by “,”
lines terminated by “\r\n
```
book
```
Load data local in file “BMS529/db/book.txt” into table book
Fields terminated by “,”
lines terminated by “\r\n
```