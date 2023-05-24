up:
	@echo "Starting docker containers..."
	docker-compose up -d
	@echo "Docker container started."

down:
	@echo "Stopping docker compose..."
	docker-compose down
	@echo "Done."

build:
	@echo "Building movie_rental app..."
	gradle clean build
	@echo "Done."


## up_build: stops docker-compose, builds all projects and starts docker compose
up_build:	down build
	@echo "Re building docker images (if necessary)..."
	docker-compose up --build -d
	@echo "Started."
