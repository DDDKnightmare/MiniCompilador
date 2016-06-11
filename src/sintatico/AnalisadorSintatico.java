
package sintatico;
import lexico.*;
import java.io.IOException;
import java.util.Arrays;
import static lexico.AnalisadorLexico.tokenFim;
import java.util.Stack;
/**
 *
 * @author guilhermeferreira
 */
public class AnalisadorSintatico {
    
    public static final int P = 22;
    public static final int V = 23;
    public static final int A = 24;
    public static final int LV = 25;
    public static final int D = 26;
    public static final int TIPO = 27;
    public static final int ES = 28;
    public static final int ARG = 29;
    public static final int CMD = 30;
    public static final int LD = 31;
    public static final int OPRD = 32;
    public static final int COND = 33;
    public static final int CABECALHO = 34;
    public static final int CORPO = 35;
    public static final int EXP_R = 36;
    public static final int P_ = 37;
    
    Producao[] gramatica = 
    {   //Parametros: producao, codigo, tamanho, lado esquerdo

        new Producao("P\' -> P ", 1, 1, P_),
        new Producao("P -> inicio V A", 2, 3, P),
        new Producao("V -> varinicio LV", 3, 2, V),
        new Producao("LV -> D LV", 4, 2, LV),
        new Producao("LV -> varfim;", 5, 2, LV),
        new Producao("D -> id TIPO;", 6, 3, D),
        new Producao("TIPO -> int", 7, 1, TIPO),
        new Producao("TIPO -> real", 8, 1, TIPO),
        new Producao("TIPO -> lit", 9, 1, TIPO),
        new Producao("A -> ES A", 10, 2, A),
        new Producao("ES -> leia id;", 11, 3, ES),
        new Producao("ES -> escreva ARG;", 12, 3, ES),
        new Producao("ARG -> literal", 13, 1, ARG),
        new Producao("ARG -> num", 14, 1, ARG),
        new Producao("ARG -> id", 15, 1, ARG),
        new Producao("A -> CMD A", 16, 2, A),
        new Producao("CMD -> id rcb LD;", 17, 4, CMD),
        new Producao("LD -> OPRM opm OPRD", 18, 3, LD),
        new Producao("LD -> OPRD", 19, 1, LD),
        new Producao("OPRD -> id", 20, 1, OPRD),
        new Producao("OPRD -> num", 21, 1, OPRD),
        new Producao("A -> COND A", 22, 2, A),
        new Producao("COND -> CABECALHO CORPO", 23, 2, COND),
        new Producao("CABECALHO -> se (EXP_R) entao", 24, 5, CABECALHO),
        new Producao("EXP_R -> OPRD opr OPRD", 25, 3, EXP_R),
        new Producao("CORPO -> ES CORPO", 26, 2, CORPO),
        new Producao("CORPO -> CMD CORPO", 27, 2, CORPO),
        new Producao("CORPO -> COND CORPO", 28, 2, CORPO),
        new Producao("CORPO -> fimse", 29, 1, CORPO),
        new Producao("A -> fim", 30, 1, A),
//        new Producao("opm -> OPM(+)",31),
//        new Producao("opm -> OPM(-)",32),
//        new Producao("opm -> OPM(*)",33),
//        new Producao("opm -> OPM(/)",34),
        new Producao("LD -> OPRD opm OPRD", 31, 3, LD)
//        new Producao("LD -> OPM(-) OPRD opm OPRD",36),
//        new Producao("opr -> OPR(<>)",37),
//        new Producao("opr -> OPR(=)",38),
//        new Producao("opr -> OPR(<)",39),
//        new Producao("opr -> OPR(<=)",40),
//        new Producao("opr -> OPR(>)",41),
//        new Producao("opr -> OPR(>=)",42)

    };
    public static final int s = 0;
    public static final int t = 1;
    public static final int r = 2;
    public static final int erro = -1;
    public static final int acc = 15;
    
