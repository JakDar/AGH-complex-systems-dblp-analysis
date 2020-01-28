compose=docker run -v /var/run/docker.sock:/var/run/docker.sock -it kbastani/spark-neo4j
up:
	$(compose) up -d

ps:
	$(compose) ps

stop:
	$(compose) stop

rm:
	$(compose) rm

down: stop rm
