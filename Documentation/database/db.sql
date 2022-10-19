--SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'armec';
IF NOT EXISTS (SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'api') THEN
 CREATE DATABASE api  ENCODING 'UTF-8' lc_ctype='ru_RU.UTF-8' lc_collate='ru_RU.UTF-8' TEMPLATE template0;
ELSE
 -- запрет подключения новых сессий
 UPDATE pg_database SET datallowconn = 'false' WHERE datname = 'api';

 -- остановка сессий
 SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = 'api' AND pid <> pg_backend_pid();
 -- работа с бд
 DROP DATABASE IF EXISTS api;
 CREATE DATABASE api  ENCODING 'UTF-8' lc_ctype='ru_RU.UTF-8' lc_collate='ru_RU.UTF-8' TEMPLATE template0;
END IF;

-- подключение к базе данных
\c api

CREATE TABLE req(
	id SERIAL PRIMARY KEY NOT NULL,
	symbol VARCHAR NOT NULL,
	price_24h VARCHAR NOT NULL,
	volume_24h VARCHAR NOT NULL,
	last_trade_price VARCHAR NOT NULL
);