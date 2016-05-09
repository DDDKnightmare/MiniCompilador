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
import javax.swing.JFileChooser;
import javax.swing.JComponent;
import javax.accessibility.Accessible;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
/**
 *
 * @author GMTH
 */
public class SelecaoArquivo extends JComponent implements Accessible {
    public JFileChooser escolheArquivo;
    final FileNameExtensionFilter formatoArquivo = new FileNameExtensionFilter("Arquivos .ALG","ALG");// filtro para arquivos ALG
    
    public SelecaoArquivo(){
        escolheArquivo = new JFileChooser();
        escolheArquivo.setFileFilter(formatoArquivo);
    }
    
    public File retornaArquivo(){
        int returnVal = escolheArquivo.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){//botao "open" foi clicado
            return escolheArquivo.getSelectedFile();
        }else System.exit(0);
         return null;// botao cancel foi clicado, para a execucao
    }

}

