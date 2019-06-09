SELECT *
FROM enseignement
WHERE EXISTS (
  SELECT 1
  FROM detailbulletin WHERE id = EnseignementId
);

-- BUT : lister toutes les notes par matières
SELECT note, detailbulletinId
FROM evaluation
WHERE EXISTS (
  SELECT *
  FROM detailbulletin WHERE detailbulletinId = 18
);

SELECT note FROM evaluation
    INNER JOIN detailbulletin ON detailbulletinId = detailbulletin.id
    INNER JOIN enseignement ON EnseignementId = enseignement.id
    INNER JOIN discipline ON disciplineId = 1 ;


SELECT nom FROM discipline WHERE id =;

-- ID = enseignement.getID(); : pour récupérer la valeur de l'id de
-- simplifier aussi la réqueter sql et ne faire qu'une seule jointure
