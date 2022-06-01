INSERT INTO tb_telefone (apelido, numero, ddd)
VALUES
    ('Telefone #1', 111111, 21),
    ('Telefone #2', 232323, 11),
    ('Telefone #3', 515151, 41),
    ('Telefone #4', 425262, 72),
    ('Telefone #5', 727272, 61);

INSERT INTO tb_endereco (logradouro, numero, cidade, estado, cep)
VALUES
    ('ABA', 12, 'Goias', 'GO', 3131),
    ('TPTP', 6, 'Espirito Santo', 'ES', 7276),
    ('YZYZ', 4, 'Roraima', 'RR', 8787),
    ('MEME', 3, 'Alaogas', 'AL', 9371),
    ('GBGB', 1, 'Tocantis', 'TO', 5222);
INSERT INTO tb_quarto (numero, qtd_cama)
VALUES
    (101, 1),
    (012, 3),
    (603, 2),
    (412, 1),
    (111, 2);

INSERT INTO tb_diarias (data_entrada, qtd_dias, preco_diaria)
VALUES
    (NOW(), 3, 670),
    (NOW(), 10, 150),
    (NOW(), 5, 1200),
    (NOW(), 6, 950),
    (NOW(), 4, 780);

INSERT INTO tb_hotel (nome, endereco_id)
VALUES
    ('PAPA', 1),
    ('KEKE', 2),
    ('LAUF', 3),
    ('AMTA', 4),
    ('HNGN', 5);

INSERT INTO tb_hotel_quarto (HOTEL_ID, QUARTO_ID)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 3),
    (2, 2),
    (3, 1),
    (3, 3),
    (3, 4),
    (4, 3),
    (4, 5),
    (5, 5),
    (5, 2),
    (1, 5);


INSERT INTO tb_reserva_hotel (criacao_reserva, hotel_id, diarias_id)
VALUES
    (NOW(), 1, 3),
    (NOW(), 3, 5),
    (NOW(), 4, 2),
    (NOW(), 5, 4),
    (NOW(), 2, 1);