#!/usr/bin/env bash
exit 1
neo4j-admin import \
    --nodes:person="csv-headers/persons-header.csv,csv/persons.csv" \
    --nodes:venue="csv-headers/venues-header.csv,csv/venues.csv" \
    --nodes:publication="csv-headers/publications-header.csv,csv/publications.csv" \
    --relationships:CITES="csv-headers/cited-header.csv,csv/cited.csv" \
    --relationships:IN_VENUE="csv-headers/in_venue-header.csv,csv/in_venue.csv" \
    --relationships:AUTHORS="csv-headers/authored-header.csv,csv/authored.csv"
