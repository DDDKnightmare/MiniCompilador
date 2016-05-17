
package sintatico;

/**
 *
 * @author guilhermeferreira
 */
public class Producao {
    
    private String producao;
    private int codigoProducao;
    
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
    
    public Producao(){
        
    }
    
    public Producao(String producao, int codigoProducao){
        this.producao = producao;
        this.codigoProducao = codigoProducao;
    }
    
    public Producao(String producao){
        this.producao = producao;
    }
    
    public Producao(int codigoProducao){
        this.codigoProducao = codigoProducao;
    }
}
