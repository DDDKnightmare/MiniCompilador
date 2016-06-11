/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;
import sintatico.*;
import java.io.*;


public class Main{
/**
 *
 * @author Guilherme Flores && Nicole Tannus
 */ 
    public static SelecaoArquivo escolheArquivo = new SelecaoArquivo();
    
    public static AnalisadorLexico analisador = new AnalisadorLexico();
    public static AnalisadorSintatico sintatico = new AnalisadorSintatico();
    
    
    
    public static Lexema obterLexemas() throws IOException{
        
        return analisador.analisaTexto();
        
    }
    public static void imprimeLexemas() throws IOException{
        Lexema lexema = obterLexemas();
        System.out.println('[' + lexema.getLexema() + ", " +
        lexema.getStringToken() + ", " + lexema.getStringTipo()  +  ']');
        
    }
public static void main(String[] args) throws IOException {
    
    TabelaSimbolos.carregaPalavrasReservadas();
    
    analisador.carregaArquivo(escolheArquivo.retornaArquivo());
    
    sintatico.analisadorSintatico();
    
    //enquanto nao ler EOF
    /*while(analisador.mapaCaracter(analisador.getC()) != AnalisadorLexico.FimArquivo){ 
        //imprimeLexemas();
        
    }*/
        
        
   //     TabelaSimbolos.imprimeHash();

}
}