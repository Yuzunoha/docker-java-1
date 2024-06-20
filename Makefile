develop-up:
	docker-compose -f docker-compose-develop.yml up -d
develop-down:
	docker-compose -f docker-compose-develop.yml down
deploy-up:
	docker-compose up -d
deploy-down-all:
	docker-compose down --rmi all --volumes
