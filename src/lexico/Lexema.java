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

public class Lexema {
    private String lexema = "";
    private int token;
    private int tipo = 0;
    private int linha = 0;//linha onde o lexema se encontra
    private String classe = "";
    
    
    public void setClasse(String classe){
        this.classe = classe;
    }
    
    public String getClasse(){
        return classe;
    }
    
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
//    public static String getStringTipo(int tipo){
//        switch(tipo){
//            case AnalisadorLexico.tipoInteiro                   : return "INTEIRO";
//            case AnalisadorLexico.tipoLiteral                   : return "LITERAL";
//            case AnalisadorLexico.tipoReal                      : return "REAL";
//            case AnalisadorLexico.palavraReservadaInteiro       : return "PALAVRA RESERVADA(INTEIRO)";
//            case AnalisadorLexico.palavraReservadaReal          : return "PALAVRA RESERVADA(REAL)";
//            case AnalisadorLexico.palavraReservadaLiteral       : return "PALAVRA RESERVADA(LITERAL)";
//            default: return "";
//        }
//    }
    
    public int getIntTipo(String tipo){
        switch(tipo){
            case "INTEIRO":
                return AnalisadorLexico.tipoInteiro;
            case "LITERAL":
                return AnalisadorLexico.tipoLiteral;
            case "REAL":
                return AnalisadorLexico.tipoReal;
            case ">":
                return AnalisadorLexico.tipoMaior;
            case "<>":
                return AnalisadorLexico.tipoDiferente;
            case ">=":
                return AnalisadorLexico.tipoMaiorIgual;
            case "<":
                return AnalisadorLexico.tipoMenor;
            case "<=":
                return AnalisadorLexico.tipoMenorIgual;
            case "=":
                return AnalisadorLexico.tipoRCB;
            case "==":
                return AnalisadorLexico.tipoIgual;
            default:
                return 0;
        }
    }
    
    
    public String getStringTipo(){
        switch(tipo){
            case AnalisadorLexico.tipoInteiro                   : return "INTEIRO";
            case AnalisadorLexico.tipoLiteral                   : return "LITERAL";
            case AnalisadorLexico.tipoReal                      : return "REAL";
//            case AnalisadorLexico.palavraReservadaInteiro       : return "INTEIRO";
//            case AnalisadorLexico.palavraReservadaReal          : return "REAL";
//            case AnalisadorLexico.palavraReservadaLiteral       : return "LITERAL";
         // OPR---------------------------------------------------------------------------------------  
            case AnalisadorLexico.tipoMaior                     : return ">";
            case AnalisadorLexico.tipoDiferente                 : return "<>";
            case AnalisadorLexico.tipoMaiorIgual                : return ">=";
            case AnalisadorLexico.tipoMenor                     : return "<";
            case AnalisadorLexico.tipoMenorIgual                : return "<=";
            case AnalisadorLexico.tipoIgual                     : return "==";
         // OPM----------------------------------------------------------------------------------------
            case AnalisadorLexico.tipoSoma                      : return "+";
            case AnalisadorLexico.tipoSubtracao                 : return "-";
            case AnalisadorLexico.tipoMultiplicacao             : return "*";
            case AnalisadorLexico.tipoDivisao                   : return "/";
         // -------------------------------------------------------------------------------------------
            case AnalisadorLexico.tipoRCB                       : return "=";
            case AnalisadorLexico.tipoAbreParenteses            : return "(";
            case AnalisadorLexico.tipoFechaParenteses           : return ")";
            default: return "";
        }
    }
    
    public String getLexema(){
        return this.lexema;
    }
    public void concatenarLexema(int lexema){
        this.lexema = this.lexema + (char)lexema;
    }
    
    public void concatenarLexema(char lexema){// concatena valor inicial(String vazia) com o char recebido
        this.lexema = this.lexema + lexema;
    }
    
    public int getLinha(){
        return linha;
    }
    
    public void setLinha(int linha){
        this.linha = linha;
    }
    
    public void setLexema(String lexema){
        this.lexema=lexema;
    }
    
    public int getToken(){
        return this.token;
    }
    
