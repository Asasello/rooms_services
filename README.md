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
# Tworzenie bazy w MySQL
## Workbench
1. włączamy workbencha
2. z *MySQL Connections* wybieramy *Local Instance 3306*
3. w *schemas* (pasek po lewej stronie) klikamy PPM i wybieramy *Create schema...*
4. w *Schema Name* wpisujemy `room_services_db`
5. klikamy *apply*
6. w *schemas* powinien pokazać się element o nazwie `room_services_db`
## IntelliJ
1. włączamy projekt w IntelliJ
2. przechodzimy do pliku Runner.kt
3. odkomentować `createDataSet()`
4. uruchamiamy projekt - run
## Weryfikacja
* W **Workbench** powinien, w zakładce *schemas* klikamy PPM na `room_services_db` i wybieramy *Refresh all*. Teraz po rozwinięciu zakładki `room_services_db` -> `Tables` należy sprawdzić czy zostałī utworzone tabele *Facilities*, *FacilitiesReservations*, *Rooms*

*Przy ponownym uruchomieniu projektu radzę odkomentować `createDataSet()` bo za każdym razem będzie czyścić wszystkie tabelki i wstawiać defaultowe dane


# Testy JMeter
1. ściągamy https://jmeter.apache.org/download_jmeter.cgi
2. do katalogu `lib` wrzucamy `mysql-connector-java-5.1.46.jar` (pozwala połączyć się z mySQL)
3. w folderze `bin` włączamy `jmeter`
4. importujemy projekt `Test Room Service.jmx`