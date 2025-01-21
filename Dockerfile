FROM ubuntu:latest
LABEL authors="eddia"

ENTRYPOINT ["top", "-b"]