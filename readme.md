
#SpringBootDocker


mvn clean install

sudo docker build -t demo .

to run:<br>
sudo docker run -p 8080:8080 -t demo

http://localhost:8080/

or: <br>
sudo docker images<br>
sudo docker run -p 8080:8080 -t "IMAGE ID"

http://localhost:8080/

to remove container:<br>
sudo docker rm "CONTAINER ID"

to remove image:<br>
sudo docker image rm "IMAGE ID"

to run both app and postgresql:<br>
sudo docker-compose up

to stop:<br>
Ctrl + c
or
sudo docker-compose down
