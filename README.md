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

# Docker

## Uruchamianie zdokerowanego projektu
docker pull roomservice/room_service:default_data
docker pull roomservice/room_service:no_data
docker pull roomservice/mysql_room_service
docker run --name mysql-room-service -p 3306:3306 -d roomservice/mysql_room_service
docker run -it -p 8095:8095 --name room_service --link mysql-room-service:msql -d roomservice/room_service:default_data
docker logs room_service (sprawdzić czy wypełnił danymi bazę; dodatkowo dla testu można http://localhost:8095/get-all-rooms)
docker rm -f room_service
docker run -it -p 8095:8095 --name room_service --link mysql-room-service:msql -d roomservice/room_service:no_data
(sprawdzić http://localhost:8095/get-all-rooms)

## Tworzenie obrazu serwisu
cd room_service
./gradlew build
docker build -t room_service .
docker images (powinien być room_service z tagiem latest)

## Tworzenie obrazu bazy danych mySQL
cd room_service/db
docker build -t mysql-room-service .
docker images (powinien być mysql-room-service z tagiem latest)

## Inne przydatne
docker images -a (pokazuje wszystkie obrazy)
docker container ls -a (pokazuje wszystkie kontenery)
docker rm -f id/name (usuwa kontener o podanym id/name; -f-force - usunie nawet jeśli jest włączony)
docker rmi -f id/name (usuwa obraz o podanym id/name; -f-force - usunie nawet jeśli jest włączony)
docker logs name/id (pokazuje logi z kontenera)
