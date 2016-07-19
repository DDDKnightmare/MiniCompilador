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
import java.util.*;


public class TabelaSimbolos{
    
    public static Hashtable<String, Token> simbolos = new Hashtable<String, Token>();
    
    public static void carregaPalavrasReservadas(){
        simbolos.put("inicio", new Token("inicio", AnalisadorLexico.tokenInicio, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("varinicio", new Token("varinicio", AnalisadorLexico.tokenVarInicio, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("varfim", new Token("varfim", AnalisadorLexico.tokenVarFim, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("escreva", new Token("escreva", AnalisadorLexico.tokenEscreva, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("leia", new Token("leia", AnalisadorLexico.tokenLeia, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("se", new Token("se", AnalisadorLexico.tokenSe, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("entao", new Token("entao", AnalisadorLexico.tokenEntao, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("fimse", new Token("fimse", AnalisadorLexico.tokenFimSe, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("fim", new Token("fim", AnalisadorLexico.tokenFim, AnalisadorLexico.tipoPalavraReservada));
        simbolos.put("inteiro", new Token("inteiro", AnalisadorLexico.palavraReservadaInteiro, AnalisadorLexico.tipoInteiro));
        simbolos.put("real", new Token("real", AnalisadorLexico.palavraReservadaReal, AnalisadorLexico.tipoReal));
        simbolos.put("literal", new Token("literal", AnalisadorLexico.palavraReservadaLiteral, AnalisadorLexico.tipoLiteral));
    }
    
    public static Token getSimbolo(String key){
     return simbolos.get(key);
    }
    
    public static boolean hasSimbolo(Token key){
        
        if(simbolos.containsKey(key.getLexema())){
                return true;
        }else{
            return false;
        }
    }
    
    public static void alteraSimbolo(Token key){
        simbolos.remove(key.getLexema());
        simbolos.put(key.getLexema(), key);
    }
    
    public static String getHashValue(String key){
        return simbolos.get(key).getLexema();
    }
    
    public static void removeSimbolo(String simbolo){
        simbolos.remove(simbolo);
    }
    
    public static void addSimbolo(Token simbolo){
        simbolos.put(simbolo.getLexema(), simbolo);
    }
    
    public static void imprimeHash(){
        for(String key : simbolos.keySet()){
            System.out.println("\n" + "key: " + key + "   |||||||   value: " + TabelaSimbolos.simbolos.get(key).getLexema());
        }
    }
}