    public int[][][] tabelaSintatica = {
//          0           1                   2              3                4               5               6               7               8               9               10              11              12              13              14              15              16              17              18              19              20              21              22              23              24              25              26              27              28              29               30           31                32              33              34            35                36
//      inicio          varinicio	varfim	          id	          int	         real	           lit          literal           leia	        escreva             ;	           (	            )	            num	           rcb	           opm	           opr	           se	          entao	          fim	         fimse	            $	           P	           V	           A                LV              D               TIPO            ES              ARG             CMD           LD	          OPRD	          COND	       CABECALHO	CORPO	          EXP_R
/*00*/	{{s,2},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,1},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*01*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{acc,},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*02*/	{{erro,-1},	{s,4},  	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,3},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*03*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,10},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,14},         {erro,-1},	{s,9},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,5},          {erro,-1},	{erro,-1},	{erro,-1},	{t,6},          {erro,-1},	{t,7},          {erro,-1},	{erro,-1},	{t,8},          {t,13},         {erro,-1},	{erro,-1}},
/*04*/	{{erro,-1},	{erro,-1},	{s,17},         {s,18},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,19},         {t,15},         {t,16},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*05*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,2},          {erro,-1},	{erro,-1},	{t,19},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*06*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,10},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,14},         {erro,-1},	{s,9},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,19},         {erro,-1},	{erro,-1},	{erro,-1},	{t,6},          {erro,-1},	{t,7},          {erro,-1},	{erro,-1},	{t,8},          {t,13},         {erro,-1},	{erro,-1}},
/*07*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,10},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,14},         {erro,-1},	{s,9},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,20},         {erro,-1},	{erro,-1},	{erro,-1},	{t,6},          {erro,-1},	{t,7},          {erro,-1},	{erro,-1},	{t,8},          {t,13},         {erro,-1},	{erro,-1}},
/*08*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,10},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,14},         {erro,-1},	{s,9},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,21},         {erro,-1},	{erro,-1},	{erro,-1},	{t,6},          {erro,-1},	{t,7},          {erro,-1},	{erro,-1},	{t,8},          {t,13},         {erro,-1},	{erro,-1}},
/*09*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,30},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*10*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,22},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*11*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,26},         {erro,-1},	{erro,-1},	{erro,-1},	{s,24},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,25},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,23},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*12*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,27},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*13*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,10},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,14},         {erro,-1},	{erro,-1},	{s,32},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,29},         {erro,-1},	{t,30},         {erro,-1},	{erro,-1},	{t,31},         {t,13},         {t,28},         {erro,-1}},
/*14*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,33},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*15*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,3},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,3},          {r,3},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,3},          {erro,-1},	{r,3},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*16*/	{{erro,-1},	{erro,-1},	{s,17},         {s,18},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,34},         {t,16},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*17*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,35},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*18*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,37},         {s,38},         {s,39},         {erro,-1},      {erro,-1},      {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,36},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*19*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,10},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*20*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,16},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*21*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,22},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
//	inicio          varinicio	varfim          id              int             real            lit             literal         leia            escreva         ;               (               )               num             rcb             opm             oPr             se              entao           fim             fimse           $                P              V               A               LV              D               TIPO            ES              ARG             CMD             LD              OPRD            COND            CABECALHO        CORPO          EXP_R
/*22*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},      {r,40},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*23*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,41},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*24*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,13},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*25*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,14},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*26*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,15},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*27*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,44},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,45},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,42},         {t,43},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*28*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,23},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,23},         {r,23},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,23},         {erro,-1},	{r,23},         {r,23},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*29*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,10},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,14},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,29},         {erro,-1},	{t,30},         {erro,-1},	{erro,-1},	{t,31},         {t,13},         {t,46},         {erro,-1}},
/*30*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,10},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,14},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,29},         {erro,-1},	{t,30},         {erro,-1},	{erro,-1},	{t,31},         {t,13},         {t,47},         {erro,-1}},
/*31*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,10},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,14},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,29},         {erro,-1},	{t,30},         {erro,-1},	{erro,-1},	{t,31},         {t,13},         {t,48},         {erro,-1}},
/*32*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,29},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,29},         {r,29},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,29},         {erro,-1},	{r,29},         {r,29},     	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*33*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,44},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,45},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,50},         {erro,-1},	{erro,-1},	{erro,-1},	{t,49}},
/*34*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,4},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,4},          {r,4},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,4},          {erro,-1},	{r,4},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*35*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,5},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,5},          {r,5},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,5},          {erro,-1},	{r,5},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*36*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,51},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*37*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,7},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*38*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,8},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*39*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,9},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*40*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,11},         {s,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,11},         {erro,-1},	{r,11},         {r,11},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*41*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,12},         {r,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,12},         {erro,-1},	{r,12},         {r,12},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*42*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,52},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*43*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,19},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,53},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
//	inicio          varinicio       varfim          id              int             real            lit             literal         leia            escreva         ;               (               )               num             rcb             opm             oPr             se              entao           fim             fimse           $               P               V               A               LV              D               TIPO            ES              ARG             CMD             LD              OPRD            COND            CABECALHO	CORPO           EXP_R
/*44*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,20},         {erro,-1},	{r,20},         {erro,-1},	{erro,-1},	{r,20},         {r,20},         {erro,-1},      {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*45*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,21},         {erro,-1},	{r,21},         {erro,-1},	{erro,-1},	{r,21},         {r,21},         {erro,-1},      {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*46*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,26},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,26},         {r,26},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,26},         {erro,-1},	{r,26},         {r,26},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*47*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,27},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,27},         {r,27},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,27},         {erro,-1},	{r,27},         {r,27},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*48*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,28},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,28},         {r,28},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,28},         {erro,-1},	{r,28},         {r,28},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*49*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,54},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*50*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,55},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*51*/	{{erro,-1},	{erro,-1},	{r,6},          {r,6},          {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*52*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,17},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,17},         {r,17},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,17},         {erro,-1},	{r,17},         {r,17},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*53*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,44},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,45},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,56},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*54*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,54},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*55*/	{{erro,-1},	{erro,-1},	{erro,-1},	{s,44},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{s,45},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{t,58},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*56*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,18},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*57*/	{{erro,-1},	{erro,-1},	{erro,-1},	{r,24},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,24},         {r,24},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,24},         {erro,-1},	{erro,-1},	{r,24},         {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
/*58*/	{{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{r,25},         {erro,-1},      {erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1},	{erro,-1}},
//	inicio          varinicio       varfim          id              int             real            lit             literal         leia            escreva         ;               (               )               num             rcb             opm             oPr             se              entao           fim             fimse           $               P               V               A               LV              D               TIPO            ES              ARG             CMD             LD              OPRD            COND            CABECALHO	CORPO           EXP_R

  
    };
    
    public Stack pilha = new Stack();
    public int estado = 0;
    public int error = 0;

    public static final int inicio = 0;
    public static final int varInicio = 1;
    public static final int varFim = 2;
    public static final int id = 3;
    public static final int Int = 4;
    public static final int real = 5;
    public static final int lit = 6;
    public static final int literal = 7;
    public static final int leia = 8;
    public static final int escreva = 9;
    public static final int pontoVirgula = 10;
    public static final int abreParenteses = 11;
    public static final int fechaParenteses = 12;
    public static final int num = 13;
    public static final int RCB = 14;
    public static final int OPM = 15;
    public static final int OPR = 16;
    public static final int se = 17;
    public static final int entao = 18;
    public static final int fim = 19;
    public static final int fimse = 20;

    public int mapeiaToken(int token){//Mapeia token de acordo com a coluna da tabela
        if(token == AnalisadorLexico.tokenInicio){
            return inicio;
        }
        else if(token == AnalisadorLexico.tokenVarInicio){
            return varInicio;
        }
        else if(token == AnalisadorLexico.tokenVarFim){
            return varFim;
        }
        else if(token == AnalisadorLexico.tokenId){
            return id;
        }
        else if(token == AnalisadorLexico.palavraReservadaInteiro){
            return Int;
        }
        else if(token == AnalisadorLexico.palavraReservadaReal){
            return real;
        }
        else if(token == AnalisadorLexico.palavraReservadaLiteral){
            return lit;
        }
        else if(token == AnalisadorLexico.tokenLiteral){
            return literal;
        }
        else if(token == AnalisadorLexico.tokenLeia){
            return leia;
        }
        else if(token == AnalisadorLexico.tokenEscreva){
            return escreva;
        }
        else if(token == AnalisadorLexico.tokenPontoVirgula){
            return pontoVirgula;
        }
        else if(token == AnalisadorLexico.tokenAbreParenteses){
            return abreParenteses;
        }
        else if(token == AnalisadorLexico.tokenFechaParenteses){
            return fechaParenteses;
        }
        else if(token == AnalisadorLexico.tokenNumero){
            return num;
        }
        else if(token == AnalisadorLexico.tokenDeclaracao){
            return RCB;
        }
        else if(token == AnalisadorLexico.tokenMais || token == AnalisadorLexico.tokenMenos 
                || token == AnalisadorLexico.tokenMultiplicacao || token == AnalisadorLexico.tokenDivisao ){
            return OPM;
        }
        else if(token == AnalisadorLexico.tokenMenor || token == AnalisadorLexico.tokenMenorIgual 
                || token == AnalisadorLexico.tokenDiferente || token == AnalisadorLexico.tokenMaior 
                || token == AnalisadorLexico.tokenMaiorIgual || token == AnalisadorLexico.tokenIgual ){
            return OPR;
        }
        else if(token == AnalisadorLexico.tokenSe){
            return se;
        }
        else if(token == AnalisadorLexico.tokenEntao){
            return entao;
        }
        else if(token == AnalisadorLexico.tokenFim){
            return fim;
        }
        else if(token == AnalisadorLexico.tokenFimSe){
            return fimse;
        }
        else return -1;
    }
    public void erro(Lexema token){
        System.out.println("Erro na linha: " + token.getLinha()+ " com o lexema: " + token.getLexema());
        error = -1;
    
    }
    
    public void analisadorSintatico() throws IOException{
        Lexema token = Main.obterLexemas();

        System.out.println(token.getLexema());
        int push;
        int numProducao;
        int ladoEsq;
        while (error != -1 || (token.getToken() != AnalisadorLexico.tokenFim && token.getLexema() != "fim") ){

            
            
            if(pilha.isEmpty()== false){
                estado = (int)pilha.peek();// novo s'
            }
            
            int acao = tabelaSintatica[estado][mapeiaToken(token.getToken())][0];
            //System.out.println("token: "+ token.getStringToken() + " linha: " + token.getLinha()+ " acao: [" + estado+ "],[" + mapeiaToken(token.getToken()) + "]" + " acao: " + acao);
            
            switch(acao){
                case s:
                    pilha.push(token);
                    push = tabelaSintatica[estado][mapeiaToken(token.getToken())][1];
                    System.out.println("prox est:" + tabelaSintatica[estado][mapeiaToken(token.getToken())][1]);
                    
                    pilha.push(push);
                    estado = tabelaSintatica[estado][mapeiaToken(token.getToken())][1];
                    token = Main.obterLexemas();               
                    break;

                case r:

                    numProducao = tabelaSintatica[estado][mapeiaToken(token.getToken())][1]-1;
                    for(int i = 0; i < gramatica[numProducao].getTamanho() * 2; i++){
                        pilha.pop();
                    }

                    estado = (int)pilha.peek();
                    System.out.println("produção: "+ gramatica[numProducao].getProducao());
//                    System.out.println(pilha.toString());
                    ladoEsq = gramatica[numProducao].getLadoEsquerdo();
                    pilha.push(ladoEsq);
                    if(tabelaSintatica[estado][ladoEsq][0] == t){
                        estado = tabelaSintatica[estado][ladoEsq][1];
                        System.out.println(estado);
                    }else{
                        erro(token);
                    }
                    

//                    System.out.println(gramatica[tabelaSintatica[estado][mapeiaToken(token.getToken())][1]].getProducao());
                    break;

                case acc:
                    return;


                default:
                    erro(token);
                    return;
                                        
    }
    }
    
    
    }
}

