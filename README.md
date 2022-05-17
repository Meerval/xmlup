# xmlup
Upload data to database from  (> 1.5 GB) .xml file


## how to test

To upload test data ([src/main/resources/test.xml](https://github.com/Meerval/xmlup/blob/master/src/main/resources/test.xml)) to your database you have to:
1. add .properties file with connection data of your database to path [src/main/java/com/xmlup/db/connection](https://github.com/Meerval/xmlup/tree/master/src/main/java/com/xmlup/db/connection) 
(use file [MySQL.properties](https://github.com/Meerval/xmlup/tree/master/src/main/java/com/xmlup/db/connection/MySQL.properties) 
or [postgresSQL.properties](https://github.com/Meerval/xmlup/blob/master/src/main/java/com/xmlup/db/connection/PostgresSQL.properties) as example)
2. start [src/main/java/com/xmlup/Main.java](https://github.com/Meerval/xmlup/blob/master/src/main/java/com/xmlup/Main.java) using your  _.properties_ file in row 15

## how to upload own data
You have to create your own classes with a specific behavior, which will help you parce your data:
1. add _.properties_ file with connection data of your database to path [src/main/java/com/xmlup/db/connection](https://github.com/Meerval/xmlup/tree/master/src/main/java/com/xmlup/db/connection) 
(use file [MySQL.properties](https://github.com/Meerval/xmlup/tree/master/src/main/java/com/xmlup/db/connection/MySQL.properties) 
2. create new class which contains data of object (use file [src/main/java/com/xmlup/xml/model/frog/Frog.java](https://github.com/Meerval/xmlup/blob/master/src/main/java/com/xmlup/xml/model/frog/Frog.java) as example)
3. create new handler class which helps parce your data (use file [src/main/java/com/xmlup/xml/parser/FrogHandler.java](https://github.com/Meerval/xmlup/blob/master/src/main/java/com/xmlup/xml/parser/FrogHandler.java) as example)
4.  start [src/main/java/com/xmlup/Main.java](https://github.com/Meerval/xmlup/blob/master/src/main/java/com/xmlup/Main.java) using your own data:
    - your own Handler instead of FrogHandler (row 12)
    - path to .xml file instead of "src/main/resources/test.xml" (row 13)
    - name of your .properties file instead of "MySQL.properties" (row 15)
