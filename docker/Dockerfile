FROM neo4j:3.5.9

# When upgrading check plugin version here : https://github.com/neo4j-contrib/neo4j-graph-algorithms/blob/master/versions.json
RUN curl -o /var/lib/neo4j/plugins/neo4j-graph-algorithms-3.5.9.0-standalone.jar https://s3-eu-west-1.amazonaws.com/com.neo4j.graphalgorithms.dist/neo4j-graph-algorithms-3.5.9.0-standalone.jar
RUN echo "dbms.security.procedures.unrestricted=algo.*" >> /var/lib/neo4j/conf/neo4j.conf
    # dbms.security.procedures.unrestricted=algo.*
    # dbms.security.procedures.unrestricted=apoc.*
    # dbms.memory.heap.initial_size=1G
    # dbms.memory.heap.max_size=9G
#TODO - add memory limits
ENTRYPOINT "bash"
