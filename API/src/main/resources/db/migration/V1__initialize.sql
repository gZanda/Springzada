CREATE TABLE FAZENDAS (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    proprietario VARCHAR(255) NOT NULL,
    area FLOAT NOT NULL,
    image TEXT
);

INSERT INTO FAZENDAS (nome, proprietario, area, image) VALUES 
    ('Lotus', 'Gustavo', 35.545, 'https://imagem_fazenda_3'),
    ('Green Valley', 'Maria', 50.123, 'https://imagem_fazenda_7'),
    ('Golden Fields', 'Carlos', 78.9, 'https://imagem_fazenda_12'),
    ('Sunflower Ranch', 'Ana', 120.75, 'https://imagem_fazenda_5'),
    ('Silver Creek', 'Pedro', 90.234, 'https://imagem_fazenda_9'),
    ('Blue Sky Farm', 'Julia', 200.321, 'https://imagem_fazenda_1'),
    ('Rainbow Meadows', 'Luiz', 150.678, 'https://imagem_fazenda_6'),
    ('Maple Grove', 'Mariana', 80.456, 'https://imagem_fazenda_11'),
    ('Sunset Ranch', 'Rafael', 65.789, 'https://imagem_fazenda_2'),
    ('Pine Forest', 'Fernanda', 300.987, 'https://imagem_fazenda_8');