import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        int a = Integer.parseInt(JOptionPane.showInputDialog("O que você gostaria de ver: \n1-Melhores Filmes \n2-Filmes Populares \n3-Melhores séries \n4- Séries Pouplares\n5 - Imagens da NASA\n"));

        var conexao = new ClienteHTTP();
        var TrataDadosNASA = new TrataDadosNASA();
        var TrataDadosIMDB = new TrataDadosIMDB();
        

        if (a == 5){

            //NASA

                URLsAPI api = URLsAPI.URL_API_NASA;
                String url = api.getUrl();
                var conteudoAPI = conexao.consumaAPI(url);
                var listaconteudo = TrataDadosNASA.extraiConteudo(conteudoAPI);
                var geradora = new FabricaDeFigurinhas();

                //FuncaoLaco(listaconteudo);
                

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

        if (a == 1){
            //MELHORES FILMES
            URLsAPI api = URLsAPI.URL_API_IMDB1;
            String url = api.getUrl();
            var conteudoAPI = conexao.consumaAPI(url);
            var listaconteudo = TrataDadosIMDB.extraiConteudo(conteudoAPI);
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

        if (a == 2){
            //FILMES POPULARES
            URLsAPI api = URLsAPI.URL_API_IMDB2;
            String url = api.getUrl();
            var conteudoAPI = conexao.consumaAPI(url);
            var listaconteudo = TrataDadosIMDB.extraiConteudo(conteudoAPI);
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

        if (a == 3){
            //MELHORES SÉRIES

            URLsAPI api = URLsAPI.URL_API_IMDB3;
            String url = api.getUrl();
            var conteudoAPI = conexao.consumaAPI(url);
            var listaconteudo = TrataDadosIMDB.extraiConteudo(conteudoAPI);
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

        if (a == 4){
            //MELHORES SÉRIES
            URLsAPI api = URLsAPI.URL_API_IMDB4;
            String url = api.getUrl();
            var conteudoAPI = conexao.consumaAPI(url);
            var listaconteudo = TrataDadosIMDB.extraiConteudo(conteudoAPI);
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

   
}
            
