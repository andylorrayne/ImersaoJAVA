import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        int a = Integer.parseInt(JOptionPane.showInputDialog("O que você gostaria de ver: \n1-Melhores Filmes \n2-Filmes Populares \n3-Melhores séries \n4- Séries Pouplares\n5 - Imagens da NASA\n"));

        var conexao = new ClienteHTTP();
        var TrataDadosNASA = new TrataDadosNASA();
        var TrataDadosIMDB = new TrataDadosIMDB();
        

        if (a == 5){

            //NASA
                String url = "https://api.nasa.gov/planetary/apod?api_key=Ct8lUUsKx3AyA3N1CKIL1LRBU5bEP42T3VBXhEGd&start_date=2022-04-26&end_date=2022-04-28";
                var conteudoAPI = conexao.consumaAPI(url);
                var listaconteudo = TrataDadosNASA.extraiConteudo(conteudoAPI);
                var geradora = new FabricaDeFigurinhas();
                

                System.out.println();

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

            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
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

            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
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

            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
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
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
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
            
