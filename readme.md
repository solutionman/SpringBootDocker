
#SpringBootDocker


mvn clean install

sudo docker build -t demo .

sudo docker run -p 8080:8080 -t demo

http://localhost:8080/

