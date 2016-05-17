
package sintatico;
import lexico.*;
/**
 *
 * @author guilhermeferreira
 */
public class AnalisadorSintatico {
    Producao[] gramatica = 
    {
        new Producao("P\' -> P ",0),
        new Producao("P -> inicio V A",1),
        new Producao("V -> varinicio LV",2),
        new Producao("LV -> D LV",3),
        new Producao("LV -> varfim;",4),
        new Producao("D -> id TIPO;",5),
        new Producao("TIPO -> int",6),
        new Producao("TIPO -> real",7),
        new Producao("TIPO -> lit",8),
        new Producao("A -> ES A",9),
        new Producao("ES -> leia id;",10),
        new Producao("ES -> escreva ARG;",11),
        new Producao("ARG -> literal",12),
        new Producao("ARG -> num",13),
        new Producao("ARG -> id",14),
        new Producao("A -> CMD A",15),
        new Producao("CMD -> id rcb LD",16),
        new Producao("LD -> OPRM opm OPRD",17),
        new Producao("LD -> OPRD",18),
        new Producao("OPRD -> id",19),
        new Producao("OPRD -> num",20),
        new Producao("A -> COND A",21),
        new Producao("COND -> CABECALHO CORPO",22),
        new Producao("CABECALHO -> se (EXP_R) entao",23),
        new Producao("EXP_R -> OPRD opr OPRD",24),
        new Producao("CORPO -> ES CORPO",25),
        new Producao("CORPO -> CMD CORPO",26),
        new Producao("CORPO -> COND CORPO",27),
        new Producao("CORPO -> fimse",28),
        new Producao("A -> fim",29),
        new Producao("opm -> OPM(+)",30),
        new Producao("opm -> OPM(-)",31),
        new Producao("opm -> OPM(*)",32),
        new Producao("opm -> OPM(/)",33),
        new Producao("LD -> OPM(+) OPRD opm OPRD",34),
        new Producao("LD -> OPM(-) OPRD opm OPRD",35),
        new Producao("opr -> OPR(<>)",36),
        new Producao("opr -> OPR(=)",37),
        new Producao("opr -> OPR(<)",38),
        new Producao("opr -> OPR(<=)",39),
        new Producao("opr -> OPR(>)",40),
        new Producao("opr -> OPR(>=)",41)
    };
}
