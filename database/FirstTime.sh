sudo docker build -t atividade_dac/postgres .
sudo docker run --name db_atividade_dac -p 5433:5432 -d atividade_dac/postgres
