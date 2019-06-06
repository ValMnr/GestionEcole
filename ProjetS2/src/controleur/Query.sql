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
  SELECT 1
  FROM detailbulletin WHERE detailbulletinId = 18
);

-- ID = enseignement.getID(); : pour récupérer la valeur de l'id de
-- simplifier aussi la réqueter sql et ne faire qu'une seule jointure
