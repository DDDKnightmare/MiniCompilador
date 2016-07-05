
package sintatico;
import lexico.Lexema;
/**
 *
 * @author guilhermeferreira
 */
public class Producao {
    
    private String producao;
    private int codigoProducao;
    private int tamanho;
    private Lexema ladoEsquerdo;
    
    public String getProducao(){
        return producao;
    }
    
//    public void setProducao(String producao){
//        this.producao = producao;
//    }
    
    public int getCodigoProducao(){
        return codigoProducao;
    }
    
//    public void setCodigoProducao(int codigoProducao){
//        this.codigoProducao = codigoProducao;
//    }
    public int getTamanho(){
        return tamanho;
    }
    public Lexema getLadoEsquerdo(){
        return ladoEsquerdo;
    }
    public Producao(){
        
    }
    
    public Producao(String producao, int codigoProducao){
        this.producao = producao;
        this.codigoProducao = codigoProducao;
    }
    public Producao(String producao, int codigoProducao, int tamanho, Lexema ladoEsquerdo){
        this.producao = producao;
        this.codigoProducao = codigoProducao;
        this.tamanho = tamanho;
        this.ladoEsquerdo = ladoEsquerdo;
    }
    
    public Producao(String producao){
        this.producao = producao;
    }
    
    public Producao(int codigoProducao){
        this.codigoProducao = codigoProducao;
    }
}
