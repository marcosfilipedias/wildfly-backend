#!/bin/bash
docker run -it --rm -v $PWD:/usr/src -w /usr/src dockerhub.policiamilitar.mg.gov.br/pmmg/maven mvn clean install
