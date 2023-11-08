# RegistryDataMysql

Веб приложение написанное с использованием Spring framework.
<br>
<br>
Описание: 
Реестр без данных и владельцев с возможностью указания характеристик таких как тип, размер, дата создания. Слой хранения данных реализован на базе MySQL. 
<br>
<br>
Используемые зависимости:
- Spring Web
- Spring data JPA
- Шаблонизатор Thymeleaf
- Lombok

<br>
<br>

Для запуска ПО требуется :
- Создать на сервере MySQL базу
- В application.properties задать адрес и учетные данные от БД MySQL.
- Выполнить скрипт src/main/resources/database/initDataBase.sql для созданиия таблиц
- Перейти в браузере по localhost:8080

<br>
<br>

В веб интерфейсе приложения реализовано :
<br>
- Создание записи о базе
- Редактирование записи о базе
- Удаление записи о базе
- Поиск баз по владельцу
<br>
<br>
В программном интерфейсе реализован REST контроллер для возможности управления данными в базе. Используются методы GET и POST.
<br>
<br>

- Получение информации о всех записях в таблице
<br>
GET localhost:8080/api/v1/brs/base/

Возвращает JSON соедующего вида:

<pre>
<code>
   {
        "id": 3,
        "baseName": "base03",
        "baseOwner": "user2",
        "createdDate": "2023-02-04",
        "type": "Mysql",
        "size": 42283
    }
    </code>
</pre>
<br>


- Получение информации по запрашиваемой базе
<br>
GET localhost:8080/api/v1/brs/base/<b>basexxx</b>

Возвращает JSON соедующего вида:

<pre>
<code>
   {
        "id": 15,
        "baseName": "basexxx",
        "baseOwner": "user",
        "createdDate": "2022-02-04",
        "type": "PostgreSQL",
        "size": 235231
    }
    </code>
</pre>
<br>


- Получение информации о базах по владельцу
<br>
GET localhost:8080/api/v1/brs/owner/<b>admin</b>

Возвращает JSON соедующего вида:

<pre>
<code>
  [
    {
        "id": 8,
        "baseName": "base01",
        "baseOwner": "admin",
        "createdDate": "2001-04-21",
        "type": "mysql",
        "size": 824723
    },
    {
        "id": 9,
        "baseName": "base21",
        "baseOwner": "admin",
        "createdDate": "2019-12-21",
        "type": "postgre",
        "size": 2352352
    }
]
    </code>
</pre>
<br>


- Добавление записи в базу
<br>
POST localhost:8080/api/v1/brs/base/add/

При отправке запроса в теле передаем

<pre>
<code>
      {
        "baseName": "base0322",
        "baseOwner": "user222",
        "createdDate": "2023-02-04",
        "type": "Mysql",
        "size": 42283
    }
    </code>
</pre>





  


