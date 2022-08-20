# Запуск автоматических тестов
1. Склонировать проект **https://github.com/frantzev/diploma.git**
2. Перейти в папку _diploma/artifacts_
3. Выполнить команду `docker-compose up -d`
4. Выполнить команду `java -jar aqa-shop.jar`
5. В новом окне терминала запустить `java -jar -Dspring.profiles.active=postgres aqa-shop.jar`
6. В новом окне терминала перейти в папку _diploma/artifacts/gate-simulator_
7. Выполнить команду `npm start`
8. В новом окне терминала перейти в папку _diploma_
9. Выполнить команду `./gradlew clear test`
10. Выполнить команду после завершения шага 9 `./gradlew allureReport`
