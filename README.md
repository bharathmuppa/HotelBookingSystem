# HotelBookingSystem
A simple project for Hotel Booking which is based on java for providing RestAPI and Angular 1.0 for frontend to consume data.

#Installations Required

1. MySql
2. MySQL Query browser
2. apache tomcat
3. Eclipse (preferably Mars)
4. Sublime or any platform you like

Then clone or download the project.

## DataBase Settings

you can use the existing dump file(outfile.sql)

```
$ mysqldump yourFirstDatabase -u user -ppassword > yourDatabase.sql(this is our outfile.sql)
$ mysql yourSecondDatabase -u user -ppassword < yourDatabase.sql(you need to dump like this)

``` 
open querybrowser 
navigate to our schema/DB
Add some values in customer table so that you can use in webapplication

## RestAPI

you can open Eclipse and import DataRestAPI from clonned or downlaoded content
Run the imported project on tomcat server.(if you want to change the port you can change)

##Web application

open index.html from any server or you need to work on cross-origin issues.
enter credentials(which you have added in before step)

BINGO...

