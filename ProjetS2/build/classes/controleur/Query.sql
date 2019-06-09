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
-- Note
SELECT note FROM evaluation
    INNER JOIN detailbulletin ON detailbulletinId = detailbulletin.id
    INNER JOIN enseignement ON EnseignementId = enseignement.id
    INNER JOIN discipline ON disciplineId = 1 ;

-- Selection matiere par id
SELECT nom FROM discipline WHERE id =;

-- Nombre d'inscrits par an
SELECT DISTINCT inscription.id FROM inscription
INNER JOIN classe ON classeId = classe.id
INNER JOIN anneescolaire ON anneescolaireId = anneescolaire.id;

-- Nombre d'inscrits par niveau
SELECT DISTINCT inscription.id FROM inscription
INNER JOIN classe ON classeId = classe.id
INNER JOIN niveau ON niveauId = niveau.id;



-- SELECT ID FROM TABLE T
    -- INNER JOIN TABLE2 T2 ON T.ID = T2.ID
    -- INNER JOIN TABLE3 T3 ON T2.ID = T3.ID


-- ID = enseignement.getID(); : pour récupérer la valeur de l'id de
-- simplifier aussi la réqueter sql et ne faire qu'une seule jointure
