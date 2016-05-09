/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

/**
 *
 * @author Guilherme Flores e Nicole Tannus
 * 
 */
import java.io.*;
import java.util.ArrayList;



public class AnalisadorLexico {
// Tokens----------------------------------------------
//public static final int tokenRealInt = 0;
//public static final int tokenInteiro = 1;
//public static final int tokenReal = 2;
public static final int tokenNumero = 2;
public static final int tokenLiteral = 3;
public static final int tokenId = 4;
public static final int tokenMenor = 5;
public static final int tokenMenorIgual = 6;
public static final int tokenDiferente = 7;
public static final int tokenMaior = 8;
public static final int tokenIgual = 9;
public static final int tokenDeclaracao = 10;
public static final int tokenMais = 11;
public static final int tokenMenos = 12;
public static final int tokenMultiplicacao = 13;
public static final int tokenDivisao = 14;
public static final int tokenAbreParenteses = 15;
public static final int tokenFechaParenteses = 16;
public static final int tokenPontoVirgula = 17;
public static final int tokenInicio  = 18;
public static final int tokenVarInicio  = 19;
public static final int tokenVarFim  = 20;
public static final int tokenEscreva  = 21;
public static final int tokenLeia  = 22;
public static final int tokenSe  = 23;
public static final int tokenEntao  = 24;
public static final int tokenFimSe  = 25;
public static final int tokenFim = 26;
public static final int tokenErro = 27;
public static final int tokenMaiorIgual = 28;

//Tipos-----------------------------------------------
public static final int tipoInteiro = 50;
public static final int tipoReal = 51;
public static final int tipoLiteral = 52;
public static final int palavraReservada = 53;
//FimTipos
//public static final int tokenComentario = 500;
//FimTokens-------------------------------------------
//Entradas--------------------------------------------
static final int L=0;
static final int D=1;
static final int E=2;
static final int Underline=3;
static final int Soma =4;
static final int Subtracao =5;
static final int Vezes =6;
static final int Divisao =7;
static final int AspasDuplas =8;
static final int Ponto =9;
static final int PontoVirgula =10;
static final int Menor =11;
static final int Maior =12;
static final int Igual =13;
static final int AbreParenteses =14;
static final int FechaParenteses =15;
static final int AbreChaves =16;
static final int FechaChaves=17;
static final int Espaco = 18;
static final int BarraN =19;
static final int Outro = 20;
static final int FimArquivo = 21;
//FimEntradas-----------------------------------------
//Tabela de Transição
//Observação: eventuais erros em estados finais sao tratados no estado 0
private int tabelaTransicao[][] = {
//              L        D       E       _        +      -       *       /       "       .       ;       <       >       =       (       )       {       }       Espaço  \n    Outro     Fim de Arquivo
/*Estado 0 */   {16,     1,     16,     -1,     25,     26,     27,     28,     14,     -1,     31,     20,     24,     19,     29,     30,     17,     18,      0,      0,     -1,          0},
/*Estado 1 */   { 0,     1,      4,      0,      0,      0,      0,      0,      0,      2,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 2 */   {-1,     3,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,         -1},
/*Estado 3 */   { 0,     3,      9,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 4 */   {-1,     6,     -1,     -1,      5,      7,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,         -1},
/*Estado 5 */   {-1,     6,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,         -1},
/*Estado 6 */   { 0,     6,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
//              L       D       E       _        +      -       *       /       "       .       ;       <       >       =       (       )       {       }       Espaço  \n    Outro     Fim de Arquivo
/*Estado 7 */   {-1,     8,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,         -1},
/*Estado 8 */   { 0,     8,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,	 0,      0,      0,      0,          0},
/*Estado 9 */   {-1,    11,     -1,     -1,     10,     12,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,         -1},
/*Estado 10*/   {-1,    11,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,         -1},
/*Estado 11*/   { 0,    11,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 12*/   {-1,    13,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,     -1,         -1},
/*Estado 13*/   { 0,    13,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 14*/   {14,    14,     14,     14,     14,     14,     14,     14,     15,     14,     14,     14,     14,     14,     14,     14,     14,     14,     14,     14,     14,         -1},
/*Estado 15*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
//              L       D       E       _        +      -       *       /       "       .       ;       <       >       =       (       )       {       }       Espaço  \n    Outro     Fim de Arquivo
/*Estado 16*/   {16,    16,     16,     16,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 17*/   {17,    17,     17,     17,     17,     17,     17,     17,     17,     17,     17,     17,     17,     17,     17,     17,     17,     18,     17,     17,     17,         -1},
/*Estado 18*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 19*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 20*/   { 0,     0,      0,      0,      0,     21,      0,      0,      0,      0,      0,      0,     23,     22,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 21*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
//              L       D       E       _        +      -       *       /       "       .       ;       <       >       =       (       )       {       }       Espaço  \n    Outro     Fim de Arquivo
/*Estado 22*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 23*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 24*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,     32,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 25*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 26*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 27*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
//              L       D       E       _        +      -       *       /       "       .       ;       <       >       =       (       )       {       }       Espaço  \n    Outro     Fim de Arquivo
/*Estado 28*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 29*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 30*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 31*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0},
/*Estado 32*/   { 0,     0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,      0,          0}
};
//Fim Tabela de Transição

private String getValorLido(){
    if(this.mapaCaracter(c) != FimArquivo){
        return ""+(char)c;
    }else{
        return "FIM DO ARQUIVO";
    }
}

private String getEntradaEsperada(int estado){ //para o relatorio de erro 
    switch(estado){
        case 0:     return "LETRA, DIGITO, +. -, *, /, \",;, <, >, =, (, ), {, FIM DE ARQUIVO";
        case 2:     case 5:     case 7:     case 10:    
        case 12:    
            return "DIGITO";
        case 4:     case 9:     
            return "DIGITO, +, -";
        case 14:
            return "\"";
        case 17:
            return "}";
        default:
            return "";
    }
}

private void mensagemErro(){
    System.out.println("ERRO: ENTRADA INESPERADA\n" +
                       "ESPERADO: "+this.getEntradaEsperada(estado)+"\n"+
                       "LIDO: " + this.getValorLido()+"\n" +
                       "NA LINHA: " + (linha+1) + ", COLUNA: " + (coluna+1));
}




public int linha = 0;
public int coluna = 0;


private int numeroLexemas = 0;
private FileInputStream fonteAlg;
private InputStreamReader caracter;
private int estado = 0;
private int c = 999;
ArrayList<Lexema> lexemas = new ArrayList<Lexema>();




public Lexema[] getArrayLexemas(){
    return lexemas.toArray(new Lexema[lexemas.size()]);
}

public int getNumeroLexemas(){
    return numeroLexemas;
}

public void setLinha(int linha){
    this.getLexema().setLinha(linha);
}

public Lexema getLexema(){
    return lexemas.get(numeroLexemas);
}

public int getToken(int indice){
    return lexemas.get(indice).getToken();
}

public String getStringToken(int indice){
    return lexemas.get(indice).getStringToken();
}

public int getC(){
    return this.c;
}

public void setLexema(int indice, String lexema){
    lexemas.get(indice).setLexema(lexema);
}

public void concatenarLexema(int indice, int lexema){
    lexemas.get(indice).concatenarLexema(lexema);
}

public void concatenarLexema(int indice, char lexema){
    lexemas.get(indice).concatenarLexema((char) lexema);
}

public boolean hasSimbolo(Lexema key){
    return TabelaSimbolos.hasSimbolo(key);
}

public String getLexema(int indice){
    return lexemas.get(indice).getLexema();
}

public void setToken(int indice, int token){
    lexemas.get(indice).setToken(token);
}

public void setTipo(int indice, int tipo){
    lexemas.get(indice).setTipo(tipo);
}

public int mapaEstado(int estado){
    switch(estado){
        case 8:    case 11:     case 1:    case  6:                     
        case 2:    case 13:     case 3:    
            return tokenNumero;
        
        case 15: 
            return tokenLiteral;
        
        case 16: 
// Verificando se é id ou palavra reservada
                switch(this.getLexema(numeroLexemas)){
                    case "inicio":
                        return tokenInicio;
                    case "varinicio":
                        return tokenVarInicio;
                    case "varfim":
                        return tokenVarFim;
                    case "escreva":
                        return tokenEscreva;
                    case "leia":
                        return tokenLeia;
                    case "se": 
                        return tokenSe;
                    case "entao":
                        return tokenEntao;
                    case "fimse":
                        return tokenFimSe;
                    case "fim":
                        return tokenFim;
                    case "literal":
                        return palavraReservada;
                    case "inteiro":
                        return palavraReservada;
                    case "real":
                        return palavraReservada;
                    default:
                        return tokenId;
                }
// Fim verificação de palavras reservadas
        //case 18: return tokenComentario;
        case 19: return tokenIgual;
        case 20: return tokenMenor;
        case 21: return tokenDeclaracao;
        case 22: return tokenMenorIgual;
        case 23: return tokenDiferente;
        case 24: return tokenMaior;
        case 25: return tokenMais;
        case 26: return tokenMenos;
        case 27: return tokenMultiplicacao;
        case 28: return tokenDivisao;
        case 29: return tokenAbreParenteses;
        case 30: return tokenFechaParenteses;
        case 31: return tokenPontoVirgula;
        case 32: return tokenMaiorIgual;
        default: return tokenErro;
    }
}

public void carregaArquivo(File arquivo) throws FileNotFoundException, IOException{
    fonteAlg = new FileInputStream(arquivo);
    caracter = new InputStreamReader(fonteAlg);
    c = caracter.read();
}

public Lexema getSimbolo(Lexema simbolo){
      if(null != TabelaSimbolos.getSimbolo(simbolo.getLexema())){
          return TabelaSimbolos.getSimbolo(simbolo.getLexema());
      }
      return null;
}

public void addSimbolo(Lexema key){
    TabelaSimbolos.addSimbolo(key);
}

public void alteraSimbolo(Lexema key){
    TabelaSimbolos.alteraSimbolo(key);
}

public void removeSimbolo(Lexema key){
    TabelaSimbolos.removeSimbolo(key.getLexema());
}

public Lexema analisaTexto() throws FileNotFoundException, IOException{
//TabelaTransicao[estado][entrada]
    do{
//cast para char realizado nas funções 
        switch (estado){
                case 0:// Obs: lexemas só são criados no estado zero;
// Começando a percorrer o Automato----------------------------------------------------
                        if(this.mapaCaracter(c) != Espaco       &&
                           this.mapaCaracter(c) != BarraN       &&
                           this.mapaCaracter(c) != AbreChaves   &&
                           this.mapaCaracter(c) != FimArquivo   &&
                           this.mapaCaracter(c) != Outro){//Tratando caracateres diferentes de " ", /n, {, EOF, outros
                                lexemas.add(new Lexema(c));
                                coluna += 1;
                        }else if(this.mapaCaracter(c) != FimArquivo){ //Tratando " ", /n, {, outros
                                while(this.mapaCaracter(c) == Espaco || this.mapaCaracter(c) == BarraN){
                                    switch(this.mapaCaracter(c)){
                                        case Espaco:
                                            if((char)c == '\t'){
                                                coluna += 8;
                                                c = caracter.read();
                                            }else{                      // ' '
                                                coluna += 1;
                                                c = caracter.read();
                                            }
                                            break;

                                        case BarraN:
                                            if((char)c == '\n'){
                                                linha += 1;
                                                coluna = 0;
                                                c = caracter.read();
                                            }else{                      // '\r'
                                                coluna = 0;
                                                c = caracter.read();
                                            }
                                            break;
                                    }
                                }
                                if(this.mapaCaracter(c) == AbreChaves){
                                        coluna += 1; 
                                }else if(this.mapaCaracter(c) != Outro      &&
                                         this.mapaCaracter(c) != FechaChaves){
                                                lexemas.add(new Lexema(c));
                                                coluna += 1;
                                }else{
                                    this.mensagemErro();
                                    lexemas.add(new Lexema(c,tokenErro,linha));
                                    coluna += 1;
                                    numeroLexemas += 1;
                                   
                                }
                                
                        }else{
                            if(lexemas.get(lexemas.size()-1).getToken() != tokenFim){
                                     lexemas.add(new Lexema("FIM DO ARQUIVO",tokenFim));
                                     this.setLinha(linha);
                                     numeroLexemas += 1;
                            }
                        }
                    break;
// Reais / Inteiros---------------------------------------------------------------------
                case 1:
                    switch(this.mapaCaracter(c)){
                        case D:     case E:     case Ponto:
                            this.concatenarLexema(numeroLexemas, c);
                            coluna += 1;
                            break;
                        default: 
                            this.setToken(numeroLexemas, this.mapaEstado(estado));
                            this.setTipo(numeroLexemas, this.mapaTipo());
                            this.setLinha(linha);
                            numeroLexemas += 1;
                            break;
                    }
                    
                    break;
                case 2:
                    if(this.mapaCaracter(c) != D){
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                        this.mensagemErro();
                    }else{
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }
                    
                    break;
                case 3:
                    if(this.mapaCaracter(c) == D || this.mapaCaracter(c) == E){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setTipo(numeroLexemas, this.mapaTipo());
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                    
                    break;
                case 4:
                    switch(this.mapaCaracter(c)){
                        case Soma:      case Subtracao:     case D:
                            this.concatenarLexema(numeroLexemas, c);
                            coluna += 1;
                            break;
                        default:
                            this.setToken(numeroLexemas, this.mapaEstado(estado));
                            this.setLinha(linha);
                            numeroLexemas += 1;
                            this.mensagemErro();
                            break;
                    }
                    
                    break;
                case 5:
                    if(this.mapaCaracter(c) == D){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                        this.mensagemErro();
                    }
                    
                    break;
                case 6:
                    if(this.mapaCaracter(c) == D){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setTipo(numeroLexemas, this.mapaTipo());
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                    
                    break;
                case 7:
                    if(this.mapaCaracter(c) == D){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                        this.mensagemErro();
                    }
                    
                    break;
                case 8:
                    if(this.mapaCaracter(c) == D){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                    
                    break;
                case 9:
                    if(this.mapaCaracter(c) == D        || 
                       this.mapaCaracter(c) == Soma     || 
                       this.mapaCaracter(c) == Subtracao){
                            this.concatenarLexema(numeroLexemas, c);
                            coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                        this.mensagemErro();
                    }
                    
                    break;
                case 10:
                    if(this.mapaCaracter(c) == D){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                        this.mensagemErro();
                    }
                    
                    break;
                case 11:
                    if(this.mapaCaracter(c) == D){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                    
                    break;
                case 12:
                    if(this.mapaCaracter(c) == D){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                        this.mensagemErro();
                    }
                    
                    break;
                case 13:
                    if(this.mapaCaracter(c) == D){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setTipo(numeroLexemas, this.mapaTipo());
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                    
                    break;
// Fim reais / inteiros---------------------------------------------------------------------
// Strings ---------------------------------------------------------------------------------
                case 14:
                    if(this.mapaCaracter(c) != FimArquivo){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.mensagemErro();
                        this.setToken(numeroLexemas, tokenErro);
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                    break;
                case 15:
                    this.setToken(numeroLexemas, this.mapaEstado(estado));
                    this.setTipo(numeroLexemas, this.mapaTipo());
                    this.setLinha(linha);
                    numeroLexemas += 1;
                    break;
// Fim Strings-----------------------------------------------------------------------------
// ID--------------------------------------------------------------------------------------
                case 16:
                    if(this.mapaCaracter(c) == L        ||
                       this.mapaCaracter(c) == E        ||
                       this.mapaCaracter(c) == D        ||
                       this.mapaCaracter(c) == Underline){

                            this.concatenarLexema(numeroLexemas, c);
                            coluna += 1;
                    }else{
                       
                        if(!hasSimbolo(this.getLexema())){
                            
                            this.getLexema().setToken(this.mapaEstado(estado));
                            this.addSimbolo(this.getLexema());
                            
                        }else{
                            
                            if(this.getLexema().getTipo() != this.getSimbolo(this.getLexema()).getTipo()          &&
                               this.getLexema().getTipo() != 0 && this.getSimbolo(this.getLexema()).getTipo() == 0){
                                    
                                    this.alteraSimbolo(this.getLexema());
                                    
                            }else{
                                
                                this.getLexema().setTipo(this.getSimbolo(this.getLexema()).getTipo());
                                this.getLexema().setToken(this.getSimbolo(this.getLexema()).getToken());
                                
                            }
                        }
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                        
                    
                    break;
// Comentarios--------------------------------------------------------------------------------
                case 17:
                    if(this.mapaCaracter(c) != FimArquivo){
                        switch(this.mapaCaracter(c)){
                                        case Espaco:
                                            if((char)c == '\t'){
                                                coluna += 8;
                                            }else{                      // ' '
                                                coluna += 1;
                                            }
                                            break;

                                        case BarraN:
                                            if((char)c == '\n'){
                                                linha += 1;
                                                coluna = 0;
                                            }else{                      // '\r'
                                                coluna = 0;
                                            }
                                            break;
                                        default:
                                            coluna += 1;
                                            
                                            break;
                                    }
                    }else{
                        this.mensagemErro();
                    }
                        break;
                    
                case 18:
                    coluna += 1;
                    break;
// Fim Comentarios----------------------------------------------------------------------------
// Fim ID-------------------------------------------------------------------------------------
// Operadores Relacionais ou Atribuição-------------------------------------------------------
                case 20:
                    if(this.mapaCaracter(c) == Subtracao        ||
                       this.mapaCaracter(c) == Igual            ||
                       this.mapaCaracter(c) == Maior            ){

                            this.concatenarLexema(numeroLexemas, c);
                            coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                    
                    break;
                case 24:
                    if(this.mapaCaracter(c) == Igual){
                        this.concatenarLexema(numeroLexemas, c);
                        coluna += 1;
                    }else{
                        this.setToken(numeroLexemas, this.mapaEstado(estado));
                        this.setLinha(linha);
                        numeroLexemas += 1;
                    }
                    
                    break;
// Fim Operadores Relacionais

// Estados Finais Que nao sao mantidos com nenhuma Entrada
                case 19:    case 21:    case 22:    case 23:    
                case 25:    case 26:    case 27:    case 28:    
                case 29:    case 30:    case 31:    case 32:
                    this.setToken(numeroLexemas, this.mapaEstado(estado));
                    this.setLinha(linha);
                    numeroLexemas += 1;
                    break;
//Estados não existentes:
                default:
                    System.out.println("Erro --- ESTADO NÃO EXISTENTE!" + "\n" +
                            "Estado: " + estado);
                    break;
            }
        
        
        estado = tabelaTransicao[estado][this.mapaCaracter(c)];
        
        if(estado == -1){
            estado = 0;
            c = caracter.read();
        }
        
        if(this.mapaCaracter(c) != FimArquivo           &&
           estado != 0                                  ){
                c = caracter.read();
        }
        
        
        if(this.mapaCaracter(c) == FimArquivo                   &&
           estado == 0                                          &&
           lexemas.get(lexemas.size()-1).getToken() != tokenFim ){
                
                lexemas.add(new Lexema("FIM DO ARQUIVO",tokenFim));
                this.setLinha(linha);
                numeroLexemas += 1;
        }
        //System.out.print((char)c);
        //System.out.println("[" + (char)c +",  " + estado  + "]");
        if(this.mapaCaracter(c) != FimArquivo       &&
           estado == 0                              ){
            break;
        }
}   while(estado != 0);
    
    
    //System.out.println("\n");
    
    return lexemas.get(lexemas.size()-1);
}

public int mapaTipo(){
    switch(estado){
        case 1:     case 6:     
            return tipoInteiro;
        case 3:     case 13:
            return tipoReal;
        case 15:
            return tipoLiteral;
        default:
            return 0;
    }
}

public int mapaCaracter(int c){
    switch(c){
        case 10: return BarraN;//   \n
        case 9 : return Espaco;//   \t
        case 13: return BarraN;//   \r
        case 32: return Espaco;//   espaço
        case -1: return FimArquivo;
        
        default: 
            
            if(Character.isAlphabetic((char)c)){
                if((char) c == 'e' || (char) c =='E'){
                    return E;
                }
                return L;
            }
            else if(Character.isDigit((char)c)){
                return D;
            }
            switch((char) c) {
                case ' ' : return Espaco;
                case '_' : return Underline;
                case '+' : return Soma;
                case '-' : return Subtracao;
                case '*' : return Vezes;
                case '/' : return Divisao;
                case '\"': return AspasDuplas;
                case '.' : return Ponto;
                case ';' : return PontoVirgula;
                case '<' : return Menor;
                case '>' : return Maior;
                case '=' : return Igual;
                case '(' : return AbreParenteses;
                case ')' : return FechaParenteses;
                case '{' : return AbreChaves;
                case '}' : return FechaChaves;
                default  : return Outro;
        }
    }
    
    
        
        
    }


}
  
    


 

