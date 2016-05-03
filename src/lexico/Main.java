/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;
import java.io.*;
import java.util.ArrayList;

public class Main{
/**
 *
 * @author Guilherme Flores && Nicole Tannus
 */ 
    public static SelecaoArquivo escolheArquivo = new SelecaoArquivo();
    
    public static AnalisadorLexico analisador = new AnalisadorLexico();
    
    
    
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
    
    
    
    
    while(analisador.getC() != -1){ //enquanto nao ler EOF
        imprimeLexemas();
    }
        imprimeLexemas();
        
        
        TabelaSimbolos.imprimeHash();
        //System.out.println(System.getProperty("os.name"));

}
}