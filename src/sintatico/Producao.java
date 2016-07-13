
package sintatico;

/**
 *
 * @author guilhermeferreira
 */
public class Producao {
    
    private String producao;
    private int codigoProducao;
    private int tamanho;
    private int ladoEsquerdo;
    
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
    public int getLadoEsquerdo(){
        return ladoEsquerdo;
    }
    
    
    
    public String getStringLadoEsquerdo(){
        switch (ladoEsquerdo){
            case 22:
                return "P";
            case 23:
                return "V";
            case 24:
                return "A";
            case 25:
                return "LV";
            case 26:
                return "D";
            case 27:
                return "TIPO";
            case 28:
                return "ES";
            case 29:
                return "ARG";
            case 30:
                return "CMD";
            case 31:
                return "LD";
            case 32:
                return "OPRD";
            case 33:
                return "COND";
            case 34:
                return "CABECALHO";
            case 35:
                return "CORPO";
            case 36:
                return "EXP_R";
            default:
                System.out.println( "\nErro: Não terminal inexistente! Código do não terminal que causou erro:" + ladoEsquerdo);
                System.exit(0);
                return "";
            
        }
    }
    
    public Producao(){
        
    }
    
    public Producao(String producao, int codigoProducao){
        this.producao = producao;
        this.codigoProducao = codigoProducao;
    }
    public Producao(String producao, int codigoProducao, int tamanho, int ladoEsquerdo){
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
