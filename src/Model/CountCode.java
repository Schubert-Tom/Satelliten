package Model;

/**
 * Enum beschreibt mit ob Daten gezählt werden müssen und in welcher Ordnung sich das zu zählende Elemnt befindet.
 * no = no counting, countFirstOrder zu zählendes Objekt ist in der 1. Ordung ST (Anzahl aller Transponder)
 * countSecondOrder wie countFirstOrder, aber zu zählendes Objekt ist in der 2. Ordung CST (Anzahl aller Transponder)
 * STC bedeutet Struktur: Sattelit -> Transponder -> Channel
 * @author 4328112, 1319658, 1060449
 * @version 1.1
 */
public enum CountCode {
    no,countFirstOrder,countSecondOrder, CountFirstAndSecondOrder
}
