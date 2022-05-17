# xmlup
Upload data to database from .xml


## how to test
To upload test data ([src/main/resources/test.xml](https://github.com/Meerval/xmlup/blob/master/src/main/resources/test.xml)) to your database you have to:
1. add _.properties_ file with connection data of your database to path [src/main/java/com/xmlup/db/connection](https://github.com/Meerval/xmlup/tree/master/src/main/java/com/xmlup/db/connection) 
(use file [MySQL.properties](https://github.com/Meerval/xmlup/tree/master/src/main/java/com/xmlup/db/connection/MySQL.properties) 
or [postgresSQL.properties](https://github.com/Meerval/xmlup/blob/master/src/main/java/com/xmlup/db/connection/PostgresSQL.properties) as example)
2. start [src/main/java/com/xmlup/Main.java](https://github.com/Meerval/xmlup/blob/master/src/main/java/com/xmlup/Main.java) using your  _.properties_ file in row 15
