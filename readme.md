
#SpringBootDocker


mvn clean install

sudo docker build -t demo .

to run:
sudo docker run -p 8080:8080 -t demo

http://localhost:8080/

or sudo docker images
sudo docker run -p 8080:8080 -t <IMAGE ID>

http://localhost:8080/

to remove container:
sudo docker rm <CONTAINER ID>

to remove image:
sudo docker image rm <IMAGE ID>


