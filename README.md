# rooms_services
Kotlin, Ktor, Exposed, MySQL

* włączamy IntelliJ
* wybieramy import project -> folder room_services -> import project from external mode -> gradle
* czekamy aż wszystko sobie zaciągnie
* ściągamy i instalujemy https://dev.mysql.com/downloads/mysql/
* ściągamy i instalujemy https://dev.mysql.com/downloads/workbench/
* włączamy instancje bazy danych
* w workbench tworzymy bazę danych:
  hostname: localhost
  port: 3306
  username: root
  password: Database223344
* włączamy projekt w IntelliJ -> przechodzimy do pliku Runner.kt -> odkomentować `createDataSet()` -> run
* jak się projekt odpali to w workbenchu w naszej stworzonej wcześniej instancji bazy danych powinien się pokazać nowy schemat bazy o nazwie `room_services_db` z wszystkimi tabelkami i danymi 
* przy ponownym uruchomieniu projektu radzę odkomentować `createDataSet()` bo za każdym razem będzie czyścić wszystkie tabelki i wstawiać defaultowe dane
