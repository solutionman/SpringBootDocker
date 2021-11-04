
#SpringBootDocker

to build:
```bash
mvn -U clean install -DskipTests
```

to run:
```bash
sudo docker-compose up
```
app: http://localhost:8080/

api: http://localhost:8080/api/v1/heroes/1

users api: http://localhost:8080/api/users

user: User  
password: 12345678  
user: Admin  
password: 87654321

to clean:
```bash
sudo docker ps -a

sudo docker rm <CONTAINER ID of springbootdocker_app>

sudo docker rm  <CONTAINER ID of postgres>

sudo docker images

sudo docker image rm <IMAGE ID of  springbootdocker_app>
```
