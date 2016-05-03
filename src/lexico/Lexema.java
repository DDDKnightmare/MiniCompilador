/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexico;



public class Lexema {
    private String lexema = "";
    private int token;
    private int tipo = 0;
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public String getStringTipo(){
        switch(tipo){
            case AnalisadorLexico.tipoInteiro     : return "INTEIRO";
            case AnalisadorLexico.tipoLiteral     : return "LITERAL";
            case AnalisadorLexico.tipoReal        : return "REAL";
            case AnalisadorLexico.palavraReservada: return "PALAVRA RESERVADA";
            default: return "";
        }
    }
    
    public String getLexema(){
        return this.lexema;
    }
    public void concatenarLexema(int lexema){
        this.lexema = this.lexema + (char)lexema;
    }
    
    public void concatenarLexema(char lexema){
        this.lexema = this.lexema + lexema;
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
            case AnalisadorLexico.tokenMais:                return "OPM(+)";
            case AnalisadorLexico.tokenMenos:               return "OPM(-)";
            case AnalisadorLexico.tokenMultiplicacao:       return "OPM(*)";
            case AnalisadorLexico.tokenDivisao:             return "OPM(/)";
//FIM OPM------------------------------------------------------------------------
            
//OPR----------------------------------------------------------------------------
            case AnalisadorLexico.tokenDiferente:           return "OPR(<>)";
            case AnalisadorLexico.tokenIgual:               return "OPR(=)";
            case AnalisadorLexico.tokenMenor:               return "OPR(<)";
            case AnalisadorLexico.tokenMenorIgual:          return "OPR(<=)";
            case AnalisadorLexico.tokenMaior:               return "OPR(>)";
            case AnalisadorLexico.tokenMaiorIgual:          return "OPR(>=)";
//FIM OPR------------------------------------------------------------------------
            
//ID E PALAVRAS RESERVADAS-------------------------------------------------------
            case AnalisadorLexico.tokenId:                  return "ID";
            case AnalisadorLexico.tokenEntao:               return "ENTAO";
            case AnalisadorLexico.tokenEscreva:             return "ESCREVA";
            case AnalisadorLexico.tokenFim:                 return "FIM DO ARQUIVO";
            case AnalisadorLexico.tokenFimSe:               return "FIMSE";
            case AnalisadorLexico.tokenLeia:                return "LEIA";
            case AnalisadorLexico.tokenInicio:              return "INICIO";
            case AnalisadorLexico.tokenVarInicio:           return "VARINICIO";
            case AnalisadorLexico.tokenVarFim:              return "VARFIM";
            case AnalisadorLexico.tokenSe:                  return "SE";
            case AnalisadorLexico.palavraReservada:         return "PALAVRA RESERVADA";
//FIM ID E PALAVRAS RESRVADAS----------------------------------------------------
            default: return "ERRO";
        }
    }
    public void setToken(int token){
        this.token = token;
    }
    
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
    
    public Lexema(String lexema, int token){
        this.lexema = lexema;
        this.token = token;
    }
    
}