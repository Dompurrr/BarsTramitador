# BarsTramitador
## Что это?
Программа для ожидания и уведомления об изменении оценок в системе БАРС.
## Настройки программы, конфиги
Для работы программы необходимо настроить / заполнить config-файл в котором должны быть прописаны следующие переменные:
> loginpage - прописано по-умолчанию, ссылка на страницу входа на сайте <br/>
> login - выш логин на сайте <br/>
> password - ваш пароль <br/>
> timeout - время перерыва между обновлениями страницы и проверки (время в секундах) <br/>
Все переменные заполняются в виде `переменная = значение`
## Как использовать?
Есть несколько способов, перечислены в порядке увеличения сложности:
### Способ 1 (через .cmd файл)
В репозитории есть уже собранный .cmd файл, который можно просто запустить двойным кликом.
1. Необходимо загрузить [архив](https://github.com/Dompurrr/BarsTramitador/raw/encoding_and_building/builds/alpha-0.1.rar), который находится в папке builds.
2. Распакуйте все файлы врхива в одну папку.
3. Запустите launcher.cmd
### Способ 2 (через .jar файл)
Загружаем тот же [архив](https://github.com/Dompurrr/BarsTramitador/raw/encoding_and_building/builds/alpha-0.1.rar) и распаковываем его.
и выполняем команду через cmd или PowerShell: <br/>
`java -jar BarsTramitador-0.1-alpha-jar-with-dependencies.jar`
### Способ 3 (через ручную сборку maven)
1. Загружаем весь репозиторий
2. В корневой папке, где находится файл "pom.xml", выполняем `mvn package`. (Необходим установленный maven и прописаны переменные среды в системе)
3. В конечном итоге в папке target будет собарн файл проекта с названием "BarsTramitador-0.1-alpha-jar-with-dependencies.jar", который уже можно запускать / использовать далее как душе угодно
# Отказ об ответственности
### Вы используете программу на свой страх и риск. Автор не несет ответственности за возможные последствия использования программы.
При использовании программы, вы обязаны понимать как она работает, не имеете никаких притензий, не собираетесь использовать программу с злым умыслом. <br/>
Автор не несет ответственности за возможные последствия использования программы, будь то блокировка доступа к аккаунту, раскрытие личных данных и иное <br/>
Если вы считаете что программа или какая-то из её функций нарушает правила использования сайта или системы, сообщите об этом на <maksdompur@mail.ru>
