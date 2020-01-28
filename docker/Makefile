container_name = neo_algo

exec:
	docker exec -it $(container_name) /bin/bash
up:
	docker run -it --name=$(container_name) -v $$(pwd):/host -p 7575:7474 -p 7687:7687  --env 'NEO4JLABS_PLUGINS=["apoc", "graph-algorithms"]' --entrypoint="bash" neo4j:3.5.13
stop:
	docker stop $(container_name)
rm:
	docker rm $(container_name)

down: stop rm
