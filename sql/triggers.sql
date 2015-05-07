CREATE OR REPLACE TRIGGER verif_budget_taches
BEFORE INSERT OR UPDATE ON Taches FOR EACH ROW
DECLARE
	budgetTaches Taches.budget%TYPE;
	budgetSousProjet SousProjets.budget%TYPE;
BEGIN
	SELECT SUM(budget) INTO budgetTaches FROM Taches WHERE idSousProjet = :new.idSousProjet;
	SELECT budget INTO budgetSousProjet FROM SousProjets WHERE idSousProjet = :new.idSousProjet;
	if(budgetTaches > budgetSousProjet)
	then raise_application_error(1060,'ERREUR DE budget Taches');
	END IF;
END;
/

CREATE OR REPLACE TRIGGER verif_budget_sous_projet
BEFORE INSERT OR UPDATE ON SousProjets FOR EACH ROW
DECLARE
	budgetLots Lots.budget%TYPE;
	budgetSousProjet SousProjets.budget%TYPE;
BEGIN
	SELECT SUM(budget) INTO budgetSousProjet FROM SousProjets WHERE idLot = :new.idLot;
	SELECT budget INTO budgetLots FROM Lots WHERE idLot = :new.idLot;
	if(budgetSousProjet > budgetLots)
	then raise_application_error(1075,'ERREUR DE budget SousProjets');
	END IF;
END;
/

CREATE OR REPLACE TRIGGER verif_budget_Lots
BEFORE INSERT OR UPDATE ON Lots FOR EACH ROW
DECLARE
	budgetLots Lots.budget%TYPE;
	budgetProjet Projets.budget%TYPE;
BEGIN
	SELECT SUM(budget) INTO budgetLots FROM Lots WHERE idProjet = :new.idProjet;
	SELECT budget INTO budgetProjet FROM Projets WHERE idProjet = :new.idProjet;
	if(budgetLots > budgetProjet)
	then raise_application_error(1090,'ERREUR DE budget Lots');
	END IF;
END;
/