target=target/AIM4-1.0-SNAPSHOT-jar-with-dependencies.jar

JAVA_OPTIONS=-ea -server -Xmx1000m
MVN_OPTIONS="jvm.options=-Xmx1024 -Xms512"
SCREEN_OPTION=-L -dm

timestamp=`date +%Y-%m-%d-%T`
LL = L-node-center L-node-down L-node-left
TT = L-node-center T-node-down T-node-left T-node-right
XX = X-node-center X-node-down X-node-left X-node-right X-node-up

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
	$(foreach node, ${LL}, screen -t ${timestamp}.${node} ${SCREEN_OPTION} mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=${node}; echo ${node};)

T:
	$(foreach node, ${TT}, screen -t ${timestamp}.${node} ${SCREEN_OPTION} mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=${node}; echo ${node};)

X:
	$(foreach node, ${XX}, screen -t ${timestamp}.${node} ${SCREEN_OPTION} mvn spring-boot:run -D$(MVN_OPTIONS) -Dspring-boot.run.profiles=${node}; echo ${node};)

kill:
	echo "begin..."
	screen -ls
	screen -ls | grep Detached | cut -d. -f1 | awk '{print $1}' | xargs kill
	echo "done..."
