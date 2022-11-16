### Дипломный проект профессии "Тестировщик"

Программа предназначена для автоматизированного тестирования сервиса по покупке тура с помощью дебетовой карты и с получением кредита
по данным дебетовой карты. 

### Документация по проекту 
  * [План по автоматизации тестирования](https://github.com/frantzev/diploma/blob/master/docs/plan.md)
  * [Отчет по итогам автоматизированного тестирования](https://github.com/frantzev/diploma/blob/master/docs/report.md)
  * [Отчет по итогам автоматизации](https://github.com/frantzev/diploma/blob/master/docs/summary.md). 

     
### Необходимое окружение: 
 * установленный  Docker; 
 * убедитесь, что  порты  8080, 9999 и 5432 или 3306 (в зависимости от выбранной базы данных) свободны; 

### Инструкции по установке 
1. Скачайте архив;
1. Запустите контейнер, в котором разворачивается база данных (далее БД) `docker-compose up -d --force-recreate`
1. Убедитесь в том, что БД готова к работе (логи смотреть через `docker-compose logs -f <applicationName>` (mysql или postgres)  
1. Запустите приложение командой :
    * для использования Postgres: `java -Dspring/datasourc/url=jdbc:postgresql://localhost:5432/postgres -jar artifacts/aqa-shop.jar` 
    * для использования MySQL: `java -Dspring/datasource/url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar` 
     
   Приложение запускается на порту 8080; 
  
1. Запустите тесты командой: 
    * при работе с postgres: `./gradlew test -Ddb.url=jdbc:postgresql://localhost:5432/postgres  -Dlogin=app -Dpassword=pass -Dapp.url=http://localhost:8080` 
    * при работе с mySql: `./gradlew test -Ddb.url=jdbc:mysql://localhost:3306/app  -Dlogin=app -Dpassword=pass -Dapp.url=http://localhost:8080` 
    ( app_url = http://localhost:8080 по умолчанию ).
  
