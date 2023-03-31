import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
// CLASSE NÃO FUNCIONAL, AINDA EM MANUTENÇÃO.
public class FuncaoLaco {
    
    public FuncaoLaco(List listaconteudo) {

        var geradora = new FabricaDeFigurinhas();

        for (Conteudo conteudo : listaconteudo) {
            var titulo = conteudo.titulo();
            var urlImagem = conteudo.urLImagem();
            
            System.out.println(titulo);

            String nomeArquivo = titulo.replace(":", "-") + ".png";

            //InputStream icone= null;
            

            InputStream inputStream = new URL(urlImagem).openStream();
            
            InputStream icone =  new FileInputStream ( "./icon/eu-joinha.jpg") ;    
                            
            geradora.cria(nomeArquivo, inputStream, icone, titulo);

            System.out.println("\n");
            
        }
    }

}
