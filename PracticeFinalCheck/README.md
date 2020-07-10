##____ DOCKER COMMANDS ____##

Step 1:
open cmd in root directory.
Check docker network's list
> docker network ls

Step 2:
build images of your Dockerfile
> docker-compose build

step 3:
Check weather images has been added into image list
> docker images

Note: You can also check that it has not started the container yet.

step 4:
execute your docker-compose images
> docker-compose up

Note: This process will take few minutes and few containers may fail to start due to dependency on previous containers. Depends-on take care that it has started in order but still not every microservice which is up is ready to deliver its services. 

step 5:
Check all containers list.
> docker container ls -a


step 6: (Optional)
Check your mysql container is initialised with your database or not.

    > docker exec -it %mysqldb_id% bash
    Note: replace %mysqldb_id% with id for your mysql container.

    Enter username and password.
    > mysql -u root -p

    > show databases;

    Note: You can check your tables and data also if initialised.

    Exit user
    > exit

    Exit mysql
    > exit

step 7: 
If any of your container has not started, start it again.

> docker container start %container_id%

step 8: (Optional)
To check the logs of your container. Use this command

> docker logs %container_id%


NOTE: menu_item and movie_list contains sample data in json format.