# transactional
Repositorio para ilustrar diferentes abordagens sobre controle transacional

sudo docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql-local -d mysql

docker exec -it mysql-local mysql -uroot -proot

create database devcave_transactional;
