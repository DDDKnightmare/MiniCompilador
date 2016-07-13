
package sintatico;

/**
 *
 * @author guilhermeferreira
 */
public class Atributos {
    
    private String variavel; // terminal ou não terminal.
    private String lexema; 
    private String tipo;
    private String classe;
    
    //get
    public String getVar(){
        return variavel;
    }
    
    public String getLexema(){
        return lexema;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getClasse(){
        return classe;
    }
    //Fim get
    
    //set
    public void setVariavel(String var){
        this.variavel = var;
    }
    
    public void setLexema(String lex){
        this.lexema = lex;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setClasse(String classe){
        this.classe = classe;
    }
    
    //Fim set
    
    public Atributos(){
        
    }
    
    public Atributos(String variavel, String lexema, String tipo, String classe){
        this.variavel = variavel;
        this.lexema = lexema;
        this.tipo = tipo;
        this.classe = classe;
    }
    
    
}
