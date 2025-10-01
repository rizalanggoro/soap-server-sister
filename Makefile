docker-build-server:
	docker build -t rizalanggoro/soap-server-sister-tugas-5 .

docker-push-server:
	docker push rizalanggoro/soap-server-sister-tugas-5:latest

.PHONY: docker-build-server