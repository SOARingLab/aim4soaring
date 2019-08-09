target=target/AIM4-1.0-SNAPSHOT-jar-with-dependencies.jar

JAVA_OPTIONS= -ea -server -Xmx1000M

.PHONY: all, jar, run, clean

all: run

jar:
	mvn -Dmaven.test.skip=true assembly:assembly

run_target: $(target)
	java $(JAVA_OPTIONS) -jar $(target)

clean:
	mvn clean

run:
	mvn spring-boot:run

1:
	screen -S T-node-center -d -m mvn spring-boot:run -Dspring-boot.run.profiles=1-node-center
	screen -S T-node-right 	-d -m mvn spring-boot:run -Dspring-boot.run.profiles=1-node-right

T:
	screen -S T-node-center -d -m mvn spring-boot:run -Dspring-boot.run.profiles=T-node-center
	screen -S T-node-down 	-d -m mvn spring-boot:run -Dspring-boot.run.profiles=T-node-down
	screen -S T-node-right 	-d -m mvn spring-boot:run -Dspring-boot.run.profiles=T-node-right

kill:
	echo "begin..."
	screen -ls
	screen -ls | grep Detached | cut -d. -f1 | awk '{print $1}' | xargs kill
	screen -ls
	echo "done..."