    public String getStringToken(){
        switch(token){
            case AnalisadorLexico.tokenNumero:              return "NUMERAL";
            case AnalisadorLexico.tokenAbreParenteses:      return "AB_P";
            case AnalisadorLexico.tokenFechaParenteses:     return "FC_P";
            case AnalisadorLexico.tokenDeclaracao:          return "RCB";
            case AnalisadorLexico.tokenPontoVirgula:        return "PONTO E VIRGULA";
            case AnalisadorLexico.tokenLiteral:             return "LITERAL";
//OPM----------------------------------------------------------------------------
            case AnalisadorLexico.tokenMais:                return "OPM";
            case AnalisadorLexico.tokenMenos:               return "OPM";
            case AnalisadorLexico.tokenMultiplicacao:       return "OPM";
            case AnalisadorLexico.tokenDivisao:             return "OPM";
//FIM OPM------------------------------------------------------------------------
            
//OPR----------------------------------------------------------------------------
            case AnalisadorLexico.tokenDiferente:           return "OPR";
            case AnalisadorLexico.tokenIgual:               return "OPR";
            case AnalisadorLexico.tokenMenor:               return "OPR";
            case AnalisadorLexico.tokenMenorIgual:          return "OPR";
            case AnalisadorLexico.tokenMaior:               return "OPR";
            case AnalisadorLexico.tokenMaiorIgual:          return "OPR";
//FIM OPR------------------------------------------------------------------------
            
//ID E PALAVRAS RESERVADAS-------------------------------------------------------
            case AnalisadorLexico.tokenId:                          return "ID";
            case AnalisadorLexico.tokenEntao:                       return "ENTAO";
            case AnalisadorLexico.tokenEscreva:                     return "ESCREVA";
            case AnalisadorLexico.tokenFim:                         return "FIM DO ARQUIVO";
            case AnalisadorLexico.tokenFimSe:                       return "FIMSE";
            case AnalisadorLexico.tokenLeia:                        return "LEIA";
            case AnalisadorLexico.tokenInicio:                      return "INICIO";
            case AnalisadorLexico.tokenVarInicio:                   return "VARINICIO";
            case AnalisadorLexico.tokenVarFim:                      return "VARFIM";
            case AnalisadorLexico.tokenSe:                          return "SE";
            case AnalisadorLexico.palavraReservadaInteiro:          return "PALAVRA RESERVADA(INTEIRO)";
            case AnalisadorLexico.palavraReservadaReal:             return "PALAVRA RESERVADA(REAL)";
            case AnalisadorLexico.palavraReservadaLiteral:          return "PALAVRA RESERVADA(LITERAL)";
//FIM ID E PALAVRAS RESRVADAS----------------------------------------------------
            case AnalisadorLexico.tokenCifrao:                      return "CIFRÃO";
            default: return "ERRO";
        }
    }
    public void setToken(int token){
        this.token = token;
    }
//CONSTRUTORES DA CLASSE---------------------------------------------------------
    public Lexema(){
        
    }
    public Lexema(int lexema){
        this.lexema = this.lexema + (char) lexema;
    }
    
    public Lexema(int lexema, int token){
        this.lexema = this.lexema + (char) lexema;
        this.token = token;
    }
    
    public Lexema(String lexema){
        this.lexema = lexema;
    }
    
    public Lexema(String lexema, int token, int tipo){
        this.lexema = lexema;
        this.token = token;
        this.tipo = tipo;
    }
    
    public Lexema(String lexema, int token, int tipo, int linha){
        this.lexema = lexema;
        this.token = token;
        this.tipo = tipo;
        this.linha = linha;
    }
    
    public Lexema(String lexema, int token, int tipo, int linha, String classe){
         this.lexema = lexema;
         this.token = token;
         this.tipo = tipo;
         this.linha = linha;
         this.classe = classe;
     }
    
    public Lexema(String lexema, int token, int tipo, String classe){
         this.lexema = lexema;
         this.token = token;
         this.tipo = tipo;
         this.classe = classe;
     }
    
    public Lexema(String lexema, int token){
        this.lexema = lexema;
        this.token = token;
    }
    
    public Lexema(int lexema, int token, int linha){
        this.lexema = this.lexema + (char) lexema;
        this.token = token;
        this.linha = linha;
    }
}
//FIM CONSTRUTORES DA CLASSE-----------------------------------------------------