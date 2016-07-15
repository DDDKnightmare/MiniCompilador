
package sintatico;
import lexico.Lexema;
/**
 *
 * @author guilhermeferreira
 */
public class Atributos {
    
    private String variavel; // terminal ou não terminal.
    private Lexema lexema;
    
    //get
    public String getVar(){
        return variavel;
    }
    
    public int getLinha(){
        return lexema.getLinha();
    }
    
    public String getLexema(){
        return lexema.getLexema();
    }
    
    public String getStringTipo(){
        return lexema.getStringTipo();
    }
    
    public int getToken(){
        return lexema.getToken();
    }
    
    public String getStringToken(){
        return lexema.getStringToken();
    }
    
    public int getTipo(){
        return lexema.getTipo();
    }
    
    public String getClasse(){
        return lexema.getClasse();
    }
    //Fim get
    
    //set
    public void setVariavel(String var){
        this.variavel = var;
    }
    
    public void setLexema(String lex){
        this.lexema.setLexema(lex);
    }
    
    public void setTipo(int tipo){
        this.lexema.setTipo(tipo);
    }
    
    public void setClasse(String classe){
        this.lexema.setClasse(classe);
    }
    
    //Fim set
    
    public Atributos(){
        
    }
    
    public Atributos(String variavel, Lexema lexema){
        this.variavel = variavel;
        this.lexema = lexema;
    }
    
    
}
