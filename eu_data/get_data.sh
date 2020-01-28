#!/bin/bash

mkdir -p eu
wget http://snap.stanford.edu/data/email-Eu-core.txt.gz
wget http://snap.stanford.edu/data/email-Eu-core-department-labels.txt.gz
gunzip email-Eu-core.txt.gz
gunzip email-Eu-core-department-labels.txt.gz

mv email-Eu-core-department-labels.txt eu/
mv email-Eu-core.txt eu/
