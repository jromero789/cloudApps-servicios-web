ALTER TABLE vuelo
ADD tripulatntes_id JSON NOT NULL;

ALTER TABLE avion
ADD revisiones JSON NOT NULL;

INSERT INTO vuelo (tripulantes_id) VALUES (json_array(1, 2, 3, 4));
INSERT INTO avion (revisiones) VALUES (json_object(('Revision1', '1' ,'Revision 2', '2')));