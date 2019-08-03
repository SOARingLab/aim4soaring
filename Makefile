target=target/AIM4-1.0-SNAPSHOT-jar-with-dependencies.jar

JAVA_OPTIONS= -ea -server -Xmx1000M

.PHONY: all, jar, run, javadoc, style, clean

all: jar

jar:
	mvn -Dmaven.test.skip=true assembly:assembly

run_target: $(target)
	java $(JAVA_OPTIONS) -jar $(target)

javadoc:
	mvn javadoc:javadoc

style:
	mvn checkstyle:checkstyle

clean:
	mvn clean

run:
	mvn spring-boot:run -Dspring-boot.run.profiles=node2

