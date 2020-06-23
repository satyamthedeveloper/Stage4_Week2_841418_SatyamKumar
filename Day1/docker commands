1. docker network ls

2. docker network create book-nw

3. docker container run --name mysqldb -p 3300:3300 --network book-nw -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=user_database -d mysql:8.0.18

4. docker container ls

5. docker logs bd

6. docker exec -it bd bash

7. mysql -u root -p

8. use user_database

9. create table book (id int, title varchar(30), author varchar(30), price float);

10. insert into book values(1, 'JavaScript', 'Nick', 220.56);

11. exit

12. exit

13. docker image build -t discovery-book-service .

14. docker image build -t zuul-service-book .

15. docker image build -t book-service .

16. docker images

17. docker container run --name book-discovery -p 8000:8000 --network book-nw -d discovery-book-service

18. docker container run --name zuul-bridge -p 8002:8002 --network book-nw -d zuul-service-book

19. docker container run --name book-service -p 8001:8001 --network book-nw -d book-service

20. docker container ls