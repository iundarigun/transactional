# transactional
Repositorio para ilustrar diferentes abordagens sobre controle transacional

sudo docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql-local -d mysql

docker exec -it mysql-local mysql -uroot -proot

create database devcave_transactional;

# Payload
```
[
  {
    "date": "2017-01-10",
    "type": "INTERNET",
    "value": 22.50
  },
  {
    "date": "2018-01-10",
    "type": "TV",
    "value": 90.50
  },
  {
    "date": "2018-06-10",
    "type": "INTERNET",
    "value": 42.50
  },
  {
    "date": "2018-01-10",
    "type": "ENERGY",
    "value": 12.50
  }
]
```
