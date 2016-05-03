/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.util.*;


public class TabelaSimbolos{
    
    private static Hashtable<String, Lexema> simbolos = new Hashtable<String, Lexema>();
    
    public static void carregaPalavrasReservadas(){
        simbolos.put("inicio", new Lexema("inicio", AnalisadorLexico.tokenInicio, 0));
        simbolos.put("varinicio", new Lexema("varinicio", AnalisadorLexico.tokenVarInicio, 0));
        simbolos.put("varfim", new Lexema("varfim", AnalisadorLexico.tokenVarFim, 0));
        simbolos.put("escreva", new Lexema("escreva", AnalisadorLexico.tokenEscreva, 0));
        simbolos.put("leia", new Lexema("leia", AnalisadorLexico.tokenLeia, 0));
        simbolos.put("se", new Lexema("se", AnalisadorLexico.tokenSe, 0));
        simbolos.put("entao", new Lexema("entao", AnalisadorLexico.tokenEntao, 0));
        simbolos.put("fimse", new Lexema("fimse", AnalisadorLexico.tokenFimSe, 0));
        simbolos.put("fim", new Lexema("fim", AnalisadorLexico.tokenFim, 0));
        simbolos.put("inteiro", new Lexema("inteiro", AnalisadorLexico.palavraReservada, 0));
        simbolos.put("real", new Lexema("real", AnalisadorLexico.palavraReservada, 0));
        simbolos.put("literal", new Lexema("literal", AnalisadorLexico.palavraReservada, 0));
    }
    
    public static Lexema getSimbolo(String key){
     return simbolos.get(key);
    }
    
    public static boolean hasSimbolo(Lexema key){
        
        if(simbolos.containsKey(key.getLexema())){
                return true;
        }else{
            return false;
        }
    }
    
    public static void alteraSimbolo(Lexema key){
        simbolos.remove(key.getLexema());
        simbolos.put(key.getLexema(), key);
    }
    
    public static String getHashValue(String key){
        return simbolos.get(key).getLexema();
    }
    
    public static void removeSimbolo(String simbolo){
        simbolos.remove(simbolo);
    }
    
    public static void addSimbolo(Lexema simbolo){
        simbolos.put(simbolo.getLexema(), simbolo);
    }
    
    public static void imprimeHash(){
        for(String key : simbolos.keySet()){
            System.out.println("\n" + "key: " + key + "   |||||||   value: " + TabelaSimbolos.simbolos.get(key).getLexema());
        }
    }
}
