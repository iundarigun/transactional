# transactional
Repositorio para ilustrar diferentes abordagens sobre controle transacional

docker run --name local-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres

docker exec -it local-postgres psql -U postgres

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
