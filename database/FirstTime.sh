sudo docker build -t atividade_dac_2/postgres .
sudo docker run --name db_atividade_dac_2 -p 5433:5432 -d atividade_dac_2/postgres
