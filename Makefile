target=target/AIM4-1.0-SNAPSHOT-jar-with-dependencies.jar

JAVA_OPTIONS= -ea -server -Xmx1000m
MVN_OPTIONS="jvm.options=-Xmx1024 -Xms512"

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

L:
	screen -S L-node-center -d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=L-node-center
	screen -S L-node-down 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=L-node-down
	screen -S L-node-left 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=L-node-left

T:
	screen -S T-node-center -d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=T-node-center
	screen -S T-node-down 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=T-node-down
	screen -S T-node-left 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=T-node-left
	screen -S T-node-right 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=T-node-right


X:
	screen -S X-node-center -d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=X-node-center
	screen -S X-node-up 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=X-node-up
	screen -S X-node-down 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=X-node-down
	screen -S X-node-left 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=X-node-left
	screen -S X-node-right 	-d -m mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=X-node-right

kill:
	echo "begin..."
	screen -ls
	screen -ls | grep Detached | cut -d. -f1 | awk '{print $1}' | xargs kill
	screen -ls
	echo "done..."

