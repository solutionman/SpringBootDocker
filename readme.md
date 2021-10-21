
#SpringBootDocker

to build:

mvn -U clean install -DskipTests

to run:

sudo docker-compose up

to clean:

sudo docker ps -a

sudo docker rm "CONTAINER ID of springbootdocker_app"

sudo docker rm  "CONTAINER ID of postgres"

sudo docker images

sudo docker image rm "IMAGE ID of  springbootdocker_app"
