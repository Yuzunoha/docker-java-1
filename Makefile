LOCAL_UID:=$(shell id -u)

develop-up:
	docker-compose -f docker-compose-develop.yml build --build-arg LOCAL_UID=$(LOCAL_UID)
	docker-compose -f docker-compose-develop.yml up -d
develop-down-all:
	docker-compose -f docker-compose-develop.yml down --rmi all --volumes
deploy-up:
	docker-compose up -d
deploy-down-all:
	docker-compose down --rmi all --volumes
