#!/bin/bash

sed -i "s/version := .*/version := \"${VERSION}\"/" build.sbt
